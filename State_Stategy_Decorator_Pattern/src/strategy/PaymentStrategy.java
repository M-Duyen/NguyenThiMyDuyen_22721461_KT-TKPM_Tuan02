package strategy;

public interface PaymentStrategy {
    String pay(double amount);
    String getMethodName();
}
