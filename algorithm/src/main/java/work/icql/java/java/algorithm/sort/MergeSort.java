package work.icql.java.java.algorithm.sort;

import java.util.Arrays;

/**
 * @author icql
 * @version 1.0
 * @date 2019/6/11 11:24
 * @Title MergeSort，归并排序
 * @Description MergeSort
 */
public class MergeSort {

    private MergeSort() {
    }

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序（前闭区间，后闭区间）
     *
     * @param data  待排序数组
     * @param left
     * @param right
     */
    public static void sort(int[] data, int left, int right) {
        //对于递归，要处理递归到底的判断，这里就是left>=right。
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        //左
        sort(data, left, mid);
        //右
        sort(data, mid + 1, right);

        //region 归并

        //赋值临时数组，用来保存当前 用以归并的数据
        int[] aux = Arrays.copyOfRange(data, left, right + 1);

        //初始化，在临时数组aux中
        //leftIndex代表左边数组的索引，rightIndex代表右边数组的索引
        //auxMidIndex代表临时数组的中间值索引，auxRight代表临时数组的右边界值
        int leftIndex = 0, auxMidIndex = mid - left, rightIndex = auxMidIndex + 1, auxRight = right - left;


        //遍历重新设置 原数组 [left,right] 的值使之有序
        for (int k = left; k <= right; k++) {

            //左边元素已经处理完
            if (leftIndex > auxMidIndex) {
                data[k] = aux[rightIndex];
                rightIndex++;
            }

            //右边元素已经处理完
            else if (rightIndex > auxRight) {
                data[k] = aux[leftIndex];
                leftIndex++;
            }

            //如果左边所指元素 < 右边所指元素
            else if (aux[leftIndex] < aux[rightIndex]) {
                data[k] = aux[leftIndex];
                leftIndex++;
            }

            //如果左边所指元素 >= 右边所指元素
            else {
                data[k] = aux[rightIndex];
                rightIndex++;
            }
        }

        //endregion

    }
}
