import java.io.IOException;
import java.util.Scanner;

public class App {

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

        vd.printVendingMaschine();
        while (isRunning) {
            String userInput = getUserInputString("What do you want to do?");
            switch (userInput) {
                case "p", "P" -> useVendingMaschine();
                case "x", "X" -> isRunning = false;
                case KONAMI_CODE -> isAdministrator = true;
                default -> System.err.println("Wrong Input. Please try Again!");
            }

            while (isAdministrator) {
                userInput = getUserInputString("What do you want to do?");
                switch (userInput) {
                    case "x", "X" -> isAdministrator = false;
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
        return scanner.nextInt();
    }

    public static float getUserInputFloat(String question){
        System.out.printf("%s: ", question);
        return scanner.nextFloat();
    }

    public static void useVendingMaschine() {
        //TODO implement the function
    }

    public static void addItem(VendingMaschine vd) {
        vd.addItem(
                getUserInputInt("What Number do you give?"),
                getUserInputString("What is this Item?"),
                getUserInputInt("What is the Amount?"),
                getUserInputFloat("What's the Price?")
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
}
