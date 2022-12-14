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

        System.out.print("What is Your name?: ");
        final String username = sc.nextLine();
        System.out.print("How much Money do you have?: ");
        final float budget = sc.nextFloat();

        user = new Person(username, budget);

        vd.printVendingMaschine();
        while (isRunning) {
            System.out.println("What do you want to do?: ");
            String userInput = sc.nextLine();
            switch (userInput) {
                case "p", "P" -> useVendingMaschine();
                case "x", "X" -> isRunning = false;
                case KONAMI_CODE -> isAdministrator = true;
                default -> System.out.println("Wrong Input. Please try Again!");
            }

            while (isAdministrator) {
                System.out.println("What do you want to do?: ");
                userInput = sc.nextLine();
                switch (userInput) {
                    case "x", "X" -> isAdministrator = false;
                    case "a", "A" -> addItem();
                    case "r", "R" -> replaceItem();
                    case "c", "C" -> fillUpItem();
                    case "f", "F" -> changePriceOfItem();
                    case "p", "P" -> vd.printItemList();
                    default -> System.out.println("Wrong Input. Please try Again!");
                }
            }
        }
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
