package work.icql.java.java.algorithm.sort;

/**
 * @author icql
 * @version 1.0
 * @date 2019/6/10 16:24
 * @Title SelectionSort，简单选择排序
 * @Description SelectionSort
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            // 寻找[i, 数组末尾)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }
}
