package Matrix;

public class TooLargeSizeException extends Exception {
    TooLargeSizeException() {
        super("The size is too large (N > 1_000_000)");
    }
}
