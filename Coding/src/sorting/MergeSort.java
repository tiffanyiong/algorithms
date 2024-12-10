package sorting;

import java.io.*;
import java.io.StreamTokenizer;

public class MergeSort {
    public static int MAXN = 10001;

    public static int[] arr = new int[MAXN];

    public static int[] helper = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;

        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }

         mergeSort1(0, n - 1);
       // mergeSort2();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();


    }



    public static void mergeSort1(int l, int r) {
        if (l == r) return;
        int m = (l + r) / 2;
        mergeSort1(l, m);
        mergeSort1(m + 1, r);
        merge(l, m, r); // O(n)
    }

    // l ... r 共有n 個數
    // O（n)
    public static void merge(int l, int m, int r) {
        //         a  m   b           r
        // [ 2, 3, 3, 8 | 3,    4, 5, 6]
        // [ l ...    m | m + 1 ... r ]

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
    }

    // non recursion
    // time complexity : O(n * log n)
    // space complexity: O(n)
    public static void mergeSort2() {
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;   // [l.....(m = step - 1)] [ m + 1 ..... r]

                if (m + 1 >= n) {   // m + 1 > n - 1 即右邊沒有東西了不用merge
                    break;
                }

                // [l...m]  [m+1...r]
                //   x         x       l + 2x 也就是 step << 1 .  看到底是邊界能有2倍的步長？
                // 還是邊界能到 n - 1. (因為最長就只能 n
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                // 從下一個步長開始。。
                // l...r
                //       (l/ r+1 ) ........r
                //                           l.....r
                l = r + 1;
            }
        }
    }

}
