package IO;

import java.io.*;

/**
 * @author Silver & Bullet
 *         on 三月-19
 */
public class ReaderWriterTry {
    public static void main(String[] args) throws IOException {
        String fileDest = "";
        Writer writer = new FileWriter(fileDest);
    //    Writer writer = new OutputStreamWriter(new ByteArrayOutputStream());

        String filePath="";
        Reader reader = new FileReader(filePath);
        int data = reader.read();
        while (data!=-1){
            char charData = (char) data;
            writer.write(charData);
            data=reader.read();

        }
        reader.close();
        writer.close();

        //buffer

        Reader bufferReader = new BufferedReader(reader);
        Writer bufferWriter = new BufferedWriter(writer);




    }
}
