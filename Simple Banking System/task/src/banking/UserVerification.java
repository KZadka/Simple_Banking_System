package banking;

import java.util.Scanner;

public class UserVerification {

    Scanner scanner = new Scanner(System.in);
    void logging(UserCard card) {
        if (cardDataVerification(card)) {
            System.out.println("You have successfully logged in!");
            Main.loggedMenu(card, scanner);
        } else {
            System.out.println("Wrong card number or PIN!");
        }
    }

    boolean cardDataVerification(UserCard card) {
        System.out.println("Enter your card number:");
        String tempCardNumber = scanner.nextLine();
        System.out.println(card.getCardNumber());
        System.out.println("Enter your PIN:");
        String tempPin = scanner.nextLine();
        System.out.println(card.getPinNumber());

        return tempCardNumber.equals(card.getCardNumber()) &&
                tempPin.equals(card.getPinNumber());
    }

    boolean cardVerificationForTransfer(String targetCardNumber, String userCardNumber) {
        QuerryApp app = new QuerryApp();
        if (Random_generator.luhnAlgCheck(targetCardNumber)) {
            System.out.println("Probably you made a mistake in the card number. Please try again!");
            return false;
        } else if (targetCardNumber.equals(userCardNumber)) {
            System.out.println("You can't transfer money to the same account!");
            return false;
        } else if (!(app.isCardNumber(targetCardNumber))) {
            System.out.println("Such a card does not exist.");
            return false;
        }
        return true;
    }

}
