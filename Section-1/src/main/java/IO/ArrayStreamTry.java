package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * java 中 字节和字符流的读取
 *
 * @author Silver & Bullet
 *         on 三月-19
 */
public class ArrayStreamTry {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("hello world I'm coming".getBytes());


        //byte stream
        byte[] source = outputStream.toString().getBytes();


        InputStream inputStream = new ByteArrayInputStream(source);

        int data = inputStream.read();
        while (data != -1) {
            System.out.println(((char) data));
            data = inputStream.read();
        }
        inputStream.close();

        ////char stream
        char[] charSource = new char[1024];
        CharArrayReader reader = new CharArrayReader(charSource);
        int sign = reader.read();
        while (sign != -1) {
            System.out.println(sign);
            data = reader.read();
        }
        reader.close();


    }

    public void test() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        output.write("This text is converted to bytes".getBytes("UTF-8"));

        byte[] bytes = output.toByteArray();
    }
}
