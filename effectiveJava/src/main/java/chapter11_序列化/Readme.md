// 将局部变量作用域最小化的意思就是
~~~java
var a =11
this.show()
this.useA(a)
~~~

应该变成 在第一次使用他的地方 第一次声明
this.show()
var a =11 
this.useA(a)


-------

for each 循环 优于传统的 for 循环  原因是：



-----

序列化坏处: 
1 . 导致 私有域和包级私有域也暴露了编程了 API 一部分,这与最低限度访问域相违背
2 . 类的维护测试成本增加 (新旧版本之间的类的兼容性测试)
3   根据下文 UID 的生成机制,假设你给他增加了成员变量或者方法 ,那么 UID 就要重新生成,这会导致反序列化的时候,报 InvalidClassException 异常
4.  隐藏的潜在的构造器  破坏了 有真正构造器建立起来的约束关系 

----
序列化最佳实践

JAVA 序列化 tutorial
https://www.ibm.com/developerworks/cn/java/j-lo-serial/index.html

http://bluepopopo.iteye.com/blog/486548

http://docs.oracle.com/javase/1.5.0/docs/guide/serialization/spec/serialTOC.html

http://www.cnblogs.com/lj95801/p/4870229.html

http://blog.onlycatch.com/post/writeObject%E7%A7%81%E6%9C%89


serializableVersionUID : 如果一个类默认实现了 serializable 接口 ,那么默认会给他创建一个 UID ,UID 主要受



序列化导致私有和包级私有的域 都将暴露


