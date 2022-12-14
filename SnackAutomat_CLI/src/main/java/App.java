import java.io.IOException;
import java.util.Scanner;

public class App {

    final static String[] EMOJIS = new String[]{"\uD83C\uDF71", "\uD83E\uDDC3", "\uD83C\uDF6C"};
    // Bento, Beverage, Sweet = Emoji
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        VendingMaschine vd = new VendingMaschine();

        final String KONAMI_CODE = "00223131ab";

        Person user;
        boolean isRunning = true;
        boolean isAdministrator = false;

        final String username = getUserInputString("What is Your name?");
        final float budget = getUserInputFloat("How much Money do you have?");

        user = new Person(username, budget);

        vd.printTitle();
        while (isRunning) {
            String userInput = getUserInputString("What do you want to do?");
            switch (userInput) {
                case "p", "P" -> useVendingMaschine();
                case "x", "X" -> {
                    isRunning = false;
                    System.out.println("Exiting The Program...");
                }
                case KONAMI_CODE -> {
                    isAdministrator = true;
                    System.out.println("Entering Admin Mode...");
                }
                case "h", "H" -> System.out.println("Enter the KONAMI Code");
                default -> System.err.println("Wrong Input. Please try Again!");
            }

            while (isAdministrator) {
                userInput = getUserInputString("What do you want to do?");
                switch (userInput) {
                    case "x", "X" -> {
                        isAdministrator = false;
                        System.out.println("Exiting Admin Mode");
                    }
                    case "a", "A" -> addItem(vd);
                    case "r", "R" -> replaceItem();
                    case "c", "C" -> fillUpItem();
                    case "f", "F" -> changePriceOfItem();
                    case "p", "P" -> vd.printItemList();
                    default -> System.err.println("Wrong Input. Please try Again!");
                }
            }
        }
    }

    public static String getUserInputString(String question){
        System.out.printf("%s: ", question);
        return scanner.nextLine();
    }

    public static int getUserInputInt(String question){
        System.out.printf("%s: ", question);
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static float getUserInputFloat(String question){
        System.out.printf("%s: ", question);
        float result = scanner.nextFloat();
        scanner.nextLine();
        return result;
    }

    public static String getUserEmojiInput(){
        printEmoji();
        int userInput = getUserInputInt("What Emoji describes the chosen Item the best?");
        switch (userInput){
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

    public static void useVendingMaschine() {
        //TODO implement the function
    }

    public static void addItem(VendingMaschine vd) {
        vd.addItem(
                getUserInputInt("What Number do you give?"),
                getUserInputString("What is this Item?"),
                getUserInputInt("What is the Amount?"),
                getUserInputFloat("What's the Price?"),
                getUserEmojiInput()
        );
    }

    public static void replaceItem() {
        //TODO implement the function
    }

    public static void fillUpItem() {
        //TODO implement the function
    }

    public static void changePriceOfItem() {
        //TODO implement the function
    }

    public static void printEmoji(){
        for (int i = 0; i < EMOJIS.length; i++) {
            System.out.printf("%d: %s\n", i + 1, EMOJIS[i]);
        }
        System.out.println("4: none");
    }
}
