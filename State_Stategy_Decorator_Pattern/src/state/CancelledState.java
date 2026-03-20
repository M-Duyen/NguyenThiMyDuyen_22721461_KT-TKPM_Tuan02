package state;

import model.Order;

public class CancelledState implements OrderState {

    @Override
    public void handle(Order order) {
        System.out.println("  [CANCELLED] Don hang " + order.getId() + " da bi huy.");
        System.out.println("  [CANCELLED] Tien hoa hoan ve tai khoan khach hang.");
    }

    @Override
    public String getStatus() {
        return "DA HUY";
    }
}
