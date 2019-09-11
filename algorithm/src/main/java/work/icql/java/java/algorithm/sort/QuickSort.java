package work.icql.java.java.algorithm.sort;

/**
 * @author icql
 * @version 1.0
 * @date 2019/4/18 15:07
 * @Title QuickSort，快速排序
 * @Description QuickSort
 */
public class QuickSort {

    private QuickSort() {
    }

    public static void sort(int[] data, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int base = 0;

        //待排序的元素至少有两个的情况
        if (leftIndex <= rightIndex) {
            //待排序的第一个元素作为基准元素
            base = data[leftIndex];
            //从左右两边交替扫描，直到leftIndex = rightIndex
            while (leftIndex != rightIndex) {
                //从右往左扫描，找到第一个比基准元素小的元素
                while (rightIndex > leftIndex && data[rightIndex] >= base) {
                    rightIndex--;
                }

                //找到这种元素data[rightIndex]后与data[leftIndex]交换
                data[leftIndex] = data[rightIndex];

                //从左往右扫描，找到第一个比基准元素大的元素
                while (leftIndex < rightIndex && data[leftIndex] <= base) {
                    leftIndex++;
                }

                //找到这种元素data[leftIndex]后，与data[rightIndex]交换
                data[rightIndex] = data[leftIndex];
            }

            //基准元素归位
            data[rightIndex] = base;

            //对基准元素左边的元素进行递归排序
            sort(data, left, leftIndex - 1);
            //对基准元素右边的进行递归排序
            sort(data, rightIndex + 1, right);
        }
    }
}
