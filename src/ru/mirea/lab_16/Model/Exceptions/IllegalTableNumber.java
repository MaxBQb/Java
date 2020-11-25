package ru.mirea.lab_16.Model.Exceptions;

// ОН ГОТОВ НЕ ТРОГАТЬ
public class IllegalTableNumber extends RuntimeException {
    IllegalTableNumber(String message) {
        super(message);
    }
}
