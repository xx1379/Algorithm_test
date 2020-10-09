package com.xk.algorithms.sorts;

import java.util.Arrays;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/9 21:37
 */
public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 4, 6, 7, 8, 3, 4, 5, 6, 2, 1, 10};
        InsertionSort.sort(arr);
        assert SortUtil.isSorted(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int length = unsorted.length;

        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && unsorted[j].compareTo(unsorted[j - 1]) < 0; j--) {
                SortUtil.swap(unsorted, j, j - 1);
            }
        }
        return unsorted;
    }
}
