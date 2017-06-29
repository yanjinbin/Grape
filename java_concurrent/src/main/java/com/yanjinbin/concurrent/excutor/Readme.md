---
线程池

java 线程池管理

http://www.cnblogs.com/skywang12345/p/3509903.html

http://fangjian0423.github.io/2016/03/22/java-threadpool-analysis/


需要搞懂 ctl 也就是 -1 0 1 2 3 <<29 左移之后   用高3位(32 31 20 ) 表示 state  第29位开始表示 线程数量

需要理解下列方法即可 
ctl p
ctlof()
runStateOf()
workCountof()
isRunning()
上述方法来记录 AtomicInteger ctl  状态和线程数量信息


worker = LinkedBlockingQueue()

AQS 源码  
非公平可重入锁

位运算操作 

----

然后理解下下线程池管理的 UML 图

ThreadPoolExecutors 几个成员变量的含义 以及 如何如何创建线程以及拒绝策略

还有需要理解下 线程池状态的一个路线图
