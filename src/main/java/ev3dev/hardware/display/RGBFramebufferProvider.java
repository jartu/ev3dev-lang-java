package ev3dev.hardware.display;

import com.sun.jna.LastErrorException;
import ev3dev.hardware.display.spi.FramebufferProvider;
import ev3dev.utils.io.NativeFramebuffer;

/**
 * Creates new Linux RGB framebuffer.
 */
public class RGBFramebufferProvider implements FramebufferProvider {
    @Override
    public JavaFramebuffer createFramebuffer(NativeFramebuffer fb) throws LastErrorException, IllegalArgumentException {
        return new RGBFramebuffer(fb);
    }
}
