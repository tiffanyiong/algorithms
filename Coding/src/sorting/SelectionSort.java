package sorting;

import static utils.utils.swap;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                  minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 9, 3, 10, 5, 6, 7, 8, 2, 4};
        selectionSort(array);

        for (int i: array) {
            System.out.print(i + " ");
        }
    }
}
