package work.icql.jvm;

public class Application {

    public static void main(String[] args) {
        int[] test = new int[10];
        Integer[] test1 = new Integer[10];
        System.out.println("".getClass().getName());
        System.out.println(test.getClass().getName());
        System.out.println(test1.getClass().getName());
    }
}
