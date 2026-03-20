package state;

import model.Order;

public interface OrderState {
    void handle(Order order);
    String getStatus();
}
