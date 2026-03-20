package state;

import model.Order;

public class ProcessingState implements OrderState {

    @Override
    public void handle(Order order) {
        System.out.println("  [PROCESSING] Dang dong goi don hang: " + order.getId());
        System.out.println("  [PROCESSING] Chuyen giao cho don vi van chuyen.");
        order.setState(new DeliveredState());
    }

    @Override
    public String getStatus() {
        return "DANG XU LY";
    }
}
