package IO;

import java.io.*;

/**
 * @author Silver & Bullet
 *         on 三月-19
 */
public class StreamReaderTry {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("c:\\data\\input.txt");
        //stream 和 reader writer 之间 完成转换
        Reader reader = new InputStreamReader(inputStream);

        int data = reader.read();

        while (data!=-1){
            System.out.println(((char) data));
            data=reader.read();
        }
        reader.close();


        OutputStream outputStream = new FileOutputStream("c:\\data\\output.txt");


        Writer writer = new OutputStreamWriter(outputStream);

        writer.write("hello world");
        writer.close();


    }
}
