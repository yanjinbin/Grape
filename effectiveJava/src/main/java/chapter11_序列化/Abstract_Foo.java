package chapter11_序列化;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Grape
 * @Since 2017/7/12.
 */
public abstract class Abstract_Foo {
    private int x, y;

    private enum STATE {
        NEW, INTIALIZING, INTIALIZED
    }

    private final AtomicReference<STATE> init = new AtomicReference<STATE>(STATE.NEW);

    public Abstract_Foo(int x, int y) {
        initialized(x, y);
    }

    public Abstract_Foo() {
    }

    protected final void initialized(int x, int y) {
        if (!init.compareAndSet(STATE.NEW, STATE.INTIALIZING)) {
            throw new IllegalStateException("ALREDY INITIALIZIED");
        }
        this.x = x;
        this.y = y;
        init.set(STATE.INTIALIZED);

    }

    // These methods provide access to internal state so it can
    // be manually serialized by subclass's writeObject method.
    protected final int getX() {
        checkInit();
        return x;
    }

    protected final int getY() {
        checkInit();
        return y;
    }

    public void checkInit() {
        if (init.get() == STATE.INTIALIZED) {
            throw new IllegalStateException("UNINITIALIZED");
        }
    }
}
