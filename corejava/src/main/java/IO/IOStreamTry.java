package IO;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * http://wiki.jikexueyuan.com/project/java/files-and-io.html
 * <p>
 * java IO 操作
 *
 * @author Silver & Bullet
 *         on 一月-15
 */
@Slf4j
public class IOStreamTry {
    public static void main(String[] args) throws IOException {

        //字节流的处理
        String fileName = "application.yml";
        String classPath = IOStreamTry.class.getClassLoader().getResource("").getPath();
        String filePath = IOStreamTry.class.getClassLoader().getResource(fileName).getPath();
        String linuxfileSeparator = "/";
        String windowsFileSeparator = "\\";
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(new File(filePath));
            out = new FileOutputStream(classPath + "/output.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
          //  e.printStackTrace();
        } catch (IOException e) {
          //  e.printStackTrace();
        } finally {
            if (in == null) {
                in.close();
            }
            if (out == null) {
                out.close();
            }
        }
        //字符流的处理 ，Java 字符流用于处理16位 unicode 的输入和输出

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(new File(filePath));
            fileWriter = new FileWriter(new File(classPath + "/fileOut.txt"));

            System.out.println("编码     " + fileReader.getEncoding());

            int c = fileReader.read();
            while (c != -1) {
                fileWriter.write(c);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (fileReader == null) {
                fileReader.close();
            }
            if (fileWriter == null) {
                fileWriter.close();
            }
        }

        //java 标准流处理  stand in  stand out   & stand error

        InputStreamReader inputStreamReader = null;
        inputStreamReader = (new InputStreamReader(System.in));
        System.out.println("enter character ,'q' means quit ");
        char c;
        do {
            c = ((char) inputStreamReader.read());
            System.out.println(c);
        } while (c != 'q');
        if (inputStreamReader==null) {
            inputStreamReader.close();
        }

    }
}
