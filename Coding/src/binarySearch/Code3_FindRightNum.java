package binarySearch;

import validator.Validator;

import java.util.Arrays;

/**
 * Find <= num, right position
 */
public class Code3_FindRightNum {

    public static int findRightNum(int[] arr, int num) {
        int ans = -1;
        int left = 0, right = arr.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            // mid = (left + right) / 2
            if (arr[mid] <= num) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }


    public static int returnRightAnswer(int[] arr, int target) {
        for (int i =arr.length - 1; i >=0; i--) {
            if (arr[i] <= target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int N = 200;
        int V = 1000;
        int times = 50000;
        System.out.println("start testing...");
        for (int i = 0; i < times; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = Validator.randomArray(n, V);
            Arrays.sort(arr);

            int target = (int) (Math.random() * N);

            if (findRightNum(arr, target) != returnRightAnswer(arr, target)) {
                System.out.println("something went wrong");
            }
        }
        System.out.println(" ====Test completed===");
    }

}
