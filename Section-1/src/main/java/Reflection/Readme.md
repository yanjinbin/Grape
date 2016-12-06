[Java反射机制](http://wiki.jikexueyuan.com/project/java-reflection/)

翻译来源: Java Reflection Tutorial  [戳我哟](http://tutorials.jenkov.com/java-reflection/index.html)

-----

1 含义: Java Reflection 让我们在编译器检查类,接口,变量和方法的信息之外,还可以让我那么在运行期,(instantiation)
对象,调用方法,通过调用get/set方法获取变量的值
spring IOC container has the JAVA Reflection mechanism hint

获取类的信息,往往是Java 反射机制 第一件要做的事情


2  在获取私有变量和私有方法的时候 需要
~~~
    setAccessable(true)


-----

Java 泛型 反射获取信息 ,虽然说java在编译器,通过泛型消除了强制转换和进行类型检查
在运行期间eraser(擦除)了泛型信息,好像我们无法通过Java 反射机制 获取类的泛型信息,其实,这种说法是不对的


1. 运用泛型反射的经验法则
    当你,想在运行期参数化类型本身,比如你想检查java.util.List类的参数化类型的,我们是**没有办法知道List具体的参数化类型是什么**,~~但是~~,当你检查一个使用了泛型的类,他的变量或者方法,你可以获得这个被参数化类型的具体参数
    总而言之,你不可能在运行期间,知道被参数化类型的具体参数,但那是你可以在用到这个被参数化类型的方法以及变量中,找到他们.
    简而言之,T fun(); 你是获取不到她的具体类型的,但是List<String> fun();你是可以获得这个泛型类的具体参数化类型是java.lang.String
    参考GenericTry类的演示,