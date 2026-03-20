package strategy;

public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String pay(double amount) {
        return String.format("  [THE TIN DUNG] Thanh toan %.2f VND qua the **** **** **** %s",
                amount, cardNumber.substring(cardNumber.length() - 4));
    }

    @Override
    public String getMethodName() {
        return "The tin dung";
    }
}
