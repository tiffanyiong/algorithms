package bitManipulation;

// https://leetcode.cn/problems/missing-number/description/
public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        // 異或總共(不缺）有的數字
        int xor_expected = 0;
        // 異或總共(缺）有的數字
        int xor_nums = 0;

        for (int i = 0; i < nums.length; i++) {
            xor_expected ^= i;
            xor_nums ^= nums[i];
        }
        xor_expected ^= nums.length;

        return xor_expected ^ xor_nums;
    }
}
