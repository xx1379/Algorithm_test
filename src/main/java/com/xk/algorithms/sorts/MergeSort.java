package com.xk.algorithms.sorts;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/12 23:13
 */
public class MergeSort {
    //枚举类的对象都是 public static final,不用明写static
    public enum SPACE_TYPE {IN_PLACE, NOT_IN_PLACE}

    public enum SORT_TYPE {INTERATION, RECURSION}

    public static <T extends Comparable<T>> void sort(T[] unsorted, SPACE_TYPE spaceType, SORT_TYPE sortType) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[unsorted.length];
        if (sortType == SORT_TYPE.RECURSION) {
            recursion_sort(unsorted, temp, 0, unsorted.length - 1, spaceType);
        } else {
            iteration_sort(unsorted, temp, 0, unsorted.length - 1, spaceType);
        }
    }

    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[unsorted.length];
        iteration_sort(unsorted, temp, 0, unsorted.length - 1, SPACE_TYPE.NOT_IN_PLACE);
    }

    public static <T extends Comparable<T>> void recursion_sort(T[] unsorted, T[] temp, int start, int end, SPACE_TYPE spaceType) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        recursion_sort(unsorted, temp, start, mid, spaceType);
        recursion_sort(unsorted, temp, mid + 1, end, spaceType);
        //优化：测试数组是否已经有序
        if (unsorted[mid].compareTo(unsorted[mid + 1]) <= 0) {
            return;
        }
        if (spaceType == SPACE_TYPE.NOT_IN_PLACE) {
            mergeWithExtraSpace(unsorted, temp, start, mid, end);
        } else {
            mergeInPlace(unsorted, temp, start, mid, end);
        }

    }

    public static <T extends Comparable<T>> void iteration_sort(T[] unsorted, T[] temp, int start, int end, SPACE_TYPE spaceType) {
        int length = unsorted.length;
        for (int i = 1; i < length; i *= 2) {
            for (int j = 0; j < length - i; j += i * 2) {
                if (unsorted[j + i - 1].compareTo(unsorted[j + i]) <= 0) {
                    continue;
                }
                int min = Math.min(j + 2 * i - 1, length - 1);
                if (spaceType == SPACE_TYPE.NOT_IN_PLACE) {
                    mergeWithExtraSpace(unsorted, temp, j, j + i - 1, min);
                } else {
                    mergeInPlace(unsorted, temp, j, j + i - 1, min);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void mergeInPlace(T[] unsorted, T[] temp, int aStart, int aEnd, int bEnd) {
        int index1 = aStart;
        int index2 = aEnd + 1;
        while (index1 < index2 && index2 <= bEnd) {
            while (index1 < index2 && unsorted[index1].compareTo(unsorted[index2]) <= 0) {
                index1++;
            }
            int mid = index2 - 1;
            while (index2 <= bEnd && unsorted[index1].compareTo(unsorted[index2]) > 0) {
                index2++;
            }
            swapBlock(unsorted, index1, mid, index2 - 1);
            index1 += (index2 - 1 - mid);
        }
    }

    public static <T extends Comparable<T>> void swapBlock(T[] unsorted, int index1, int mid, int index2) {
        reverse(unsorted, index1, mid);
        reverse(unsorted, mid + 1, index2);
        reverse(unsorted, index1, index2);

    }

    public static <T extends Comparable<T>> void reverse(T[] unsorted, int left, int right) {
        while (left < right) {
            SortUtil.swap(unsorted, left++, right--);
        }
    }

    public static <T extends Comparable<T>> void mergeWithExtraSpace(T[] unsorted, T[] temp, int aStart, int aEnd, int bEnd) {
        System.arraycopy(unsorted, aStart, temp, aStart, bEnd - aStart + 1);
        int index1 = aStart;
        int index2 = aEnd + 1;
        for (int i = aStart; i <= bEnd; i++) {
            if (index1 > aEnd) {
                unsorted[i] = temp[index2++];
            } else if (index2 > bEnd) {
                unsorted[i] = temp[index1++];
            } else if (temp[index1].compareTo(temp[index2]) < 0) {
                unsorted[i] = temp[index1++];
            } else {
                unsorted[i] = temp[index2++];
            }
        }
    }

}
