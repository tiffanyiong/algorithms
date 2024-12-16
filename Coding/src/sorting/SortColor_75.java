package sorting;

// https://leetcode.cn/problems/sort-colors/
// 這個只用到partition, 且並不是隨機行為，題目只要分3個顏色
// time complexity  O（N） 不用到 O(n *log n)
// space complexity O（1）
public class SortColor_75 {
    int firstX, lastX;
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        partition(nums, start, end);
    }


    public void partition(int[] nums, int l, int r) {
        firstX = l;
        lastX = r;
        int i = l;
        while (i <= lastX) {
            // == x
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, firstX++, i++);
            } else {
                swap(nums, i, lastX--);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
