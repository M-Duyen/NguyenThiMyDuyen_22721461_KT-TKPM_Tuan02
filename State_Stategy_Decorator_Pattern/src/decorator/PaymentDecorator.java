package decorator;

import strategy.PaymentStrategy;

public abstract class PaymentDecorator implements PaymentStrategy {

    protected final PaymentStrategy wrapped;

    public PaymentDecorator(PaymentStrategy wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getMethodName() {
        return wrapped.getMethodName();
    }
}
