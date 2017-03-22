package IO;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Silver & Bullet
 *         on 三月-19
 */
public class RandomAcceesTry {
    public static void main(String[] args) throws IOException {
        String filePath = "";
        RandomAccessFile file = new RandomAccessFile(filePath,"rw");

        file.seek(200);
        long filePointer = file.getFilePointer();
        file.write("hello world ".getBytes());
        file.close();

    }
}
