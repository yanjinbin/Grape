package chapter11_序列化;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Author Grape
 * @Since 2017/7/12.
 */
public class Foo extends Abstract_Foo implements Serializable {

    private static final long serialVersionUID = 1856835860954L;

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int x = s.readInt();
        int y = s.readInt();
        super.initialized(x, y);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        // Manually serialize superclass state
        s.writeInt(super.getX());
        s.writeInt(super.getY());
    }

    public Foo(int x, int y) {
        super(x, y);
    }
}
