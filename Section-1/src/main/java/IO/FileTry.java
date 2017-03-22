package IO;

import java.io.File;

/**
 * @author Silver & Bullet
 *         on 三月-19
 */
public class FileTry {
    public static void main(String[] args) {
        String filePath = "";

        File file = new File(filePath);

        boolean exists = file.exists();

        long length = file.length();

        boolean directory = file.isDirectory();


        boolean isDeleted = file.delete();

        String newFilePath = "";

        file.renameTo(new File(newFilePath));

        //如果是目录 非文件

        String[] list = file.list();
        File[] files = file.listFiles();


    }
}
