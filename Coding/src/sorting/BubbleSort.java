package sorting;

import validator.Validator;

import static utils.utils.swap;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // 0 ~ n-1 sorting  e.g. {3, 4, 1, 2, [5]}    5 already done sorting
        // next time start from index 0 to 3
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) { // compare every element
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Validator.randomArray(10, 10);
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
