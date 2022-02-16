package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/9/28 23:28
 */
public class SortUtil {

    public static <T extends Comparable<T>> void swap(T[] unsorted, int index1, int index2) {
        T temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }

    public static <T extends Comparable<T>> boolean less(T value1, T value2) {
        return value1.compareTo(value2) < 0;
    }
}
