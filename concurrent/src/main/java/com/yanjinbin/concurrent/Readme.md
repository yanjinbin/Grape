多线程需要解决的是 线程之间完成通信交换的过程， 锁就是一种对资源对象的占用

原子操作： 

复合操作的每一单步操作都是原子的 那么我们可以说复合操作也是原子性的


java并发之原子性、可见性、有序性（https://my.oschina.net/wangnian/blog/668490）



Synchronize 和 volatile 之间的区别 （https://ddyblackhat.gitbooks.io/java/content/concurrent/jmm.html ） 
这篇文章写的很好了 
说明了 synchronize 在工作内存刷新到主内存和从主内存刷新到工作内存前
Amdahl's  law（ http://dwz.cn/6eUiBz）

JMM “在本章中将会多次提到的“内存模型”一词，可以理解为在特定的操作协议下，对特定的内存或高速缓存进行读写访问的过程抽象。”
    
    摘录来自: 周志明. “深入理解Java虚拟机：JVM高级特性与最佳实践[第2版]”。 iBooks. 
    
    
JMM 存在8种指令
lock 锁定 ： 作用于主内存的变量，表示一个线程的独占状态
unlock 解锁： 释放锁定 把一个处于 lock 状态的变量 解锁 ，以便其他线程尝试锁定 
1  read： 主内存---工作内存,从主内存中读取变量  2 load： 将变量写入到工作内存的变量副本但总 3 use:工作内存的变量副本 传递给执行引擎 4 asign 赋值： 把一个接收到的变量赋值给工作内存内的变量 5 store 把工作内存的变量传递给主内存但总 6 write 写入：  store 的变量 写入到工作内存当中 
