java 内存模型  chapter-16 （P277-P288）
java 内存模型需要解决的是什么情况下 ，A 线程看到变量var 的值是3 
也许这个问题很纯 
但是在多线程环境下  需要解决数据共享和同步问题 因此就显得特变有意义咯
干扰因素：1 指令重排序 2 编译器可能把变量没有放到主内存中而是放到寄存器中 3 处理器可能乱序或者并行 处理 4 缓存可能会改变提交到主内存的次序 ，而保存在本地缓存中的变量对于其他处理器是不可见的 

JMM 规定了 JVM 必须遵循的一组最小保证： 规定变量的写入操作在合适对其他线程可见




寄存器是 什么呢？ 看阮一峰这篇文章 基本可以解决概念模型上的问题 http://www.ruanyifeng.com/blog/2013/10/register.html


java 内存模型 

--------

[深入理解 java 内存模型 PDF 版本]( http://www.infoq.com/resource/minibooks/java_memory_model/zh/pdf/think_deep_in_java_mem_model.pdf)

http://www.infoq.com/cn/articles/java-memory-model-1
http://www.infoq.com/cn/articles/java-memory-model-2
http://www.infoq.com/cn/articles/java-memory-model-3
http://www.infoq.com/cn/articles/java-memory-model-4
http://www.infoq.com/cn/articles/java-memory-model-5
http://www.infoq.com/cn/articles/java-memory-model-6
http://www.infoq.com/cn/articles/java-memory-model-7

--------



