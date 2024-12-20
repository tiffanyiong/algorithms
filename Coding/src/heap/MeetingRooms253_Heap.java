package heap;

// https://leetcode.cn/problems/meeting-rooms-ii/description/

import java.util.Arrays;

/**
 * Given an array of meeting time intervals, intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 */
public class MeetingRooms253_Heap {

    int MAXN = 10001;
    int[] heap = new int[MAXN];
    // heap size
    int size = 0;

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        // int ans = 0;

        for (int i = 0; i < n; i++) {
            // when heap is not empty
            // and when the top is smaller or equal current value, then poll
            if (size > 0 && heap[0] <= intervals[i][0]) {
                heapPoll();
            }
            heapInsert(intervals[i][1]);
            // ans = Math.max(ans, size);
        }
        return size;
    }

    public void heapInsert(int x) { // x is new one
        heap[size] = x;
        int i = size++;
        // if the child is smaller than parent
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void heapPoll() {
        swap(0, --size); // 和堆尾交換
        int i = 0;
        int l = 1;
        // size是用來控制大小的，此時如果l在size範圍內，代表有左孩子
        while (l < size) {

            // 有左孩子，l
            // 右孩子，l + 1
            // 評選，最大的孩子，就要那個下標
            // 是有右孩子 且 比左孩子小嗎？是的話，就要右，則要左
            int child = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
            // ok, 上面選完最小的，接下來要和當前的數比較，取它下標
            child = heap[child] < heap[i] ? child : i;
            // 如果不小於當前的數就break;
            if (child == i) break;
            // 否則就swap
            swap(child, i);
            i = child;
            // 繼續往下個左孩子看
            l = i * 2 + 1;
        }
    }
}
