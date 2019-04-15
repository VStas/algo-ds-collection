// Search value in sorted array
// Returns index or -1

class BinarySearchRecursive {

    public static int binarySearchRecursive(int[] arr, int value, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] < value) {
            return binarySearchRecursive(arr, value, mid + 1, high);
        }
        if (arr[mid] > value) {
            return binarySearchRecursive(arr, value, low, mid - 1);
        }
        return mid;
    }
    public static void main(String[] args) {
        int []arr = {1, 7, 9, 16, 100, 1000, 2000, 2021};
        assert (binarySearchRecursive(arr, 2021,    0, arr.length - 1) == 7);
        assert (binarySearchRecursive(arr, 1,       0, arr.length - 1) == 0);
        assert (binarySearchRecursive(arr, 9,       0, arr.length - 1) == 2);
        assert (binarySearchRecursive(arr, 5,       0, arr.length - 1) == -1);
    }
}
