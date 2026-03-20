package state;

import model.Order;

public class NewOrderState implements OrderState {

    @Override
    public void handle(Order order) {
        System.out.println("  [NEW ORDER] Kiem tra thong tin don hang: " + order.getId());
        System.out.println("  [NEW ORDER] Xac nhan san pham va dia chi giao hang.");
        order.setState(new ProcessingState());
    }

    @Override
    public String getStatus() {
        return "MOI TAO";
    }
}
