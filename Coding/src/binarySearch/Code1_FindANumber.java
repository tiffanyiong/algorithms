package binarySearch;

import javax.swing.text.Utilities;
import java.util.Arrays;
import java.util.Random;

/**
 * find a number in a 'sorted' array
 */
public class Code1_FindANumber {
    public static boolean isNumExist(int[] arr, int target) {
        if (arr == null || arr.length < 1) return false;
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == target) {
                return true;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    public static boolean numInSortedArray(int[] arr, int target) {
        for (int i : arr) {
            if (target == i) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 20;
        int V = 100;
        int times = 10000;
        System.out.println("start testing...");

        for (int i = 0; i < times; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = new int[n];
            for (int j = 0; i < arr.length; i++) {
                int number = (int) (Math.random() * V) + 1;
                arr[j] = number;
            }
            Arrays.sort(arr);
            int target = 10;
            if (isNumExist(arr, target) != numInSortedArray(arr, target)) {
                System.out.println("something went wrong!!");
            }

        }
        System.out.println("====Test Completed Successfully====");

    }
}
