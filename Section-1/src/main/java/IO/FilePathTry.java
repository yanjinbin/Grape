package IO;

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



        //URL resource = FilePathTry.class.getResource("/");
        //System.out.println(resource.getPath());
        //System.out.println(resource.getProtocol());
        //System.out.println(resource.getAuthority());
        //System.out.println("port is  "+resource.getPort());
        //System.out.println(FilePathTry.class.getClassLoader().getResource("").getPath());
    }
}
