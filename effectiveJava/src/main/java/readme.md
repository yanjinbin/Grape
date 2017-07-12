effective-java source code  地址: 

https://github.com/marhan/effective-java-examples

建造工厂 重用实例来实现不可变对象

P80  设计子类基层父类的时候 不允许构造方法或者 cloneable 以及 seriliazable 接口 调用 可覆盖的方法

P82 接口和抽象的区别在于 Is a 和 has a 的关系区别
接口允许我们构造非层次的关系
常量接口设计模式 是一种错误的设计模式 这纯粹是实现细节  P86
接口应该被用来定义借口，而不允许导入静态常量

P88 类层次优于标签类

内部类 优先考虑使用静态成员类的实例 P94

P138 用 EnumSet 代替位域表示法的操作（交集和并集） ，
 还可以补齐 不能遍历的缺点
 
p140 用 EnumMap代替序数索引  
