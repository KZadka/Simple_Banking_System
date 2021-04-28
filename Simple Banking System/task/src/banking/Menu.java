package banking;

import java.util.Scanner;

public class Menu {

    static void menu(Scanner scanner) {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                creatingAccount();
                break;
            case 2:
                logging();
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
        }
    }
    static void creatingAccount() {
        UserCard card = new UserCard();
        System.out.println("Your card has been created");
        System.out.printf("Your card number:%n" + card.getCardNumber());
        System.out.printf("%nYour card PIN:%n%d%n", card.getPinNumber());
    }
    static void logging() {
        Scanner scanner = new Scanner(System.in);
        UserCard card = new UserCard();
        if (UserCard.cardDataVerification(scanner, card)) {
            System.out.println("You have successfully logged in!");
            loggedMenu();
        } else {
            System.out.println("Wrong card number or PIN!");
        }
    }
    static void loggedMenu() {
        UserCard card = new UserCard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("Balance: " + card.getBalance());
            case 2:
                System.out.println("You have successfully logged out!");
                menu(scanner);
            case 0:
                System.out.println("Bye!");
                System.exit(0);
        }
    }

}
