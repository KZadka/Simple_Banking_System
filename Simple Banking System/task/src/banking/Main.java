package banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NewTable.createNewDatabase(args[1]);
        Connect.connect();
        NewTable.createNewTable();

        Scanner scanner = new Scanner(System.in);
        UserVerification userVerification = new UserVerification();
        UserCard  card = null;
        while (true) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    UserCard newCard = new UserCard();
                    creatingAccount(newCard);
                    card = newCard;
                    break;
                case 2:
                    userVerification.logging(card);
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
            }
        }

    }

    static void creatingAccount(UserCard card) {
        InsertApp app = new InsertApp();
        app.insert(card.getCardNumber(), card.getPinNumber(), 0);
        System.out.println("Your card has been created");
        System.out.printf("Your card number:%n" + card.getCardNumber());
        System.out.printf("%nYour card PIN:%n%s%n", card.getPinNumber());
    }

    static void loggedMenu(UserCard card, Scanner scanner) {
        System.out.println("1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("Balance: " + card.getBalance());
                loggedMenu(card, scanner);
                break;
            case 2:
                System.out.println("You have successfully logged out!");
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
        }
    }

}