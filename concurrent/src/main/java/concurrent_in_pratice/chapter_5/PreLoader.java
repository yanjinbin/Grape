package concurrent_in_pratice.chapter_5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 任务
 * <p>
 * <p>
 * Using FutureTask to preload data that is needed later
 *
 * @author Brian Goetz and Tim Peierls
 */

public class PreLoader {
    private final FutureTask<ProductInfo> future =
            new FutureTask<ProductInfo>(() -> loadProductInfo());
    private final Thread thread = new Thread(future);

    ProductInfo loadProductInfo() {
        return null;
    }

    public void start() {
        thread.start();
    }

    public ProductInfo get()
            throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                throw (DataLoadException) cause;
            } else {
                throw LaunderThrowable.launderThrowable(cause);
            }
        }

    }

    interface ProductInfo {
    }
}

class DataLoadException extends Exception {
}