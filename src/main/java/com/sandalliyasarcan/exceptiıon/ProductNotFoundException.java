package com.sandalliyasarcan.exceptiıon;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message)  {
        super(message);
    }
}
