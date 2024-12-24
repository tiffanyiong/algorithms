package bitManipulation;

// https://leetcode.cn/problems/power-of-three/description/
public class PowerOfThree326 {

    // time complexity: O(1)
    public boolean isPowerOfThree(int n) {
        // n 如果是3的某次方幂，代表它一定只有3的質數因子
        // 1162261467 是有符號整數的範圍內最大3的幂
        // 判斷n是否為 3^19的約數 1162261467 % n == 0
        // if 1162261467 % n != 0, 即n 有其他因子
        return n > 0 && 1162261467 % n == 0;
    }

    // O(logn)
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
