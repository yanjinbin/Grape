线性探测发和拉链法处理哈西碰撞冲突

http://threezj.com/2016/03/28/用拉链法和线性探测法解决哈希冲突/


拉链法 就是用链表来处理冲突的数组

线性探测法就是利用 纯粹的数组来处理哈希冲突   hashcode % M 得到的 key 存在 value ,则 hashcode+1 % M  直到遇到不存在相对应的 Key-Value 为止


hashMap 中 hash 算法的实现原理 可以参考这篇文章 https://www.zhihu.com/question/20733617