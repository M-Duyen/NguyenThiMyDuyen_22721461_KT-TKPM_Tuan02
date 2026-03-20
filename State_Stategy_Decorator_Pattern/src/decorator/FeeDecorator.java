package decorator;

import strategy.PaymentStrategy;

public class FeeDecorator extends PaymentDecorator {

    private static final double FEE_RATE = 0.015; // 1.5% phi xu ly

    public FeeDecorator(PaymentStrategy wrapped) {
        super(wrapped);
    }

    @Override
    public String pay(double amount) {
        double fee = amount * FEE_RATE;
        double total = amount + fee;
        System.out.printf("  [FEE] Cong phi xu ly 1.5%%: +%.2f VND%n", fee);
        return wrapped.pay(total);
    }

    @Override
    public String getMethodName() {
        return wrapped.getMethodName() + " + Phi xu ly";
    }
}
