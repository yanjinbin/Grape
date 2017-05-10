package IO;

import java.io.*;

/**
 * http://ifeve.com/java-io-other-1/
 * http://ifeve.com/java-io-other/
 *
 * @author Silver & Bullet
 *         on 三月-19
 */
public class MiscIOtry {
    public static void main(String[] args) throws IOException {
        String filepath = "";
        PushbackInputStream inputStream = new PushbackInputStream(new FileInputStream(new File(filepath)), 8 * 1024);
        int data = inputStream.read();
        if (((char) data) == 'a') {
            inputStream.unread(data);
        }

        //通过SequenceInputStream，例子中的2个InputStream使用起来就如同只有一个InputStream一样(译者注：SequenceInputStream的read()方法会在读取到当前流末尾时，关闭流，并把当前流指向逻辑链中的下一个流，最后返回新的当前流的read()值)。

        String file1 = "";
        String file2 = "";
        InputStream inputStream1 = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        InputStream combineStreams = new SequenceInputStream(inputStream1, inputStream2);


        //PrintStrea;
        OutputStream outputStream = new FileOutputStream(file1);

        PrintStream output = new PrintStream(outputStream);
        output.print(true);
        output.print(1);
        output.print('a');
        output.print(11L);
        output.close();

        //stream token  http://ifeve.com/java-io-other/

        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader("Mary had 1 little lamb..."));

        while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){

            if(tokenizer.ttype == StreamTokenizer.TT_WORD) {

                System.out.println(tokenizer.sval);
            } else if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {

                System.out.println(tokenizer.nval);

            } else if(tokenizer.ttype == StreamTokenizer.TT_EOL) {

                System.out.println();

            }

        }



    }
}
