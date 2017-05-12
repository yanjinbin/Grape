import com.alibaba.fastjson.JSON;
import lombok.Person;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Silver & Bullet
 *         on 十二月-16
 */

public class MiscTest  extends BaseTest{

    @Test
    public void emptyBlankTest(){
        String emptyStr = "";
        String nullStr =null;
        String blankStr="  ";
        System.out.println("StringUtils.isEmpty(emptyStr) 用法  "+ StringUtils.isEmpty(emptyStr));

        //StringUtils.isEmpty(" ")       = false


        //所以下次 应该使用isBlank方法,不要再使用isEmpty方法
        System.out.println("StringUtils.isBlank(emptyStremptyStr)  用法  "+StringUtils.isBlank(emptyStr));
        //下面演示2者的区别

        System.out.println(StringUtils.isEmpty(blankStr)==StringUtils.isBlank(blankStr));
        Person person = new Person();
        person.setAge(11);
        person.setName("xiaoming");
        Person person1 = new Person();
        person1.setName("xiaoli");
        person1.setAge(12);

        boolean b = Unsafe.getUnsafe().compareAndSwapObject(person, 11, null, person1);
        System.out.println(b);
        if (true && true) {
            System.out.println("nishiduide");
        }

    }



    @Test
    public  void Iterable$IteratorDiff(){
        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



        //Iterable有一个Iterator iterator() 方法

        //Collection接口 extends Iterable 接口 所以所有的 集合都实现了迭代的功能

    }
    @Test
    public void CollectionUtilTest(){

        List arrayList = new ArrayList();

        System.out.println(CollectionUtils.isEmpty(arrayList));

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);


        System.out.println(CollectionUtils.isEmpty(arrayList));


        Object aaaa = JSON.parse("AAAA");

    }
}
