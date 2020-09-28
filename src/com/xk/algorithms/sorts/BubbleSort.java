package com.xk.algorithms.sorts;

import java.util.Arrays;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/9/27 23:02
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 4, 6, 7, 8, 3, 4, 5, 6, 2, 1, 10};
        BubbleSort.sort(arr);
        assert SortUtil.isSorted(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
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
        return unsorted;
    }
}
