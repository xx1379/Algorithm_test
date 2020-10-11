package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/9/28 23:14
 */
public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (SortUtil.less(unsorted[j], unsorted[min])) {
                    min = j;
                }
            }
            SortUtil.swap(unsorted, i, min);
        }
    }
}
