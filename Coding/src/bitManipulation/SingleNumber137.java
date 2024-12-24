package bitManipulation;

// https://leetcode.cn/problems/single-number-ii/description/
public class SingleNumber137 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            // counts[0]  : 0 位上有多少個1
            // counts[1]  : 1 位上有多少個1
            // counts[31] : 31 位上有多少個1
            for (int i = 0; i < 32; i++) {
                counts[i] += (num >> i) & 1; // 計下第i位上有多少個1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 有餘數代表就是那個少於n次的數
            if (counts[i] % 3 != 0) { // 題目是所有數都出現3次 except for one
                // 把1加到第 i位數上
                ans |= 1 << i; // ans = ans | (1 << i)
            }
        }
        return ans;
    }
}
