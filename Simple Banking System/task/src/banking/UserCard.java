package banking;

import java.util.Scanner;

public class UserCard {

     Random_generator generator = new Random_generator();
     private String cardNumber;
     private int pinNumber;
     private long balance;

    UserCard() {
        setCardNumber();
        setPinNumber();
        setBalance(0);
    }

     public String getCardNumber() {
         return cardNumber;
     }

     public int getPinNumber() {
         return pinNumber;
     }

     public void setCardNumber() {
        this.cardNumber = generator.cardNumber();
     }
     public void setPinNumber() {
        this.pinNumber = generator.pinNumber();
     }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    static boolean cardDataVerification(Scanner scanner, UserCard card) {
         System.out.println("Enter your card number:");
         String tempCardNumber = scanner.nextLine();
         System.out.println("Enter your PIN:");
         int tempPin = Integer.parseInt(scanner.nextLine());

         return card.getCardNumber().equals(tempCardNumber) &&
                 card.getPinNumber() == tempPin;
     }

 }
