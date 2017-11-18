# java IO package 介绍

在学习传统意义上的 IO 之前,需要了解 IO 模型在 linux中的分类

1 [IO 模型]( http://dwz.cn/5y4130)
2 [Linux IO模型介绍 ](https://segmentfault.com/a/1190000003063859)


>Java.io 包主要涉及文件，网络数据流，内存缓冲等的输入输出。

Java IO中包含了许多InputStream、OutputStream、Reader、Writer的子类。这样设计的原因是让每一个类都负责不同的功能。这也就是为什么IO包中有这么多不同的类的缘故。各类用途汇总如下：

文件访问
网络访问
内存缓存访问
线程内部通信(管道)
缓冲
过滤
解析
读写文本 (Readers / Writers)
读写基本类型数据 (long, int etc.)
读写对象
当通读过Java IO类的源代码之后，我们很容易就能了解这些用途。这些用途或多或少让我们更加容易地理解，不同的类用于针对不同业务场景。

http://ifeve.com/wp-content/uploads/2014/10/QQ%E6%88%AA%E5%9B%BE20141020174145.png


Java IO中的管道为运行在同一个JVM中的两个线程提供了通信的能力。所以管道也可以作为数据源以及目标媒介。

你不能利用管道与不同的JVM中的线程通信(不同的进程)。在概念上，Java的管道不同于Unix/Linux系统中的管道。在Unix/Linux中，运行在不同地址空间的两个进程可以通过管道通信。在Java中，通信的双方应该是运行在同一进程中的不同线程。
