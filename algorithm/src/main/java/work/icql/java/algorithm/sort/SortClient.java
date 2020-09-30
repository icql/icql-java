package work.icql.java.algorithm.sort;

import work.icql.java.algorithm.sort.isnotN.QuickSort;

public class SortClient {

    public static void main(String[] args) throws Exception {

//        int dataCount = 100000;
//        int[] data = new int[dataCount];
//        Random random = new Random();
//        for (int i = 0; i < dataCount; i++) {
//            data[i] = random.nextInt(dataCount);
//        }

//        int[] data = new int[]{3, 2, 4, 5, 1};
        int[] data = new int[]{9, 6, 4, 7, 4, 1, 9, 9, 0, 2, 2};
        long start = System.currentTimeMillis();

        //冒泡排序第一版
        //BubbleSort.sort1(data);

        //冒泡排序第二版
        //BubbleSort.sort2(data);

        //冒泡排序第三版
        //BubbleSort.sort3(data);

        //插入排序第一版
        //InsertionSort.sort1(data);

        //插入排序第二版
        //InsertionSort.sort2(data);

        //选择排序
        //SelectionSort.sort(data);

        //归并排序
        //MergeSort.sort(data);

        //快速排序
        QuickSort.sort(data);

        long end = System.currentTimeMillis();

        System.out.println(end - start + "ms");
    }
}
