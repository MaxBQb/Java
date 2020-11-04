package lab_16.Model.Exceptions;

// ОН ГОТОВ НЕ ТРОГАТЬ
public class OrderAlreadyAddedException extends Exception {
    OrderAlreadyAddedException(String message) {
        super(message);
    }
}

