package L5.exception;

public class CarIsRentedException extends RuntimeException {
    public CarIsRentedException(String message) {
        super(message);
    }
}
