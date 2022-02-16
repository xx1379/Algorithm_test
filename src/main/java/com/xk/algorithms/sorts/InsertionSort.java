package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/9 21:37
 */
public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && unsorted[j].compareTo(unsorted[j - 1]) < 0; j--) {
                SortUtil.swap(unsorted, j, j - 1);
            }
        }
    }

    public static <T extends Comparable<T>> void sort(T[] unsorted, int left, int right) {
        for (int i = left; i <= right; i++) {
            for (int j = i; j > 0 && unsorted[j].compareTo(unsorted[j - 1]) < 0; j--) {
                SortUtil.swap(unsorted, j, j - 1);
            }
        }
    }
}
