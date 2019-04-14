// Search value in sorted array
// Returns index or -1

class BinarySearch {

    public static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2; // instead of (high + low) / 2 to avoid overflow
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        int []arr = {1, 7, 9, 16, 100, 1000, 2000, 2021}; 
        System.out.println(binarySearch(arr, 2001));
    }
}
