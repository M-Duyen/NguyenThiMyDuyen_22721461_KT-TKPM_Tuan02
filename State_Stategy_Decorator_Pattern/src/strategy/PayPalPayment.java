package strategy;

public class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public String pay(double amount) {
        return String.format("  [PAYPAL] Thanh toan %.2f VND qua tai khoan PayPal: %s",
                amount, email);
    }

    @Override
    public String getMethodName() {
        return "PayPal";
    }
}
