package io.reactivex;

import org.junit.Test;

public class JUnitErrorTest {
    @Test
    public void blerg() {
        // Trivial case.
        Observable.error(new RuntimeException("This should fail the test"))
                .subscribe();
    }

    @Test
    public void blerg2() {
        // This is what RxJavaPlugins does under the hood.
        Thread currentThread = Thread.currentThread();
        Thread.UncaughtExceptionHandler handler = currentThread.getUncaughtExceptionHandler();
        handler.uncaughtException(currentThread, new RuntimeException("This apparently also doesn't fail the test"));
    }

    @Test(expected = RuntimeException.class)
    public void blerg3() {
        throw new RuntimeException("This definitely fails.");
    }
}
