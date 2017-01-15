package IO;

import java.net.URL;

/**
 * @author Silver & Bullet
 *         on 一月-08
 */
public class FilePathTry {
    public static void main(String[] args) {
        URL resource = FilePathTry.class.getResource("/");
        System.out.println(resource.getPath());
        System.out.println(resource.getProtocol());
        System.out.println(resource.getAuthority());
        System.out.println("port is  "+resource.getPort());
        System.out.println(FilePathTry.class.getClassLoader().getResource("").getPath());
    }
}
