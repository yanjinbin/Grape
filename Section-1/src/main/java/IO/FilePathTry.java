package IO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * classpath: 和 classpath*:的区别  ,第二个虽好,但是加载很慢,因此规划的时候,需要规划好资源文件配置规范,统一存放,提高启动速度
 * http://perfy315.iteye.com/blog/2009258
 *
 *
 * spring classPathXmlApplicationContext 对于资源文件路径的读取
 *
 * http://blog.csdn.net/kkdelta/article/details/5507799
 *
 *
 *
 * spring boot 加载 yml 文件 2个雷  property 形式和 map形式
 * 见: http://dwz.cn/5dfJAC
 *
 * http://blog.csdn.net/isea533/article/details/50281151
 *
 * classpath
 *
 *顾名思义, classpath 指的是类路径,也就是编译后类文件存放的根目录,*
 ---
 普通的 java web 项目,一般资源文件编译打包之后在存放在在根路径一级目录下
 ,类文件在则根据头部  package  关键字段
 *
 * maven 构建 java web 工程, classpath 路径读取问题
 * @author Silver & Bullet
 *         on 一月-08
 */
public class FilePathTry {
    public static void main(String[] args) {
        //获取当前 project下的 classpath 路径
        System.out.println("获取当前project下的根路径,即 classpath        "+FilePathTry.class.getClassLoader().getResource("").getPath());
        //获取当前类的加载路径
        System.out.println("获取当前类的加载路径,定位到 package 这一层        "+FilePathTry.class.getResource("").getPath());
        //读取resource 目录下资源和配置文件的几个办法

        //方法1  从 classpath 路劲出发

        String fileName = "application.properties";
        String resourceFilePath = FilePathTry.class.getClassLoader().getResource(fileName).getPath();
        System.out.println("使用 classpath 读取    "+resourceFilePath);

        File file = new File(resourceFilePath);

        System.out.println(file.exists());

        //方法2 从类加载路径出发,
        String resourceFilePath1  =  FilePathTry.class.getResource("/application.properties").getPath();//注意 getResource 区别  有 slash
        System.out.println("---          "+resourceFilePath1);
        String classpathResource = "classpath:application.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(classpathResource);
        System.out.println(ctx.getDisplayName());

        //URL resource = FilePathTry.class.getResource("/");
        //System.out.println(resource.getPath());
        //System.out.println(resource.getProtocol());
        //System.out.println(resource.getAuthority());
        //System.out.println("port is  "+resource.getPort());
        //System.out.println(FilePathTry.class.getClassLoader().getResource("").getPath());
    }
}
