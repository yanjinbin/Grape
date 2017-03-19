package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 组合stream
 *
 * @author Silver & Bullet
 *         on 三月-19
 */
public class BufferStreamTry {
    public static void main(String[] args) throws IOException {

        byte[] source = "hello world".getBytes();

        InputStream input = new BufferedInputStream(new ByteArrayInputStream(source));


        OutputStream output = new BufferedOutputStream(new ByteArrayOutputStream());
        output.write(source);


        //sequenceInputStream




    }


}
