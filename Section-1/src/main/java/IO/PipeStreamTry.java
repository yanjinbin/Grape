package IO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author Silver & Bullet
 *         on 三月-19
 */
public class PipeStreamTry {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream outputStream = new PipedOutputStream();
        //输出作为输入
        final PipedInputStream inputStream = new PipedInputStream(outputStream);


        Thread outThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    outputStream.write("hello world".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread inputThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = inputStream.read();
                    while (data != -1) {
                        System.out.println(((char) data));
                        data = inputStream.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // java io 异常处理标准流程
                    // http://ifeve.com/java-io-exception/
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        outThread.start();
        inputThread.start();


    }
}
