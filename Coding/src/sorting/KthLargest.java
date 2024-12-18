package sorting;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class KthLargest {

    public static void main(String[] args) {
        int[] arr = new int[] {9,7, 3, 1,6,7,8, 5};
        int k = 3;
        int ans = findKthLargest(arr, 3);
        System.out.println(String.format("the %s largest Element is: %s ", k, ans));
    }
    public static int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    public static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r;) {
            partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
            if (i < first) {  // i index 在 <x的區域裡
                r = first - 1;
            } else if (i > last) { // 在 >x 裡面找
                r = last + 1;
            } else {  // 相當於在 ＝＝x的範圍裡面
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

    static int first;
    static int last;
    public static void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(arr, first++, i++);
            } else {
                swap(arr, last--, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
