java8 接口默认方法
http://ebnbin.com/2015/12/20/java-8-default-methods/

这篇文章解释了 stream 是什么概念
对集合对象的聚合操作,并且摒弃 iterator 的 不好 ,利用 Fork Join 框架的并行特性 高效处理数据流
https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/

java8学习资料汇总, 收集了好多有意思的问题
http://www.infoq.com/cn/news/2014/06/java8-learning-resources

//这篇 lambda 讲的就已经很不错了
https://luyiisme.github.io/2017/01/21/java8-lambda/
https://nkcoder.github.io/2016/01/16/java-8-lambda-expression-guide/

留得操作
流的操作
接下来，当把一个数据结构包装成 Stream 后，就要开始对里面的元素进行各类操作了。常见的操作可以归类如下。
**Intermediate**：
map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
**Terminal**：
forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
**Short-circuiting**：
anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
我们下面看一下 Stream 的比较典型用法

最后看下 Stream 的操作特点 
