package Matrix;

public class DivisionByZeroException extends Exception {
    DivisionByZeroException() {
        super("Division by 0 is prohibited");
    }
}