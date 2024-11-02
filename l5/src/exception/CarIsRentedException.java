package exception;

public class CarIsRentedException extends RuntimeException {
    public CarIsRentedException(String message) {
        super(message);
    }
}
