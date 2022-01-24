package lab3.exceptions;

public class NegativeAgeException extends RuntimeException{
    public NegativeAgeException(String message) {
        super(message);
    }
}
