package view;

import model.Staff;
import model.Storage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCallback {
    private Scanner scanner = new Scanner(System.in);
    private Storage storage = new Storage();
    private Staff currentUser = null;

    // Get user choice from a menu of options
    private Integer getChoice(String[] choices) {
        Integer choice = null;

        while (choice == null) {
            System.out.println("\nPlease choose an option:");
            for (int i = 1; i <= choices.length; i++) {
                System.out.println(String.valueOf(i) + ". " + choices[i - 1]);
            }
            System.out.println();
            try {
                int next = Integer.parseInt(scanner.nextLine());
                if (next > 0 && next <= choices.length) {
                    choice = next - 1;
                } else {
                    System.out.print("\nInvalid input, enter a number from the following list.");
                }
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid input, must be a number.");
            }
        }
        return choice;
    }

    // Start the system
    public void start() {

        System.out.print(
                "         ########         ########         ########\n" +
                "       #####            #####            #####     \n" +
                "      ####             ####             ####       \n" +
                "       ####             ####             ####      \n" +
                "         ####             ####             ####    \n" +
                "           ####             ####             ####  \n" +
                "         #####            #####            #####   \n" +
                "     ########         ########         ########    \n");
        System.out.println("\n                    Welcome to SSS");
        System.out.println("Loading data...");
        storage.loadData();
        System.out.println();
        String[] options = new String[] {"Login", "Sign up"};
        if (getChoice(options) == 0) {
            login();
        } else {
            signup();
        }
    }

    private void login() {

        System.out.println("\nLogin to SSS");
        System.out.print("Staff number: ");
        String staffId = scanner.nextLine();
        //TODO: validity checking
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        currentUser = storage.authUser(staffId, pass);
        if (currentUser == null) {
            System.out.println("\nLogin details incorrect. Try again.");
            login();
        } else {
            // Logged in
            studentActions();
        }
    }

    private void signup() {
        System.out.println("\nSign up to SSS");
        System.out.print("Staff number: ");
        String staffId = scanner.nextLine();
        //TODO: validity checking
        System.out.print("New password: ");
        String pass = scanner.nextLine();
        System.out.print("New password (again): ");
        String passCheck = scanner.nextLine();

        if (!pass.equals(passCheck)) {
            System.out.println("\nPasswords must match. Try again.");
            signup();
        } else {
            currentUser = storage.addUser(staffId, pass);
            // Logged in
            studentActions();
        }
    }

    private void studentActions() {

    }
}
