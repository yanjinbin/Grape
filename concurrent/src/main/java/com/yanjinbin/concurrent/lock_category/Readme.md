锁的分类 http://ifeve.com/java_lock_see/
[自旋锁、排队自旋锁、MCS锁、CLH锁](http://coderbee.net/index.php/concurrent/20131115/577/comment-page-1)

- 1. 自旋锁 spin lock http://ifeve.com/java_lock_see1/
> 自旋锁是采用让当前线程不停地的在循环体内执行实现的，当循环的条件被其他线程改变时 才能进入临界区
- 2. 自旋锁的其他种类 http://ifeve.com/java_lock_see2/
- 2.1 ticket lock , CLH lock (FIFO queue ) ,MC lock




