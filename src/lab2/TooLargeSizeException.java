package lab2;

public class TooLargeSizeException extends Exception {
    TooLargeSizeException() {
        super("The size is too large (N > 1_000_000)");
    }
}
