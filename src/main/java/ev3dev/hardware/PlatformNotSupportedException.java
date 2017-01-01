package ev3dev.hardware;

/**
 * Exception thrown when the device is not supported in a platform.
 * 
 * @author Juan Antonio Brenha Moral
 *
 */
public class PlatformNotSupportedException extends RuntimeException {

    private static final long serialVersionUID = 5846698127613306496L;

    public PlatformNotSupportedException(String message) {
        super (message);
    }

}
