package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Silver & Bullet
 *         on 三月-19
 */
public class IOSystemTry {
    public static void main(String[] args) {
        String path = "";
        try {
            InputStream inputStream = new FileInputStream(path);
            System.out.println("file has opened");
        } catch (FileNotFoundException e) {
            System.err.println("file open failed");
            e.printStackTrace();
        }


    }
}
