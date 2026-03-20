package model;

import state.CancelledState;
import state.NewOrderState;
import state.OrderState;
import strategy.PaymentStrategy;

public class Order {

    private final String id;
    private final String productName;
    private final double price;
    private OrderState state;
    private PaymentStrategy paymentStrategy;

    public Order(String id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.state = new NewOrderState();
    }

    // ---- State Pattern ----
    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        System.out.println("\n>> Trang thai hien tai: " + state.getStatus());
        state.handle(this);
    }

    public void cancel() {
        System.out.println("\n>> Huy don hang...");
        setState(new CancelledState());
        state.handle(this);
    }

    // ---- Strategy Pattern ----
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public String checkout() {
        if (paymentStrategy == null) {
            return "  [LOI] Chua chon phuong thuc thanh toan!";
        }
        System.out.println("  Phuong thuc: " + paymentStrategy.getMethodName());
        return paymentStrategy.pay(price);
    }

    public String getId() { return id; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getStatus() { return state.getStatus(); }
}
