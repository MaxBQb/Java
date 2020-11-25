package ru.mirea.pr_9;

public class WrongFieldsCountException
        extends DeserializationException {
    public WrongFieldsCountException(String errorMessage) {
        super(errorMessage);
    }
}