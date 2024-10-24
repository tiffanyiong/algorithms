package binarySearch;

import validator.Validator;

import java.util.Arrays;

/**
 * given a target, find the target number that is on the left side && <= target, return -1 otherwise.
 * return the index
 *
 * basically no one asks for <= num (most left position) in a sorted array because you can also look at index 0.
 */
public class Code2_FindLeft {

    public static int findLeftNum(int[] arr, int target) {
        int ans = -1;
        int left = 0, mid = 0, right = arr.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;
//            mid = left + ((right - left) >> 1);  int - 2^31, （range: 2^31 - 1) if the value is way too huge, it might be a negative after left + right...
//            mid = left + (right - left) / 2; this one is same as last line
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int returnRightAnswer(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int N = 10;
        int V = 100;
        int times = 50000;
        System.out.println("start testing...");
        for (int i = 0; i < times; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = Validator.randomArray(n, V);
            Arrays.sort(arr);

            int target = (int) (Math.random() * N);

           if (findLeftNum(arr, target) != returnRightAnswer(arr, target)) {
               System.out.println("something went wrong");
           }
        }
        System.out.println(" ====Test completed===");
    }


}
