package work.icql.java.concurrent;

import jdk.nashorn.internal.ir.CallNode;
import junit.framework.Assert;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author icql
 * @version 1.0
 * @date 2019/4/12 14:40
 * @Title MyTest
 * @Description MyTest
 */
public class MyTest {

    public static void testExecutor() throws Exception {
        AtomicInteger count = new AtomicInteger(1);

        int corePoolSize = 4 + 1;
        int maximumPoolSize = 60;
        long keepAliveTime = 60;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2000);
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger nextId = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                String name = "测试线程池-" + nextId.getAndIncrement();
                return new Thread(r, name);
            }
        };

        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(count.getAndIncrement() + "阻塞队列满了：" + executor.toString());
            }
        };

        Executor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

        long start = System.nanoTime();

        int taskCount = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        for (int i = 0; i < taskCount; i++) {
            final int c = i;
            ((ThreadPoolExecutor) executor).submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Files.write(Paths.get("C:\\Users\\a6924.GOLDDRAGON.COM\\Desktop\\1\\" + c + ".txt"), ("test" + c).getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        long end = System.nanoTime();

        System.out.println("结束，耗时：" + (end - start) / 1000000000.0 + "秒");
        ((ThreadPoolExecutor) executor).shutdown();
    }

    public static void testDeadLock1() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println();
                synchronized (lock2) {
                    System.out.println();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void testFuture() {
        class CarInfo {
            String carno;
            int type1;
            int type2;
        }
        CarInfo carInfo = new CarInfo();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> submit = executorService.submit(callable);

    }

    public static void testList() {

        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("list original size is " + list.size());
        Iterator var1 = list.iterator();

        while (var1.hasNext()) {
            String item = (String) var1.next();
            if ("1".equals(item)) {
                list.remove(item);
                //var1.remove();
            }
        }

        System.out.println("list size is " + list.size());

        //List<String> list = new ArrayList<>();
        //list.add("1");
        //list.add("2");
        //list.add("3");
        //
        //System.out.println("list original size is " + list.size());
        //
        //for (String item : list) {
        //    if ("1".equals(item)) {
        //        list.remove(item);
        //    }
        //}
        //
        //System.out.println("list size is " + list.size());
    }

    public static void testMap() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put(null, "");
    }

    public static int testTry() {
        try {
            int i = 1;
            return i;
        } catch (Exception e) {
            int i = 2;
            return i;
        } finally {
            int i = 3;
            return i;
        }
    }

    public static void testThread() throws Exception {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final AtomicInteger num = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Runnable runnable = new Runnable() {
            private volatile boolean flag = true;

            @Override
            public void run() {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  " + arr[num.getAndIncrement()]);
                    } catch (Exception e) {
                        flag = false;
                    }
                }
                countDownLatch.countDown();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        countDownLatch.await();
    }


    public static void main(String[] args) throws Exception {

    }


    @Test
    public void test() throws Exception {
        System.out.println((3*1.0/2)-3/2);
    }

    void valueOrRef(Object str){
        //str = "test11";
        //str = 2;
        str = new Object();
    }





}
