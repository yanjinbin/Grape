package com.yanjinbin.concurrent.chapter_2;

/**
 * 延迟加载（属于先检查后执行的一种）
 *
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
public class LazyInitRace {
    //
    private ExpensiveObject instance;

    // race condition 线程不安全
    private ExpensiveObject newInstance() {
        if (instance == null) {
            return new ExpensiveObject();
        }
        return instance;
    }

}

class ExpensiveObject {
}