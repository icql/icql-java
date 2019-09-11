package work.icql.java.concurrent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
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

        //long start = System.currentTimeMillis();
        //
        //List<Integer> num = new ArrayList<>();
        //for (int i = 0; i < 1000000; i++) {
        //    num.add(i);
        //}
        //
        //for (int i : num) {
        //    System.out.println("主线程：" + i);
        //}
        //
        //TimeUnit.SECONDS.sleep(12);

        //List<Integer> ls0 = new ArrayList<>();
        //List<Integer> ls1 = new ArrayList<>();
        //List<Integer> ls2 = new ArrayList<>();
        //List<Integer> ls3 = new ArrayList<>();
        //for (int i : num) {
        //    int val = i % 4;
        //    switch (val) {
        //        case 0:
        //            ls0.add(i);
        //            break;
        //        case 1:
        //            ls1.add(i);
        //            break;
        //        case 2:
        //            ls2.add(i);
        //            break;
        //        case 3:
        //            ls3.add(i);
        //            break;
        //    }
        //}
        //
        //Thread thread0 = new Thread(() -> {
        //    for (int i : ls0) {
        //        System.out.println("线程0：" + i);
        //    }
        //});
        //Thread thread1 = new Thread(() -> {
        //    for (int i : ls1) {
        //        System.out.println("线程1：" + i);
        //    }
        //});
        //Thread thread2 = new Thread(() -> {
        //    for (int i : ls2) {
        //        System.out.println("线程2：" + i);
        //    }
        //});
        //Thread thread3 = new Thread(() -> {
        //    for (int i : ls3) {
        //        System.out.println("线程3：" + i);
        //    }
        //});
        //thread0.start();
        //thread1.start();
        //thread2.start();
        //thread3.start();
        //
        //thread0.join();
        //thread1.join();
        //thread2.join();
        //thread3.join();
        //
        //long end = System.currentTimeMillis();
        //long time = end - start;
        //System.out.println("主线程执行了：" + time + "毫秒");
    }
}

