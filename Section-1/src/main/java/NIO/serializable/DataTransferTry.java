package NIO.serializable;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * http://ifeve.com/java-nio-channel-to-channel/
 * 数据通道之间的传输
 *
 * @author Silver & Bullet
 *         on 三月-20
 */
public class DataTransferTry {
    public static void main(String[] args) throws IOException {
        String sourceFile = "";
        String destFile = "";


        RandomAccessFile fromFile = new RandomAccessFile(sourceFile, "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(destFile, "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;

        long count = fromChannel.size();
        //准备要传输的数据
        long l = toChannel.transferFrom(fromChannel, position, count);

        //准备接受的数据
        long m = fromChannel.transferTo(position, count, fromChannel);

    }
}
