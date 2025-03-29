package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;

import java.util.Arrays;

import java.util.List;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true if <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr1 = makeTestArray();
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] arr3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] arr4 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Integer[] arr5 = {-4, 57, 9, -15, 0, 81, -1000, 734, 8, 0};
        func.accept(arr1);
        assertTrue(sorted(arr1));
        func.accept(arr2);
        assertTrue(sorted(arr2));
        func.accept(arr3);
        assertTrue(sorted(arr3));
        func.accept(arr4);
        assertTrue(sorted(arr4));
        func.accept(arr5);
        assertTrue(sorted(arr5));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }
    
    @Test
    public void testMySort() {
        testSort(Sorts::mySort);
    }
    
    @Test
    public void testEventBubbleSort() {
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> list = Sorts.bubbleSort(arr);
        Sorts.eventSort(copyArr, list);
        Arrays.equals(arr, copyArr);
    }
    
    @Test
    public void testEventInsertionSort() {
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> list = Sorts.insertionSort(arr);
        Sorts.eventSort(copyArr, list);
        Arrays.equals(arr, copyArr);
    }
    
    @Test
    public void testEventSelectionSort() {
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> list = Sorts.selectionSort(arr);
        Sorts.eventSort(copyArr, list);
        Arrays.equals(arr, copyArr);
    }
    
    @Test
    public void testEventMergeSort() {
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> list = Sorts.mergeSort(arr);
        Sorts.eventSort(copyArr, list);
        Arrays.equals(arr, copyArr);
    }
    
    @Test
    public void testEventQuickSort() {
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> list = Sorts.quickSort(arr);
        Sorts.eventSort(copyArr, list);
        Arrays.equals(arr, copyArr);
    }
    
    @Test
    public void testEventMySort() {
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> list = Sorts.mySort(arr);
        Sorts.eventSort(copyArr, list);
        Arrays.equals(arr, copyArr);
    }
}