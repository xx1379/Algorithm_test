package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/19 22:44
 */
public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;
        //构造大顶堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            sink(unsorted, i, length);
        }
        while (length > 0) {
            SortUtil.swap(unsorted, 0, length - 1);
            length--;
            sink(unsorted, 0, length);
        }
    }

    private static <T extends Comparable<T>> void sink(T[] unsorted, int index, int length) {
        while (2 * index + 1 < length) {
            int child = 2 * index + 1;
            if (child + 1 < length && unsorted[child].compareTo(unsorted[child + 1]) < 0) {
                child++;
            }
            if (unsorted[index].compareTo(unsorted[child]) > 0) {
                break;
            }
            SortUtil.swap(unsorted, index, child);
            index = child;
        }
    }

    private static <T extends Comparable<T>> void swim(T[] unsorted, int index) {
        while (index > 0 && unsorted[index].compareTo(unsorted[(index - 1) / 2]) > 0) {
            SortUtil.swap(unsorted, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


}
