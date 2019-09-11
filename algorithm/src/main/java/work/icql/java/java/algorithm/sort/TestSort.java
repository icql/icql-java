package work.icql.java.java.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * @author icql
 * @version 1.0
 * @date 2019/6/10 15:38
 * @Title TestSort
 * @Description TestSort
 */
public class TestSort {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        //Random random = new Random();
        //BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\a6924.GOLDDRAGON.COM\\Desktop\\test1\\_000", true));
        //
        //for (int i = 0; i < 1000000; i++) {
        //    writer.write(String.valueOf(random.nextInt(1000000)));
        //    writer.write("\n");
        //}
        //writer.close();

        //冒泡排序第一版，224ms
        //BubbleSort.sort1(data);

        //冒泡排序第二版，177ms
        //BubbleSort.sort2(data);

        //冒泡排序第三版，186ms
        //BubbleSort.sort3(data);

        //简单选择排序，65ms
        //SelectionSort.sort(data);

        //简单插入排序，22ms
        //InsertionSort.sort(data);

        //归并排序，5ms
        //MergeSort.sort(data, 0, data.length - 1);

        //快速排序，4ms
        //QuickSort.sort(data, 0, data.length - 1);


        BufferedReader reader = new BufferedReader(new FileReader("C:\\\\Users\\\\a6924.GOLDDRAGON.COM\\\\Desktop\\\\test1\\\\_000"));
        String s = null;
        while ((s=reader.readLine())!= null){
            int file = Integer.valueOf(s) / 1000;
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\a6924.GOLDDRAGON.COM\\Desktop\\test1\\" + file, true));
            writer.write(s);
            writer.write(",");
            writer.close();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\a6924.GOLDDRAGON.COM\\Desktop\\test1\\_111", true));
        for (int i = 0; i < 1000; i++) {
            byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\a6924.GOLDDRAGON.COM\\Desktop\\test1\\" + i));
            String[] num = (new String(bytes)).split(",");
            Arrays.sort(num);
            writer.write(Arrays.toString(num)+"\n");
        }
        writer.close();

        long end = System.currentTimeMillis();


        System.out.println(end - start + "ms");
    }
}
