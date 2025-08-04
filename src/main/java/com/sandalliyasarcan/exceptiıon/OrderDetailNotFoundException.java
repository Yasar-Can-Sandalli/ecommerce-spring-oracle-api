package com.sandalliyasarcan.exceptiıon;

public class OrderDetailNotFoundException extends RuntimeException {
    public OrderDetailNotFoundException(String message) {
        super(message);
    }
}
