// 3-SUM in quadratic time

// Integers in the array can repeat. But we shouldn't repeat ourself in results array.
// For example:
//
// input: [0, 0, 0, 0, 0]
// result: [[ 0 0 0 ]] (only one triplet)
// 
// input: [-1, 0, 1, 2, -1, 4]
// result: [[-1, -1, 2], [-1, 0, 1]]


import java.util.Arrays;
import java.util.ArrayList;

class ThreeSum {

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {
        int indexToInsert = 1;
        while (indexToInsert < arr.length) {
            int indexToCompare = indexToInsert;
            while (indexToCompare > 0 && arr[indexToCompare] < arr[indexToCompare - 1]) {
                swap(arr, indexToCompare, indexToCompare - 1);
                indexToCompare -= 1;
            }
            indexToInsert += 1;
        }
    }

    public static ArrayList<int[]> findThreeSums(int[] arr) {
        insertionSort(arr);
        ArrayList<int[]> result = new ArrayList<int[]>();

        for (int i = 0; i <= arr.length - 3; i++) {
            if (i == 0 || arr[i] > arr[i-1]) {
                int start = i + 1;
                int end = arr.length - 1;

                while (start < end) {
                    int sum = arr[i] + arr[start] + arr[end];
                    if (sum == 0) {
                        result.add(new int[] {arr[i], arr[start], arr[end]});
                    }

                    if (sum < 0) {
                        int initialStart = start;
                        while (start < end && arr[start] == arr[initialStart]) {
                            start += 1;
                        }
                    } else {
                        int initialEnd = end;
                        while (start < end && arr[end] == arr[initialEnd]) {
                            end -= 1;
                        }                        
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, 4};
        // int[] arr = {0, 0, 0, 0, 0};

        ArrayList<int[]> result = findThreeSums(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString((result.get(i))));
        }
    }
}
