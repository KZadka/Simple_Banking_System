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
        app.insertNewAccount(card.getCardNumber(), card.getPinNumber(), 0);
        System.out.println("Your card has been created");
        System.out.printf("Your card number:%n" + card.getCardNumber());
        System.out.printf("%nYour card PIN:%n%s%n", card.getPinNumber());
    }

    static void loggedMenu(UserCard card, Scanner scanner) {
        System.out.println("1. Balance");
        System.out.println("2. Add income");
        System.out.println("3. Do transfer");
        System.out.println("4. Close account");
        System.out.println("5. Log out");
        System.out.println("0. Exit");
        int userInput = scanner.nextInt();
        QuerryApp app = new QuerryApp();
        InsertApp appI = new InsertApp();
        switch (userInput) {
            case 1:
                System.out.print("Balance: "); app.showBalance(card.getCardNumber());
                loggedMenu(card, scanner);
                break;
            case 2:
                System.out.println("Enter income: ");
                int income = scanner.nextInt();
                appI.updateIncome(income, card.getCardNumber());
                loggedMenu(card, scanner);
                break;
            case 3:
                UserVerification verification = new UserVerification();
                System.out.println("Transfer");
                System.out.println("Enter card number: ");
                String targetCardNumber = scanner.next();
                if (verification.cardVerificationForTransfer(targetCardNumber, card.getCardNumber())) {
                    System.out.println("Enter how much money you want to transfer: ");
                    int amount = scanner.nextInt();
                    appI.transfer(targetCardNumber, card.getCardNumber(), amount);
                    loggedMenu(card, scanner);
                } else {
                    verification.cardVerificationForTransfer(targetCardNumber, card.getCardNumber());
                    loggedMenu(card, scanner);
                }
                break;
            case 4:
                break;
            case 5:
                System.out.println("You have successfully logged out!");
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
        }
    }

}