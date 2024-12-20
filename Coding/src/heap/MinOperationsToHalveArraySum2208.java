package heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/description/
 *
 * You are given an array nums of positive integers.
 * In one operation, you can choose any number from nums and reduce it to exactly half the number.
 * (Note that you may choose this reduced number in future operations.)
 *
 * Return the minimum number of operations to reduce the sum of nums by <b>at least</b> half.
 */
public class MinOperationsToHalveArraySum2208 {

    // 用Priority Queue 解：
    // 每次都找最大值去砍半，肯定最快砍到sum/2
    // 用Max-heap to find the max value，但題目要保留 "exactly half the number"
    // e.g. 5 / 2 = 2.5 那 0.5也要保留
    public int halveArray(int[] nums) {
        // 大根堆
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> (b.compareTo(a))); // Double 要用compareTo 即 b - a;
        double sum = 0;
        // 把所有值都放到堆裡
        for (int n : nums) {
            heap.add((double) n);
            sum += n;
        }

        sum /= 2;
        double minus = 0; // 注意類型
        int ans = 0;

        while (minus < sum) {
            // poll 出來砍半
            double cur = heap.poll() / 2;
            minus += cur;
            // 再把它放回堆裡
            heap.add(cur);
            ans++;
        }
        return ans;
    }



    /////////////////////////////////
    // 以上方法對浮點留著進行計算會慢，精度太小也可能會出錯
    // 可以 nums * 2^20  變成 long 類型 to avoid floating point （它變大減半的operation step都是一樣的）
    // 為甚麼是 2^20？  long 是64位，首先 2^20就不會超過，所以＊2^20任何一個數都不會溢出
    // 其次，相當於給它一個緩衝區 e.g. ((((x/2)/2)/2)/2) 之後能有更多位置...


    int MAXN = 100001;
    long[] heap = new long[MAXN];
    int size; // heap size

    public int halveArray1(int[] nums) {
        size = nums.length;
        long sum = 0;
        // 從底 至 頂 建大根堆, 從 n - 1開始
        // O(n)
        for (int i = nums.length - 1; i >= 0; i--) {
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        long target = sum / 2;
        int step = 0;
        for (long reducedSum = 0; reducedSum < target; step++) {
            heap[0] /= 2;
            reducedSum += heap[0];
            heapify(0);
        }

        return step;
    }

    public void heapify(int i) {
        int l = i * 2 + 1;
        while (l < size) {
            int child = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
            child = heap[child] > heap[i] ? child : i;
            if (child == i) break;

            swap(child, i);
            i = child;
            l = i * 2 + 1;
        }
    }

    public void swap(int i, int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
