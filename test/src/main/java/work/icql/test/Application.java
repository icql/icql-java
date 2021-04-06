package work.icql.test;

import java.util.concurrent.atomic.AtomicInteger;

//@SpringBootApplication
public class Application {

//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(300);

        Thread thread3 = new Thread(() -> {
            while (integer.get() < max.get()) {
                if (integer.get() % 3 == 2) {
                    System.out.println("C");
                    integer.getAndIncrement();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            boolean first = true;
            while (integer.get() < max.get()) {
                if (integer.get() % 3 == 1) {
                    System.out.println("B");
                    if (first) {
                        thread3.start();
                    }
                    first = false;
                    integer.getAndIncrement();
                }
            }
        });


        Thread thread1 = new Thread(() -> {
            boolean first = true;
            while (integer.get() < max.get()) {
                if (integer.get() % 3 == 0) {
                    System.out.println("A");
                    if (first) {
                        thread2.start();
                    }
                    first = false;
                    integer.getAndIncrement();
                }
            }
        });

        thread1.start();
    }

//    public static void main(String[] args) {
//        AtomicInteger integer = new AtomicInteger(0);
//        AtomicInteger max = new AtomicInteger(30);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (integer.get() < max.get()) {
//                    if (integer.get() % 3 == 0) {
//                        System.out.println("A");
//                        integer.getAndIncrement();
//                    }
//
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (integer.get() < max.get()) {
//                    if (integer.get() % 3 == 1) {
//                        System.out.println("B");
//                        integer.getAndIncrement();
//                    }
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (integer.get() < max.get()) {
//                    if (integer.get() % 3 == 2) {
//                        System.out.println("C");
//                        integer.getAndIncrement();
//                    }
//                }
//            }
//        }).start();
//    }

//    public static void main(String[] args) throws Exception{
//
//        new Thread(() -> {
//            while (true) {
//                synchronized ("A") {
//                    System.out.println("A");
//                    synchronized ("B") {
//                        "B".notifyAll();
//                    }
//                    try {
//                        "A".wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        TimeUnit.SECONDS.sleep(2);
//
//        new Thread(() -> {
//            while (true) {
//                synchronized ("B") {
//                    System.out.println("B");
//                    synchronized ("C") {
//                        "C".notifyAll();
//                    }
//                    try {
//                        "B".wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        TimeUnit.SECONDS.sleep(2);
//
//        new Thread(() -> {
//            while (true) {
//                synchronized ("C") {
//                    System.out.println("C");
//                    synchronized ("A") {
//                        "A".notifyAll();
//                    }
//                    try {
//                        "C".wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        System.in.read();
//    }
}
