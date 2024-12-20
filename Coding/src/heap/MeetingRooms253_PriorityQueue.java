package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/meeting-rooms-ii/description/

/**
 * Given an array of meeting time intervals, intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 */
public class MeetingRooms253_PriorityQueue {

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));
        for (int i = 0; i < n; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}
