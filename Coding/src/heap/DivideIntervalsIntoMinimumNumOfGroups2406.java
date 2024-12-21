package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/divide-intervals-into-minimum-number-of-groups/
public class DivideIntervalsIntoMinimumNumOfGroups2406 {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b ) -> (a[0] - b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // default is a min heap
        for (int i = 0; i < n; i++) {
            // 頂部 小於 左區間的值 (和 meeting rooms 2那題這裡不一樣，不用<=)
            if (!minHeap.isEmpty() && minHeap.peek() < intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}
