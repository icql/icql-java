package work.icql.java.algorithm.leetcode;

import java.util.Stack;
import java.util.concurrent.locks.LockSupport;

public class Test {

    private static final String test1;

    static {
        test1 = "123";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; ++i) {
            System.out.println(i);
        }
    }

    public static void main1(String[] args) throws Exception {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("持有lock1");
                    LockSupport.parkUntil(System.currentTimeMillis() + 5000);
                    synchronized (lock2) {
                        System.out.println("xxxx");
                    }
                }
            }
        });
        thread1.setName("test1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("持有lock2");
                    synchronized (lock1) {
                        System.out.println("xxxx");
                    }
                }
            }
        });
        thread2.setName("test2");

        thread1.start();
        thread2.start();

        System.in.read();

        int i = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }

    private static Stack<Character> stack = new Stack<>();

    //'('，')'，'{'，'}'，'['，']'
    public static boolean isValid(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
                continue;
            }
            if (stack.size() == 0) {
                return false;
            }
            Character pop = stack.pop();
            boolean valid = (c == ')' && pop == '(') || (c == '}' && pop == '{') || (c == ']' && pop == '[');
            if (!valid) {
                return false;
            }
        }
        return stack.size() == 0;
    }


    //[1,8,6,2,5,4,8,3,7]
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int value;
            if (height[left] > height[right]) {
                value = (right - left) * height[right];
                right--;
            } else {
                value = (right - left) * height[left];
                left++;
            }
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
