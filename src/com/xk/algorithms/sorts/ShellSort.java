package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/11 20:26
 */
public class ShellSort {

    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;
        int h = 1;
        while (h < length) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && unsorted[j].compareTo(unsorted[j - h]) < 0; j -= h) {
                    SortUtil.swap(unsorted, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
