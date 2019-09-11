package work.icql.java.datastructureold.impl;

import work.icql.java.datastructureold.Str;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/28 11:13
 * @Title StringImpl
 * @Description 线性结构——串（顺序表实现）
 */
public class StringImpl implements Str {
    /**
     * 基本模式匹配算法：
     * 算法时间复杂度：代码段中所有循环体的执行次数与循环体的变量之间的函数关系，一般指最坏情况，即循环最大次数
     * 匹配不到即最坏情况，循环体变量 i的最大值为bigStr的长度m，j的最大值为smallStr的长度n，最坏情况是 f(m,n)=(m-n+1)*n，即算法时间复杂度为 O((m-n+1)*n)
     *
     * @return
     */
    public int index1(char[] bigStr, char[] smallStr) {
        int i = 0;//bigStr下标
        int j = 0;//smallStr下标
        while (i < bigStr.length && j < smallStr.length) {
            if (bigStr[i] == smallStr[j]) {
                i++;
                j++;
            } else {
                //返回到之前的索引
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == smallStr.length) {
            return i - j;
        } else {
            return -1;
        }
    }


    /**
     * KMP模式匹配算法：
     * 主串匹配失败位i之前的都是与模式串j位之前是相同的，如果模式串的前j位的前后缀有相同的，我们取前后缀相同的最大程度为k位，则将j向前移动k位，i不动
     * 就可以保证移动后的模式串的j位已经匹配
     * 算法时间复杂度：模式串无前后缀相同的且主串匹配不到模式串，经测试，f(m,n)=2m+n，即 O(m+n)
     *
     * @param bigStr
     * @param smallStr
     * @return
     */
    public int index2(char[] bigStr, char[] smallStr) {
        int[] next = getNext(smallStr);//获取模式串的next数组
        for (int i : next) {
            System.out.println(i);
        }
        int i = 0;//bigStr下标
        int j = 0;//smallStr下标
        while (i < bigStr.length && j < smallStr.length) {
            if (j == -1 || bigStr[i] == smallStr[j]) {
                i++;
                j++;
            } else {
                //去除 i回溯到之前位置
                j = next[j];
            }
        }
        if (j == smallStr.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * next数组求解：j位前的子串的前后缀最大相同的长度为k
     * ababcd
     * ----0、next=[-1,0,0,1,2,0]
     * --------0）j=0，字串为空，k=-1
     * --------1）j=1，字串为a，没有前后缀，k=0
     * --------2）j=2，字串为ab，前缀a，后缀b，k=0
     * --------3）j=3，字串为aba，前缀a/ab，后缀b/ba，k=1
     * --------4）j=4，字串为abab，前缀a/ab/aba，后缀b/ab/bab，k=2
     * --------4）j=5，字串为ababc，前缀a/ab/aba/abab，后缀c/bc/abc/babc，k=0
     *
     * @param p
     * @return
     */
    private int[] getNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;//初始值为-1
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
