package decorator;

import strategy.PaymentStrategy;

public class DiscountDecorator extends PaymentDecorator {

    private final String discountCode;
    private static final double DISCOUNT_RATE = 0.10;

    public DiscountDecorator(PaymentStrategy wrapped, String discountCode) {
        super(wrapped);
        this.discountCode = discountCode;
    }

    @Override
    public String pay(double amount) {
        double discount = amount * DISCOUNT_RATE;
        double total = amount - discount;
        System.out.printf("  [DISCOUNT] Ma giam gia '%s' (10%%): -%.2f VND%n", discountCode, discount);
        return wrapped.pay(total);
    }

    @Override
    public String getMethodName() {
        return wrapped.getMethodName() + " + Ma giam gia [" + discountCode + "]";
    }
}
