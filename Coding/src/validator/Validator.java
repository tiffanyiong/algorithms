package validator;


public class Validator {

    /**
     * This random array is used for validate an algorithm
     * @param length array's length
     * @param scope random number scope e.g. from "1-scope"
     * @return random array
     */
    public static int[] randomArray(int length, int scope) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            // Math.random returns a double type, from [0, 1], e.g. 0.346234
            // (int) (Math.random() * scope -> 0, 1, 2, 3
            // (int) (Math.random() * scope + 1 -> 1, 2, 3, 4...
            arr[i] = (int) (Math.random() * scope + 1);  // +1 make sure no zero
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        // create a new array (don't modify from the original array)
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isSameArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 2);
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("------");
        int[] arr1 = copyArray(arr);
        for (int i : arr1) {
            System.out.print(i + " ");
        }

    }
}
