package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Silver & Bullet
 *         on 三月-19
 */
public class FlushTry {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream("hello world".getBytes());
        outputStream.write(((char) inputStream.read()));
        outputStream.flush();
        outputStream.close();


    }
}
