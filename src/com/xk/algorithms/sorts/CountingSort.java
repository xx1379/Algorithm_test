package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/20 22:42
 */
public class CountingSort {
    /*
    计数排序是一个非基于比较的排序算法，它的复杂度为Ο(n+k)（其中k是整数的范围），
    适用于一定范围的整数排序(或者通过整数比较的对象)。在取值范围不是很大的情况下，它的性能在某些情况甚至快过那些O(nlogn)的排序。
     */
    public static void sort(Integer[] unsorted) {
        int max = findMax(unsorted);
        int min = findMin(unsorted);
        int offset = -min;
        int[] counts = new int[max - min + 1];
        updateCounts(unsorted, counts, offset);
        sort(unsorted, counts, offset);
    }

    private static void updateCounts(Integer[] unsorted, int[] counts, int offset) {
        for (int i : unsorted) {
            counts[i + offset]++;
        }
        //实现稳定排序
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
    }

    private static void sort(Integer[] unsorted, int[] counts, int offset) {
        for (int i = counts.length - 1; i >= 0; i--) {
            unsorted[counts[i] - 1] = i - offset;
            counts[i]--;
        }
    }

    public static int findMax(Integer[] unsorted) {
        int max = Integer.MIN_VALUE;
        for (int i : unsorted) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static int findMin(Integer[] unsorted) {
        int min = Integer.MAX_VALUE;
        for (int i : unsorted) {
            min = Math.min(min, i);
        }
        return min;
    }
}
