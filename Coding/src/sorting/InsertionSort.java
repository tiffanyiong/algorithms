package sorting;

import validator.Validator;

import static sorting.BubbleSort.bubbleSort;
import static sorting.SelectionSort.selectionSort;
import static utils.utils.swap;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            // already at i, we need to look at the previous(left) one.
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        // test array length
        int N = 200;
        int V = 1000;
        int testTimes = 100;
        System.out.println("Start testing...");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = Validator.randomArray(N, V);
            int[] arr1 = Validator.copyArray(arr);
            int[] arr2 = Validator.copyArray(arr);
            int[] arr3 = Validator.copyArray(arr);

            bubbleSort(arr1);
            selectionSort(arr2);
            insertionSort(arr3);

            if (!Validator.isSameArray(arr1, arr2) || !Validator.isSameArray(arr1, arr3)) {
                System.out.println("something went wrong");
            }

        }
        System.out.println("=== Testing Completed successfully ===");
    }
}
