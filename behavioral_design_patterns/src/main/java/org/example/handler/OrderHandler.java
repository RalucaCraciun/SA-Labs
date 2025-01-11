package org.example.handler;

import org.example.Order;

public abstract class OrderHandler {
    private OrderHandler nextHandler;

    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Order order) {
        if (nextHandler != null) {
            nextHandler.handle(order);
        }
    }
}
