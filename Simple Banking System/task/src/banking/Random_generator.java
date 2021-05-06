package banking;


public class Random_generator {

    static String cardNumber() {
        long identifier = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        return "400000".concat(String.valueOf(identifier));
    }
    static int pinNumber() {
        return  (int) Math.floor(Math.random() * 9000) + 1000;
    }


}
