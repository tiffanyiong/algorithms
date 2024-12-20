package sorting;

class HeapSort {
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            heapSort(nums);
        }
        return nums;
    }


    // 從頂到底建立大根堆 O(N * logN)
    // 依次彈出堆內最大值並排好序，O（n*logN)
     public void heapSort1(int[] arr) {
         int n = arr.length;
         for (int i = 0; i < n; i++) {
             heapInsert(arr, i);
         }
         int size = n;
         while (size > 1) {
             // 堆頂 和 size最後一位數交換，size 減掉一個數直到size為0
             swap(arr, 0, --size);
             // 調整堆
             heapify(arr, 0, size);
         }
     }


    // 從底到頂 建大根堆是 O(n)
    // 依次彈出堆內最大值並排好序是，O(n * logn)
    // 整體時間複雜度是O(n * logn)
    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) { // 從底 -> 頂部
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 1){
            swap(arr, 0, --size); // 一樣，把頂交換
            heapify(arr, 0, size);
        }
    }

    // i 位置的數，向上調整大根堆
    // arr[i] = x, x是新來的，往上看，直到不比父親大或者來到0位置
    public void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void heapify(int[] arr, int i, int size) {
        int l = i * 2 + 1; //(left child)
        // size是用來控制大小的，此時如果l在size範圍內，代表有左孩子
        while (l < size) {

            // 有左孩子，l
            // 右孩子，l + 1
            // 評選，最大的孩子，就要那個下標
            // 是有右孩子 且 比左孩子大嗎？是的話，就要右，則要左
            int child = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            // ok, 上面選完最大的，接下來要和當前的數比較，取它下標
            child = arr[child] > arr[i] ? child : i;
            // 如果不大於當前的數就break;
            if (child == i) break;
            // 否則就swap
            swap(arr, child, i);
            i = child;
            // 繼續往下個左孩子看
            l = i * 2 + 1;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
