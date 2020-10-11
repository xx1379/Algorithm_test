package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/9/27 23:02
 */
public class BubbleSort {

    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;
        boolean swapFlag = true;
        while (swapFlag) {
            swapFlag = false;
            for (int i = 1; i < length; i++) {
                if (unsorted[i].compareTo(unsorted[i - 1]) < 0) {
                    SortUtil.swap(unsorted, i, i - 1);
                    swapFlag = true;
                }
            }
            length--;
        }
    }
}
