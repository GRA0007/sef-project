package view;

import java.util.Scanner;

public class ConsoleCallback {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to SSS");
        System.out.println();
        System.out.println("Please choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println();
        int option = scanner.nextInt();
        System.out.println("You chose " + String.valueOf(option));
    }
}
