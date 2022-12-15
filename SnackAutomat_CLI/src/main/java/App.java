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

        Person user;
        boolean isRunning = true;
        boolean isAdministrator = false;

        final String username = getUserInputString("What is Your name?");
        final float budget = getUserInputFloat("How much Money do you have?");

        user = new Person(username, budget);

        vd.printTitle();
        while (isRunning) {
            printStartCommands();
            String userInput = getUserInputString("What do you want to do?");
            switch (userInput) {
                case "u", "U" -> useVendingMachine(vd, user);
                case "x", "X" -> {
                    isRunning = false;
                    System.out.println("Exiting The Program...");
                }
                case KONAMI_CODE -> {
                    isAdministrator = true;
                    System.out.println("Entering Admin Mode...");
                }
                case "h", "H" -> System.out.println("Enter the KONAMI Code\n" + """
                           ↑
                           0
                        ← 3 1 →  Ⓐ Ⓑ
                           2
                           ↓
                        """);
                default -> System.err.println("Wrong Input. Please try Again!");
            }

            while (isAdministrator) {
                printAdminCommands();
                userInput = getUserInputString("What do you want to do?");
                switch (userInput) {
                    case "x", "X" -> {
                        isAdministrator = false;
                        System.out.println("Exiting Admin Mode");
                    }
                    case "a", "A" -> vd.addItem(createItem());
                    case "r", "R" -> replaceItem(vd);
                    case "f", "F" -> fillUpItem(vd);
                    case "c", "C" -> changePriceOfItem(vd);
                    case "p", "P" -> vd.printItemList();
                    case "b", "B" -> System.out.println(user);
                    default -> System.err.println("Wrong Input. Please try Again!");
                }
            }
        }
    }

    public static String getUserInputString(String question) {
        while (true) {
            System.out.printf("%s: ", question);
            String temp = scanner.nextLine();
            try {
                int num;
                num = Integer.parseInt(temp);
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
        int userInput = getUserInputInt("What Emoji describes the chosen Item the best?");
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
            int userInput = getUserInputInt("What Item do you want to get?");
            if (userInput == -1) {
                System.err.println("Exited");
                return;
            } else {
                if (isInList(userInput, vd.getItems())) {
                    for (Item item : vd.getItems()) {
                        if (item.getId() == userInput) {
                            chosenItem = item;
                            break;
                        }
                    }
                    assert chosenItem != null;
                    float pay = chosenItem.getPrice();
                    do {
                        float userInputMoney = getUserInputFloat("Please Insert Money");
                        if (userInputMoney == -1) {
                            return;
                        } else {
                            user.setBudget(user.getBudget() - userInputMoney);
                            pay -= userInputMoney;
                            if (pay <= 0) {
                                user.setBudget(user.getBudget() + Math.abs(pay));
                                user.addToBag(chosenItem);
                                addingMoney = false;
                            }
                        }
                    } while (addingMoney);
                } else {
                    System.err.println("The Item was not found");
                }
            }
        }
    }

    public static Item createItem() {
        Item item = new Item(
                getUserInputString("What is this Item?"),
                getUserInputInt("What Number do you give?"),
                getUserInputFloat("What's the Price?"),
                getUserInputInt("What is the Amount?"));
        item.setImage(getUserEmojiInput());
        return item;
    }

    public static void replaceItem(VendingMachine vd) {
        vd.printItemList();
        vd.replaceItem(getUserInputInt("What Item do you choose?"), createItem());
    }

    public static void fillUpItem(VendingMachine vd) {
        vd.printItemList();
        vd.fillUp(getUserInputInt("What Item do you choose?"), getUserInputInt("How much do you want to add?"));
    }

    public static void changePriceOfItem(VendingMachine vd) {
        vd.printItemList();
        vd.changePrice(getUserInputInt("What Item do you choose?"), getUserInputFloat("What price do you give?"));
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
                a -> Add Item to Vending Machine
                r -> replace an Item in Vending Machine
                f -> fill up an Item
                c -> change price of an Item
                p -> show the Items in the Vending Machine
                b -> show Budget of your account
                """);
    }

    public static void printStartCommands() {
        System.out.print("""
                x -> Exit
                u -> Use the Vending machine
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
