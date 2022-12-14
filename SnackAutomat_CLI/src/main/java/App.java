import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        VendingMaschine vd = new VendingMaschine();
        Scanner sc = new Scanner(System.in);

        final String KONAMI_CODE = "00223131ab";

        Person user;
        boolean isRunning = true;
        boolean isAdministrator = false;

        final String username = getUserInputString(sc, "What is Your name?");
        final float budget = getUserInputFloat(sc, "How much Money do you have?");

        user = new Person(username, budget);

        vd.printVendingMaschine();
        while (isRunning) {
            String userInput = getUserInputString(sc, "What do you want to do?");
            switch (userInput) {
                case "p", "P" -> useVendingMaschine();
                case "x", "X" -> isRunning = false;
                case KONAMI_CODE -> isAdministrator = true;
                default -> System.err.println("Wrong Input. Please try Again!");
            }

            while (isAdministrator) {
                userInput = getUserInputString(sc, "What do you want to do?");
                switch (userInput) {
                    case "x", "X" -> isAdministrator = false;
                    case "a", "A" -> addItem();
                    case "r", "R" -> replaceItem();
                    case "c", "C" -> fillUpItem();
                    case "f", "F" -> changePriceOfItem();
                    case "p", "P" -> vd.printItemList();
                    default -> System.err.println("Wrong Input. Please try Again!");
                }
            }
        }
    }

    public static String getUserInputString(Scanner sc, String question){
        System.out.printf("%s: ", question);
        return sc.nextLine();
    }

    public static int getUserInputInt(Scanner sc, String question){
        System.out.printf("%s: ", question);
        return sc.nextInt();
    }

    public static float getUserInputFloat(Scanner sc, String question){
        System.out.printf("%s: ", question);
        return sc.nextFloat();
    }

    public static void useVendingMaschine() {
        //TODO implement the function
    }

    public static void addItem() {
        //TODO implement the function
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
