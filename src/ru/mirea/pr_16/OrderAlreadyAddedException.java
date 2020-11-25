package ru.mirea.pr_16;

public class OrderAlreadyAddedException extends Exception {
    OrderAlreadyAddedException(String message) {
        super(message);
    }
}

