package NIO;

import java.io.File;

/**
 *
 * 对象序列化的两个主要使用场景包括：
 对象持久化：将对象的状态存储在一种永久的持久性机制中，比如数据库
 对象远程存储：将对象发送到另一台计算机或另一个系统
 *  java序列化 try
 *
 * @author Silver Bullet
 * @since 一月-06
 */
public class SerializableTry {
    public static void main(String[] args) {
        File file = new File("/application.yml");
        System.out.println(file.exists());

    }
}
