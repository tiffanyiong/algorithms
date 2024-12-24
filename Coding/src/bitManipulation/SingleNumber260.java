package bitManipulation;

// https://leetcode.cn/problems/single-number-iii/description/
// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
// Find the two elements that appear only once. You can return the answer in any order.
//
//You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
// 即找出2個奇數頻率出現的數


public class SingleNumber260 {
    public int[] singleNumber(int[] nums) {
        int xor1 = 0;
        for (int n : nums) {
            xor1 ^= n;
        }
        // xor1 = a ^ b


        // brian kernighan算法, 提取二進制裡的最右側的 1 ，（取它的狀態）a 和 b肯定是不一樣
        // 它這個算法就是: x & ((~x)+1)
        int rightOne = xor1 & (-xor1);
        int xor2 = 0; // 需要求出 xor2 最後是 a OR b

        for (int num : nums) {
            // 要找出 沒有 "最右側 1" 的數
            // rightOne: 0000 0100
            // num     : 0000 0011 這就沒有1

            // num & rightOne 即求"與"， bit相同的才取，bit 不相等時為0
            if ((num & rightOne) == 0) {
                xor2 ^= num;
            }
            // xor2最後等於 a 或者 b
        }

        // 返回，a, a ^ b
        // xor1 ^ xor2 即，(a ^ b) ^ (b) 或者 (a ^ b) ^ (a)
        // 消掉之後就只剩 a OR b了
        return new int[] {xor2, xor1 ^ xor2};
}
}
