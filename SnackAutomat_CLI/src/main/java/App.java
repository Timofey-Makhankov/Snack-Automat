import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    final static String[] EMOJIS = new String[]{"\uD83C\uDF71", "\uD83E\uDDC3", "\uD83C\uDF6C"};
    // Bento, Beverage, Sweet = Emoji
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        VendingMachine vd = new VendingMachine(3, 4);

        final String KONAMI_CODE = "00223131ab";

        vd.addItem(new Item("Coke", 23, 0.9f, 3));

        Person user;
        boolean isRunning = true;
        boolean isAdministrator = false;

        final String username = getUserInputString("What is your name?");
        final float budget = getUserInputFloat("How much money do you have?");

        user = new Person(username, budget);

        vd.printTitle();
        while (isRunning) {
            printStartCommands();
            String userInput = getUserInputString("What do you want to do?");
            switch (userInput) {
                case "u", "U" -> useVendingMachine(vd, user);
                case "x", "X" -> {
                    isRunning = false;
                    System.out.println("Exiting the program...");
                }
                case KONAMI_CODE -> {
                    isAdministrator = true;
                    System.out.println("Entering admin mode...");
                }
                case "h", "H" -> System.out.println("Enter the KONAMI code\n" + """
                           ↑
                           0
                        ← 3 1 →  Ⓐ Ⓑ
                           2
                           ↓
                        """);
                default -> System.out.println("Wrong input. Please try again!");
            }

            while (isAdministrator) {
                printAdminCommands();
                userInput = getUserInputString("What do you want to do?");
                switch (userInput) {
                    case "x", "X" -> {
                        isAdministrator = false;
                        System.out.println("Exiting admin mode");
                    }
                    case "a", "A" -> vd.addItem(createItem());
                    case "r", "R" -> replaceItem(vd);
                    case "f", "F" -> fillUpItem(vd);
                    case "c", "C" -> changePriceOfItem(vd);
                    case "p", "P" -> vd.printItemList();
                    case "b", "B" -> printBag(user); //System.out.println(user);
                    default -> System.out.println("Wrong input. Please try again!");
                }
            }
        }
    }

    public static void printBag(Person person){
        System.out.printf("Name: %s\nBudget: %.2f\nBag:\n", person.getPersonName(), person.getBudget());
        ArrayList<Item> bag = person.getBag();
        try {
            for (Item item:bag) {
                System.out.printf("%d %s %s %.2f\n", item.getId(), item.getImage(), item.getName(), item.getPrice());
            }
        } catch (Exception e){
            System.out.println("Empty");
        }


    }

    public static String getUserInputString(String question) {
        while (true) {
            System.out.printf("%s: ", question);
            String temp = scanner.nextLine();
            try {
                Integer.parseInt(temp);
                System.out.println("That doesn't work. Please enter a valid answer");
            } catch (Exception e) {
                return temp;
            }
        }
    }

    public static int getUserInputInt(String question) {
        while (true) {
            System.out.printf("%s: ", question);
            try {
                int result = scanner.nextInt();
                scanner.nextLine();
                return result;
            } catch (Exception e) {
                System.out.println("That doesn't work. Please enter a valid answer");
                scanner.nextLine();
            }
        }
    }

    public static float getUserInputFloat(String question) {
        while (true) {
            System.out.printf("%s: ", question);
            try {
                float result = scanner.nextFloat();
                scanner.nextLine();
                return result;
            } catch (Exception e) {
                System.out.println("That doesn't work. Please enter a valid answer");
                scanner.nextLine();
            }
        }
    }

    public static String getUserEmojiInput() {
        printEmoji();
        int userInput = getUserInputInt("What emoji describes the chosen item the best?");
        switch (userInput) {
            case 1 -> {
                return EMOJIS[0];
            }
            case 2 -> {
                return EMOJIS[1];
            }
            case 3 -> {
                return EMOJIS[2];
            }
            default -> {
                return "○";
            }
        }
    }

    public static void useVendingMachine(VendingMachine vd, Person user) {
        Item chosenItem = null;
        boolean addingMoney = true;
        while (true) {
            vd.ItemGrid();
            int userInput = getUserInputInt("What item do you want to get?");
            if (userInput == -1) {
                System.out.println("Exited");
                return;
            } else {
                if (isInList(userInput, vd.getItems())) {
                    int index = 0;
                    for (Item item : vd.getItems()) {
                        index += 1;
                        if (item.getId() == userInput) {
                            if (item.getAmount() == 0){
                                System.out.println("Sorry this product isn't avaible");
                            }else {
                                chosenItem = item;
                                addingMoney = true;
                                break;
                            }
                        }
                    }
                    if (chosenItem == null){
                        addingMoney = false;
                    }
                    assert chosenItem != null;
                    float pay = chosenItem.getPrice();
                    float leftMoney = pay;
                    while (addingMoney) {
                        float userInputMoney = getUserInputFloat(String.format("Please insert money %.2f", leftMoney));
                        leftMoney = pay - userInputMoney;
                        if (userInputMoney == -1) {
                            return;
                        } else {
                            user.setBudget(user.getBudget() - userInputMoney);
                            pay -= userInputMoney;
                            if (pay <= 0) {
                                user.setBudget(user.getBudget() + Math.abs(pay));
                                user.addToBag(chosenItem);
                                vd.getItems().get(index - 1).setAmount(vd.getItems().get(index - 1).getAmount() - 1);
                                addingMoney = false;
                            }
                        }
                    }
                } else {
                    System.out.println("The item was not found");
                }
            }
        }
    }

    public static Item createItem() {
        Item item = new Item(
                getUserInputString("What is this item?"),
                getUserInputInt("What number do you give?"),
                getUserInputFloat("What's the price?"),
                getUserInputInt("What is the amount?"));
        item.setImage(getUserEmojiInput());
        return item;
    }

    public static void replaceItem(VendingMachine vd) {
        vd.printItemList();
        vd.replaceItem(getUserInputInt("What item do you choose?"), createItem());
    }

    public static void fillUpItem(VendingMachine vd) {
        vd.printItemList();
        vd.fillUp(getUserInputInt("What item do you choose?"), getUserInputInt("How much do you want to add?"));
    }

    public static void changePriceOfItem(VendingMachine vd) {
        vd.printItemList();
        vd.changePrice(getUserInputInt("What item do you choose?"), getUserInputFloat("What price do you give?"));
    }

    public static void printEmoji() {
        for (int i = 0; i < EMOJIS.length; i++) {
            System.out.printf("%d: %s\n", i + 1, EMOJIS[i]);
        }
        System.out.println("4: none");
    }

    public static void printAdminCommands() {
        System.out.print("""
                x -> Exit
                a -> Add item to vending machine
                r -> replace an item in vending machine
                f -> fill up an item
                c -> change price of an item
                p -> show the items in the vending machine
                b -> show budget of your account
                """);
    }

    public static void printStartCommands() {
        System.out.print("""
                x -> Exit
                u -> Use the vending machine
                h -> ???
                """);
    }

    public static Boolean isInList(int input, ArrayList<Item> array) {
        for (Item item : array) {
            if (input == item.getId()) {
                return true;
            }
        }
        return false;
    }
}
