package bitManipulation;

// https://leetcode.cn/problems/single-number/description/

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
