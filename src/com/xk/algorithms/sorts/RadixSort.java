package com.xk.algorithms.sorts;

import java.util.Arrays;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/22 21:51
 */
public class RadixSort {
    /*
    基数排序  正整数
    将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
    然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     */

    public static void sort(Integer[] unsorted) {
        int digit = getMaxDigit(unsorted);
        int length = unsorted.length;
        int[][] bucket = new int[10][length];
        int[] count = new int[10]; //记录每个桶内的元素个数
        int divisor = 1;
        for (int i = 0; i < digit; i++) {
            int remainder;
            for (int d : unsorted) {
                remainder = (d / divisor) % 10;
                bucket[remainder][count[remainder]++] = d;
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < count[j]; k++) {
                    unsorted[index++] = bucket[j][k];
                }
            }
            divisor *= 10;
            Arrays.fill(count, 0);
        }

    }

    public static int getMaxDigit(Integer[] unsorted) {
        int maxDigit = Integer.MIN_VALUE;
        for (int d : unsorted) {
            int digit = (int) Math.log10(d) + 1;
            maxDigit = Math.max(digit, maxDigit);
        }
        return maxDigit;
    }
}
