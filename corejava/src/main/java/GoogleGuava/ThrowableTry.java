package GoogleGuava;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;

/**
 * Created by yanjinbin on 16-12-9.
 */
public class ThrowableTry {
    public static void main(String[] args) {
        try {
            Optional.of(null);
        } catch (Exception e) {
            Throwables.propagateIfPossible(e);
            e.printStackTrace();
        }
    }
}
