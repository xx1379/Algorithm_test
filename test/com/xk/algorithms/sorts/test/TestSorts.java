package com.xk.algorithms.sorts.test;


import com.xk.algorithms.sorts.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * @Author Ke Xiao <xiaokexkxk@126.com>
 * @Date 2020/10/11 20:55
 */
public class TestSorts {
    private static final Random RANDOM = new Random();
    private static final int SIZE = 10000;

    private static Integer[] unsorted = null;
    private static Integer[] sorted = null;
    private static Integer[] reverse = null;

    @BeforeClass
    public static void setUpBeforeClass() {
        unsorted = new Integer[SIZE];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = RANDOM.nextInt();
        }

        sorted = new Integer[SIZE];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }

        reverse = new Integer[SIZE];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = reverse.length - i;
        }
    }

    private static boolean check(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    private static String printArr(Integer[] array) {
        return Arrays.toString(array);
    }

    private static void assertMethod(String sortName, Integer[] array) {
        assertTrue(sortName + " sort unsorted error, result:" + printArr(array), check(array));
    }

    @Test
    public void TestBubbleSort() {
        Integer[] unsortedArr = unsorted.clone();
        BubbleSort.sort(unsortedArr);
        assertMethod("BubbleSort", unsortedArr);

        Integer[] sortedArr = sorted.clone();
        BubbleSort.sort(sortedArr);
        assertMethod("BubbleSort", sortedArr);

        Integer[] reverseArr = reverse.clone();
        BubbleSort.sort(reverseArr);
        assertMethod("BubbleSort", reverseArr);
    }

    @Test
    public void TestSelectionSort() {
        Integer[] unsortedArr = unsorted.clone();
        SelectionSort.sort(unsortedArr);
        assertMethod("SelectionSort", unsortedArr);

        Integer[] sortedArr = sorted.clone();
        SelectionSort.sort(sortedArr);
        assertMethod("SelectionSort", sortedArr);

        Integer[] reverseArr = reverse.clone();
        SelectionSort.sort(reverseArr);
        assertMethod("SelectionSort", reverseArr);
    }

    @Test
    public void TestInsertionSort() {
        Integer[] unsortedArr = unsorted.clone();
        InsertionSort.sort(unsortedArr);
        assertMethod("InsertionSort", unsortedArr);

        Integer[] sortedArr = sorted.clone();
        InsertionSort.sort(sortedArr);
        assertMethod("InsertionSort", sortedArr);

        Integer[] reverseArr = reverse.clone();
        InsertionSort.sort(reverseArr);
        assertMethod("InsertionSort", reverseArr);
    }

    @Test
    public void TestShellSort() {
        Integer[] unsortedArr = unsorted.clone();
        ShellSort.sort(unsortedArr);
        assertMethod("ShellSort", unsortedArr);

        Integer[] sortedArr = sorted.clone();
        ShellSort.sort(sortedArr);
        assertMethod("ShellSort", sortedArr);

        Integer[] reverseArr = reverse.clone();
        ShellSort.sort(reverseArr);
        assertMethod("ShellSort", reverseArr);
    }

    @Test
    public void TestMergeSort_recursion_space() {
        Integer[] unsortedArr = unsorted.clone();
        MergeSort.sort(unsortedArr, MergeSort.SPACE_TYPE.NOT_IN_PLACE, MergeSort.SORT_TYPE.RECURSION);
        assertMethod("MergeSort", unsortedArr);

        Integer[] sortedArr = sorted.clone();
        MergeSort.sort(sortedArr, MergeSort.SPACE_TYPE.NOT_IN_PLACE, MergeSort.SORT_TYPE.RECURSION);
        assertMethod("MergeSort", sortedArr);

        Integer[] reverseArr = reverse.clone();
        MergeSort.sort(reverseArr, MergeSort.SPACE_TYPE.NOT_IN_PLACE, MergeSort.SORT_TYPE.RECURSION);
        assertMethod("MergeSort", reverseArr);
    }

    @Test
    public void TestMergeSort_iteration_space() {
        Integer[] unsortedArr = sorted.clone();
        MergeSort.sort(unsortedArr, MergeSort.SPACE_TYPE.NOT_IN_PLACE, MergeSort.SORT_TYPE.INTERATION);
        assertMethod("MergeSort", unsortedArr);

        Integer[] sortedArr = sorted.clone();
        MergeSort.sort(sortedArr, MergeSort.SPACE_TYPE.NOT_IN_PLACE, MergeSort.SORT_TYPE.INTERATION);
        assertMethod("MergeSort", sortedArr);

        Integer[] reverseArr = reverse.clone();
        MergeSort.sort(reverseArr, MergeSort.SPACE_TYPE.NOT_IN_PLACE, MergeSort.SORT_TYPE.INTERATION);
        assertMethod("MergeSort", reverseArr);
    }
}
