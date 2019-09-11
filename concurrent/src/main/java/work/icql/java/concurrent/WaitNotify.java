package work.icql.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author icql
 * @version 1.0
 * @date 2019/1/16 16:59
 * @Title WaitNotify
 * @Description WaitNotify
 */
public class WaitNotify {

    ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    static volatile boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
        } finally {
            lock.unlock();
        }
    }
}

