package NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Silver & Bullet
 *         on 三月-20
 */
public class FileChannelTry {
    public static void main(String[] args) throws IOException {
        // classic buffer 操作
        String filePath = "";
        String fileProperty = "rw";
        RandomAccessFile accessFile = new RandomAccessFile(filePath, fileProperty);
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = fileChannel.read(buffer);
        while (read != -1) {
            System.out.println("Read Content is " + ((char) read));
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println(((char) buffer.get()));
            }

            buffer.clear();

            read = fileChannel.read(buffer);
        }

        accessFile.close();

        // Scatter/Gather

        ByteBuffer head = ByteBuffer.allocate(48);
        ByteBuffer body = ByteBuffer.allocate(124);
        ByteBuffer tail = ByteBuffer.allocate(8);


        ByteBuffer[] buffers = {head, body, tail};
        // scatter
        fileChannel.read(buffers);
        // gather
        fileChannel.write(buffers);


    }
}
