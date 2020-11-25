package ru.mirea.pr_9;

public abstract class DeserializationException
        extends Exception {
    public DeserializationException(String errorMessage) {
        super(errorMessage);
    }
}