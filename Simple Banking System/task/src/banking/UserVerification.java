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
}
