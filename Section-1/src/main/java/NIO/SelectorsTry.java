package NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * http://ifeve.com/selectors/
 * 选择器,一个线程可以监听多个NIO 通道,并知晓是否为读写做好准备的组件
 *
 * 为什么要使用单个线程,因为线程之间切换上下文,系统开销比较大
 *
 * @author Silver & Bullet
 *         on 三月-20
 */
public class SelectorsTry {
    public static void main(String[] args) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();

        //创建 通道
        String path = "";
        FileInputStream inputStream = new FileInputStream(new File(path));
        FileChannel channel = inputStream.getChannel();

        //注册通

    }
}
