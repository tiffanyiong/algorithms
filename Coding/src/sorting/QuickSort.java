package sorting;

import static utils.utils.swap;

public class QuickSort {
    static int MAXN = 50001;
    static int[] arr = new int[MAXN];


    // 隨紅快排經典版本 - 沒有分出三個區域的版本： <x  x  >x
    public static void quickSort1(int l, int r) {
        // l == r 只有一個數
        // l > r, 範圍不存在 不用管
        if (l >= r) {
            return;
        }

        // 隨機 - 常數時間比較大
        // 但只有這下隨機才能在概率上把快排的時間複雜度收到 O(n * log n)
        // l......r 隨機選一個位置，x這個值做劃分
        int x = arr[(int) (l + Math.random() * (r - l + 1))];
        int mid = partition1(l, r, x);
        quickSort1(l, mid - 1);
        quickSort1(mid + 1, r);
    }

    // 已知arr[l....r]范围上一定有x这个值
    // 划分数组 <=x放左边，>x放右边
    // 并且确保划分完成后<=x区域的最后一个数字是x
    public static int partition1(int l, int r, int x) {
        // a : arr[l....a-1]范围是<=x的区域
        // xi : 记录在<=x的区域上任何一个x的位置，哪一个都可以
        int a = l, xi = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                swap(a, i);
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        swap(xi, a - 1);
        return a - 1;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }




    public static void quickSort2(int l, int r) {
        if (l >= r) {
            return;
        }

        int x = arr[l + (int) Math.random() * (r - l + 1)];
        partition2(l, r, x);

        //為了防止底層的递歸過程覆蓋全局變量，要用臨時變量記錄first last
        int left = first;
        int right = last;
        quickSort2(l, left - 1);
        quickSort2(right + 1, r);

    }

    public static int first, last;

    // 已知arr[l.....r]裡上一定有x這個值
    // 劃分數組 <x 放左邊， ＝＝x放中間，>x 放右邊
    // 把全局變量first, last 更新成 ==x 區域的左右邊界
    public static void partition2(int l, int r, int x) {
        // [ <x       |    ==x    |    >x   ]
        //          a   i             b
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(first++, i++);
            } else {
                swap(i, last--);
            }
        }
    }
}
