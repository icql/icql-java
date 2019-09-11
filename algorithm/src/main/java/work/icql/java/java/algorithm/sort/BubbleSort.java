package work.icql.java.java.algorithm.sort;

/**
 * @author icql
 * @version 1.0
 * @date 2019/4/18 15:17
 * @Title BubbleSort，冒泡排序
 * @Description BubbleSort
 */
public class BubbleSort {

    private BubbleSort() {
    }

    /**
     * 第一版
     *
     * @param data
     */
    public static void sort1(String[] data) {
        //循环次数
        //第一层循环，最大趟数 = length - 1
        //第二层循环，最大交换次数 = length - 1 - 外层循环计数器，因为数组末尾的有序区长度就是外层循环计数器的值

        int count = data.length - 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                //相邻位置 比较 交换
                if (data[j].compareTo(data[j + 1]) > 0) {
                    String temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }

            }
        }
    }

    /**
     * 第二版：内层循环没有交换元素，则说明已经全部有序，所以直接返回
     *
     * @param data
     */
    public static void sort2(int[] data) {

        int count = data.length - 1;
        for (int i = 0; i < count; i++) {
            boolean isSorted = true;
            for (int j = 0; j < count - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    isSorted = false;
                }
            }

            if (isSorted) {
                return;
            }
        }
    }

    /**
     * 第三版：优化数组末尾的有序边界，有序边界应该为内层循环最后一次改变位置的地方
     *
     * @param data
     */
    public static void sort3(int[] data) {

        int count = data.length - 1;
        int sortBorder = count;
        int lastExchangeIndex = 0;

        for (int i = 0; i < count; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }

            sortBorder = lastExchangeIndex;
            if (isSorted) {
                return;
            }
        }
    }

}
