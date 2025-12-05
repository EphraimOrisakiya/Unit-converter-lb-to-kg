public class NonNumberException extends Exception {
    public NonNumberException(String message) {
        super(message);
    }

    public NonNumberException() {
        super("Input MUST be a number.");
    }

}
