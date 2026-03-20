package state;

import model.Order;

public class DeliveredState implements OrderState {

    @Override
    public void handle(Order order) {
        System.out.println("  [DELIVERED] Don hang " + order.getId() + " da duoc giao thanh cong.");
        System.out.println("  [DELIVERED] Cap nhat trang thai: HOAN THANH.");
    }

    @Override
    public String getStatus() {
        return "DA GIAO";
    }
}
