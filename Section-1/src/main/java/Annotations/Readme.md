## Java 注解 解析 3篇好文 分享下

- 1 Java official tutorial [戳我哟](https://docs.oracle.com/javase/tutorial/java/annotations/)

- 2 Java 注解新特性 [戳我哈](https://waylau.gitbooks.io/essential-java/content/docs/annotations.html)

- 3 Java 自定义 注解 深入运用 [快点戳我嘛](http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html)

--------2016-12-12 09:22:03--------
注解参考链接如下 在jdk5之后,oracle 公司才出了jdk注解处理器,也就是APT(Annotation Processor Tool),属于Java SE的范畴,
后来在JDK 1.7之后,划到了JDK范畴内.同样地,package 也做了相应的变更,可以参考这篇oracle 官方文章说明  [戳我哈](http://docs.oracle.com/javase/7/docs/technotes/guides/apt/GettingStarted.html),

JDK1.7之后,javax.annotaion.processor 和 javax.lang.model  handler the Annotation

JDK1.7之前的文章,可以参考这几篇文章来处理
- [深入理解Java：注解（Annotation）--注解处理器](http://www.cnblogs.com/peida/archive/2013/04/26/3038503.html)
- [INFO-Q Java深度历险（六）——Java注解](http://www.infoq.com/cn/articles/cf-java-annotation)

编写注解处理器的核心是AnnotationProcessorFactory(处理器工厂)和AnnotationProcessor(注解处理器)


JDK1.7之后参考下列文章
- [Hannes Dorfmann 中文译本](http://www.race604.com/annotation-processing/)
还有这篇 ,[戳我](http://qiushao.net/2015/07/07/Annotation-Processing-Tool%E8%AF%A6%E8%A7%A3/)
- [Hannes Dorfmann  英文版 ](http://hannesdorfmann.com/annotation-processing/annotationprocessing101)