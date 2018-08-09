package ru.sbt.collections.utils;

import javax.script.ScriptException;
import java.time.Duration;
import java.util.concurrent.Callable;

public class SimpleStopwatch {
    public static <T> T showDuration(Callable<T> doWork, String prefix) throws Exception {
        long t1 = System.nanoTime();

        T result = doWork.call();

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos(nanoDuration);
        System.out.println(prefix + d.toString());
        return result;
    }


    public static void showDuration(Runnable doWork, String prefix) {
        long t1 = System.nanoTime();

        doWork.run();

        long nanoDuration = System.nanoTime() - t1;
        Duration d = Duration.ofNanos(nanoDuration);
        System.out.println(prefix + d.toString());
    }
}
