// Write a program that, given a bitonic array of n distinct integer values, determines whether a given integer is in the array

// We could rewrite binary search in 1 comparison, then it would be ~2logn array comparison solution!
class BitonicSearch {

    // binary search in ascending or descending array
    // we can actually do it with 1 comparison per iteration
    // https://stackoverflow.com/questions/3500167/is-it-possible-to-have-only-one-comparison-per-iteration-of-a-binary-search-algo
    public static int binarySearch(int[] arr, int value, int low, int high, boolean asc) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2; // instead of (high + low) / 2 to avoid overflow
        if (asc) {
            
            if (arr[mid] > value) {
                return binarySearch(arr, value, low, mid - 1, true);
            } else if (arr[mid] < value) {
                return binarySearch(arr, value, mid + 1, high, true);
            } else {
                return mid;
            }
        } else {
            if (arr[mid] > value) {
                return binarySearch(arr, value, mid + 1, high, false);
            } else if (arr[mid] < value) {
                return binarySearch(arr, value, low, mid - 1, false);
            } else {
                return mid;
            }
        }
    }

    public static int bitonicSearch(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        boolean isIncreasing = mid == 0 || arr[mid] > arr[mid-1];
        if (arr[mid] < value) {
            if (isIncreasing) {
                return bitonicSearch(arr, value, mid + 1, high);
            } else {
                return bitonicSearch(arr, value, low, mid - 1);
            }
        } else {
            int leftResult, rightResult;
            if (isIncreasing) {
                leftResult = binarySearch(arr, value, low, mid, true);
                rightResult = binarySearch(arr, value, mid + 1, high, false);
            } else {
                leftResult = binarySearch(arr, value, low, mid - 1, true);
                rightResult = binarySearch(arr, value, mid, high, false);
            }
            if (leftResult != -1) {
                return leftResult;
            } else {
                return rightResult;
            }
        }

    }

    public static void main(String[] args) {
        // an example of bitonic sequence
        int[] numbers = {1, 7, 8, 19, 20, 25, 30, 29, 28, 21, 6, 5, 0, -3};
        int low = 0;
        int high = numbers.length - 1;
        assert (binarySearch(numbers, 7, 0, 5, true) == 1);
        assert (binarySearch(numbers, 6, 9, 13, false) == 10);
        for (int i = low; i <= high; i++) {
            assert (bitonicSearch(numbers, numbers[i], low, high) == i);
        }

        numbers = new int[]{1, 2, 3, 4, 5};
        low = 0;
        high = numbers.length - 1;
        for (int i = low; i <= high; i++) {
            assert (bitonicSearch(numbers, numbers[i], low, high) == i);
        }
    }    
}