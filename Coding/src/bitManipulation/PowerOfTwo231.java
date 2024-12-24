package bitManipulation;

// https://leetcode.cn/problems/power-of-two/description/
public class PowerOfTwo231 {
    /*
    首先 n 一定是要大於 0, 2的 0次方是 ＝ 1
    其次，在二進制裡，2的 m次方也只有一個 1
    e.g.
    0001 = 1 (2^0)
    0010 = 2
    0100 = 4
    1000 = 8
     */

    public boolean isPowerOfTwo(int n) {
        // brian kernighan algorithm 取最右側的1的狀態
        // 如果它和 n 相同，即就是 2的m次方的數

        // e.g.
        // n = 6 (binary: 00000110):
        // n > 0 -> true
        // n & −n = 00000110  &
        //          11111010 + 1 = 00000010.
        // n == (n & -n) → false.
        //6 is not a power of two.
        return n > 0 && n == (n & -n);
    }
}
