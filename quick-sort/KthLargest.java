// Selection in two sorted arrays. Given two sorted arrays a and b, of sizes n1 and n2, respectively, design an algorithm to find the kth
// largest key. The order of growth of the worst case running time of your algorithm should be logn, where n = n1+n2 

// Did it like almost here  https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
// Also this helped so much (understood both methods https://stackoverflow.com/questions/26436151/selection-in-two-sorted-arrays )
public class KthLargest {

    // "to" - NOT including
    private static int kthLargest(int[] arr1, int from1, int to1, int[] arr2, int from2, int to2, int k) {
        // System.out.print(from1 + " " + to1 + " " + from2 + " " + to2 + " k=" + k + "\n");
        if (from1 == to1) {
            return arr2[from2 + k];
        }
        if (from2 == to2) {
            return arr1[from1 + k];
        }
        int mid1 = (from1 + to1) / 2;
        int mid2 = (from2 + to2) / 2;

        if (mid1 - from1 + mid2 - from2 < k) {
            if (arr1[mid1] > arr2[mid2]) {
                return kthLargest(arr1, from1, to1, arr2, mid2+1, to2, k - (mid2 - from2) - 1);
            } else {
                return kthLargest(arr1, mid1+1, to1, arr2, from2, to2, k - (mid1 - from1) - 1);
            }
        } else {
            if (arr1[mid1] > arr2[mid2]) {
                return kthLargest(arr1, from1, mid1, arr2, from2, to2, k);
            } else {
                return kthLargest(arr1, from1, to1, arr2, from2, mid2, k);
            }
        }
    }

    private static int findKthLargest(int[] arr1, int[] arr2, int k) {
        return kthLargest(arr1, 0, arr1.length, arr2, 0, arr2.length, k);
    }
    public static void main(String[] args) {
        // int arr1[] = new int[] { 2, 3, 6, 7, 9 };
        // int arr2[] = new int[] { 1, 4, 8, 10 };
        // // 1 2 3 4 6 7 8 9 10
        // System.out.println(findKthLargest(arr1, arr2, 0));
        // System.out.println(findKthLargest(arr1, arr2, 1));
        // System.out.println(findKthLargest(arr1, arr2, 2));
        // System.out.println(findKthLargest(arr1, arr2, 3));
        // System.out.println(findKthLargest(arr1, arr2, 4));
        // System.out.println(findKthLargest(arr1, arr2, 5));
        // System.out.println(findKthLargest(arr1, arr2, 6));
        // System.out.println(findKthLargest(arr1, arr2, 7));
        // System.out.println(findKthLargest(arr1, arr2, 8));

        int arr1[] = new int[] { 1, 3, 5 };
        int arr2[] = new int[] { 4, 6, 100, 101 };

        System.out.println(findKthLargest(arr1, arr2, 0));
        System.out.println(findKthLargest(arr1, arr2, 1));
        System.out.println(findKthLargest(arr1, arr2, 2));
        System.out.println(findKthLargest(arr1, arr2, 3));
        System.out.println(findKthLargest(arr1, arr2, 4));
        System.out.println(findKthLargest(arr1, arr2, 5));
        System.out.println(findKthLargest(arr1, arr2, 6));
    }
}