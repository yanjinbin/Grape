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

