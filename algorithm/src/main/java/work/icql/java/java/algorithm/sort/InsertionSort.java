package work.icql.java.java.algorithm.sort;

/**
 * @author icql
 * @version 1.0
 * @date 2019/6/11 9:17
 * @Title InsertionSort，简单插入排序
 * @Description InsertionSort
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int preIndex = i - 1;
            int current = data[i];
            while (preIndex >= 0 && data[preIndex] > current) {
                data[preIndex + 1] = data[preIndex];
                preIndex--;
            }
            data[preIndex + 1] = current;
        }
    }
}
