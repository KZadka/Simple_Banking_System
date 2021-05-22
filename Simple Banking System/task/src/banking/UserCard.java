package banking;

public class UserCard {
     private String cardNumber;
     private String pinNumber;
     private long balance;

    UserCard() {
        setCardNumber();
        setPinNumber();
        setBalance(0);
    }

     public String getCardNumber() {
         return cardNumber;
     }

     public String getPinNumber() {
         return pinNumber;
     }

     public void setCardNumber() {
        this.cardNumber = Random_generator.checksum();
     }
     public void setPinNumber() {
        this.pinNumber = Random_generator.pinNumber();
     }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

 }
