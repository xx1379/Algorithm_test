package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/15 21:28
 */
public class QuickSort {

    public static final int M = 15;

    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        sort(unsorted, 0, unsorted.length - 1);

    }

    public static <T extends Comparable<T>> void sort(T[] unsorted, int left, int right) {
        if (left >= right) {
            return;
        }
        //优化：小数组时切换到插入排序;对于小数组，快速排序比插入排序慢
        if (right <= left + M) {
            InsertionSort.sort(unsorted, left, right);
        } else {
            int mid = partition(unsorted, left, right);
            sort(unsorted, left, mid - 1);
            sort(unsorted, mid + 1, right);
        }

    }

    //优化：三向切分快速排序，将相等的元素归出一类，避免参与递归
//    public static <T extends Comparable<T>> void sort3way(T[] unsorted, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int lt = left;
//        int eq = left + 1;
//        int gt = right;
//        int pivot = left;
//
//
//    }

    public static <T extends Comparable<T>> int partition(T[] unsorted, int left, int right) {
        fixPivot(unsorted, left, right);
        T pivot = unsorted[right];
        int i = left;
        int j = right - 1;
        while (i < j) {
            while (i < j && unsorted[i].compareTo(pivot) < 0) {
                i++;
            }
            while (j > i && unsorted[j].compareTo(pivot) > 0) {
                j--;
            }
            SortUtil.swap(unsorted, i, j);
        }
        SortUtil.swap(unsorted, right, j);
        return j;
    }

    //优化：三取样切分，避免切分不平衡
    public static <T extends Comparable<T>> void fixPivot(T[] unsorted, int left, int right) {
        int mid = (left + right) / 2;
        if (unsorted[left].compareTo(unsorted[mid]) > 0) {
            SortUtil.swap(unsorted, left, mid);
        }
        if (unsorted[mid].compareTo(unsorted[right]) > 0) {
            SortUtil.swap(unsorted, mid, right);
        }
        if (unsorted[left].compareTo(unsorted[right]) > 0) {
            SortUtil.swap(unsorted, left, right);
        }
        SortUtil.swap(unsorted, mid, right);
    }
}
  