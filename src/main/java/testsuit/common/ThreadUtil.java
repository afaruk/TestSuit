package testsuit.common;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {

    public static void waitAllThread(ThreadPoolExecutor executor) {
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(int waitTimeAsMillis) {
        try {
            Thread.sleep(waitTimeAsMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
