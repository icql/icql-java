package work.icql.java.concurrent;

import java.util.Scanner;

/**
 * @author icql
 * @version 1.0
 * @date 2019/7/18 22:08
 * @Title MyTest4HW
 * @Description MyTest4HW
 */
public class MyTest4HW {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ans = 0;

        String first = null;

        while (sc.hasNext()) {
            String line = sc.nextLine();

            if ("exit".equals(line)) {
                System.out.println(ans);
                break;
            }
            int val;
            if (first == null || (val = first.compareTo(line)) > 0) {
                first = line;
                ans = 1;
            } else if (val == 0) {
                ans++;
            } else if (val < 0) {
                continue;
            }

        }
    }
}
