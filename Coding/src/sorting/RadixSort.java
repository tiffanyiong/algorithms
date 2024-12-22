package sorting;

import java.util.Arrays;

// https://leetcode.cn/problems/sort-an-array/

public class RadixSort {
    int BASE = 10; //這裡當成十進制，就算改成100也不影響核心代碼
    int MAXN = 50001;
    int[] helper = new int[MAXN];
    int[] counts = new int[BASE];

    public int[] sortArray(int[] nums) {
        if (nums.length == 0) return nums;

        int n = nums.length;
        // 為了可以算負數，先把所有數減掉最小值
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
        }
        // 要知道最大值
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] -= min;
            max = Math.max(max, nums[i]);
        }
        // 要按照 max在base進制下的位數決定做多少輪基數排序
        radixSort(nums, n, bits(max));
        // 數組上所有數，在上面都被減去了最小值，最後要還原
        for (int i = 0; i < n; i++) {
            nums[i] += min;
        }

        return nums;
    }


    public void radixSort(int arr[], int n, int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            // e.g. "abcd" then bits = 4
            // offset     1
            //           10
            //          100
            //         1000

            // counts 用來紀錄此進制裡的數字出現了多少次
            Arrays.fill(counts, 0);
            for (int i = 0; i < n; i++) {
                counts[(arr[i] / offset) % BASE]++;
            }

            // 前綴次數累加
            for (int i = 1; i < BASE; i++) {
                counts[i] = counts[i] + counts[i - 1];
            }
            // 從右往左開始排序
            for (int i = n - 1; i >= 0; i--) {
                // 前綴數量分區
                // 數字提取某一位數
                // 累加和減 1 就是它該被放進的helper's index
                helper[--counts[(arr[i] / offset) % BASE]] = arr[i];
            }

            for (int i = 0; i < n; i++) {
                arr[i] = helper[i];
            }
        }
    }

    // 返回number在BASE進制下有幾位
    public int bits(int num) {
        int ans = 0;
        while (num > 0) {
            ans++;
            num /= BASE;
        }
        return ans;
    }
}
