package divide_conquer;

import java.io.*;

// https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
// 数组小
// input: 6
//1 3 5 2 4 6
// output : 27

public class SmallSum {
    public static int MAXN = 10001;

    public static int[] arr = new int[MAXN];

    public static int[] helper = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(smallSum(0, n - 1));
        }
        out.flush();
        out.close();
    }

    // 结果比较大，用int会溢出的，所以返回long类型
    // 特别注意溢出这个点，笔试常见坑
    // 返回arr[l...r]范围上，小和的累加和，同时请把arr[l..r]变有序
    // 时间复杂度O(n * logn)
    public static long smallSum(int l, int r) {
        if (l == r) return 0;
        int m = (l + r) / 2;
        //左側結果 ＋右側結果 ＋ 跨左右側結果
        return smallSum(l, m) + smallSum(m + 1, r) + mergeLeftRight(l, m, r);
    }

    // 返回跨左右产生的小和累加和，左侧有序、右侧有序，让左右两侧整体有序
    // arr[l...m] arr[m+1...r]
    public static long mergeLeftRight(int l, int m, int r) {
        long ans = 0;
        for (int k = l, sum = 0, j = m + 1; j <=r; j++) {
            while (k <= m && arr[k] < arr[j]) {
                sum += arr[k++];
            }
            ans += sum;
        }

        //         a  m   b           r
        // [ 2, 3, 3, 8 | 3,    4, 5, 6]
        // [ l ...    m | m + 1 ... r ]

        //normal merge
        int i = l;
        int a = l;
        int b = m + 1;

        while (a <= m && b <= r) {
            helper[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }

        // 左側指針，右側指針，必有一個越界，另一個不越界
        while (a <= m) {
            helper[i++] = arr[a++];
        }

        while (b <= r) {
            helper[i++] = arr[b++];
        }

        // 抄到原array
        for (int j = l; j <= r; j++) {
            arr[j] = helper[j];
        }
        return ans;
    }


}
