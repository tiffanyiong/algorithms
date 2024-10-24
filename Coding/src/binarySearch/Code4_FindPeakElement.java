package binarySearch;

/**
 * LC 162. Find Peak Element
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * //除了sorted array, 某側必有 / 某側必沒有 的題都能用二分
 */
public class Code4_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;        // it has only one element    e.g.   -1 {3} -1
        if (nums[0] > nums[1]) return 0;    // verify the peak    e.g. {4,1}
        if (nums[n - 1] > nums[n - 2]) return n - 1;   // verify "peak - 1", not the peak itself,     e.g. {1,2}

        // we can use binary search for any other cases
        // XX    ---some peaks --   XX
        //  0                       n - 1
        // peaks: must be in between 1 ~ n-2
        // a peak must be in left...right
        int left = 0, right = n - 1;
        int mid = 0;
        int ans = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                ans = mid;
                break;
            }
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;


    }
}
