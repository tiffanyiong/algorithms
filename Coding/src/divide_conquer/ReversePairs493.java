package divide_conquer;

// https://leetcode.cn/problems/reverse-pairs/description/
public class ReversePairs493 {
    int MAXN = 50001;
    int[] helper = new int[MAXN];

    public int reversePairs(int[] nums) {
        return count(nums, 0, nums.length - 1);
    }

    public int count(int[] nums, int l, int r) {
        if (l == r) return 0;
        int m = (l + r) / 2;
        // 左側的對 ＋右側的對 ＋ 跨左右側的結果
        return count(nums, l, m) + count(nums, m + 1, r) + merge(nums, l, m, r);
    }

    public int merge(int[] nums, int l, int m, int r) {
        // 先統計 後排序 （排序是為了方便後面計算跨左右的pairs
        int ans = 0;
        // l... m    m +1......r
        // i         j    (看j 能走多少個)
        for (int i = l, sum = 0, j = m + 1; i <= m; i++) {
            while (j <= r && (long) nums[i] > (long) nums[j] * 2) {
                j++;
                sum++; // 不寫sum 用j都可以的
            }
            ans += sum; // ans += j - m - 1;
        }


        int a = l;
        int b = m + 1;
        int k = l;

        while (a <= m && b <= r) {
            helper[k++] = nums[a] < nums[b] ? nums[a++] : nums[b++];
        }

        while (a <= m) helper[k++] = nums[a++];

        while (b <= r) helper[k++] = nums[b++];

        for (int x = l; x <= r; x++) {
            nums[x] = helper[x];
        }
        return ans;
    }
}
