package com.yanjinbin.concurrent.atomic;

/**
 * http://www.cnblogs.com/skywang12345/p/3514593.html
 *
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class AtomicTry {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(100);
        System.out.println(atomicLong.get());
        atomicLong.set(101);
        System.out.println(atomicLong.get());
        atomicLong.addAndGet(9);
        System.out.println(atomicLong.get());
        atomicLong.compareAndSet(110, 121);
        System.out.println(atomicLong.get());
        atomicLong.addAndGet(9);
        System.out.println(atomicLong.get());
        atomicLong.lazySet(144);
        System.out.println(atomicLong.get());
        atomicLong.getAndDecrement();// num--
        atomicLong.decrementAndGet();//--num
        atomicLong.incrementAndGet();//++num
        atomicLong.getAndIncrement();//num++


        // LongAdder http://ifeve.com/atomiclong-and-longadder/#more-11373  Google 和 Java util包里面均有这个哟


        //Atom*Array  http://www.cnblogs.com/skywang12345/p/3514604.html
        System.out.println("------Atom*Array in Action -------");
        AtomicLongArray atomicLongArray = new AtomicLongArray(10);
        System.out.println(atomicLongArray.length());

        int[] arrInt = new int[]{10, 20, 30, 40, 50};

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arrInt);
        System.out.println(atomicIntegerArray.toString());

        //AtomicReference的源码比较简单。它是通过"volatile"和"Unsafe提供的CAS函数实现"原子操作。
//        (01) value是volatile类型。这保证了：当某线程修改value的值时，其他线程看到的value值都是最新的value值，即修改之后的volatile的值。
//        (02) 通过CAS设置value。这保证了：当某线程池通过CAS函数(如compareAndSet函数)设置value时，它的操作是原子的，即线程在操作value时不会被中断。
        Person xiaoming = new Person("小明");
        Person xiaoli = new Person("小李");
        AtomicReference a = new AtomicReference(xiaoming);
        a.compareAndSet(xiaoming, xiaoli);
        Person person = (Person) a.get();
        System.out.println(person.equals(xiaoli));


        // 修给对象属性 以原子操作方式
        //Atomic*FieldUpdate http://www.cnblogs.com/skywang12345/p/3514635.html

        Class<Person> personClass = Person.class;
        AtomicIntegerFieldUpdater<Person> aifu = AtomicIntegerFieldUpdater.newUpdater(personClass, "age");
        Person person_1 = new Person( "哈哈",11);
        boolean b = aifu.compareAndSet(person_1, 11, 12);
        System.out.println(person_1.getAge());

    }

}
