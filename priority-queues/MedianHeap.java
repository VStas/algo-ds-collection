/*
    Dynamic median. Design a data type that supports insert in logarithmic time, find-the-median in constant time,
    and remove-the-median in logarithmic time. If the number of keys in the data type is even, find/remove the lower median.
*/

public class MedianHeap {

    private MaxPQ<Integer> left;
    private MinPQ<Integer> right;

    public MedianHeap(int heapCapacity) {
        left = new MaxPQ<Integer>(heapCapacity);
        right = new MinPQ<Integer>(heapCapacity);
    }

    public void insert(Integer key) {
        if (left.size() == 0 && right.size() == 0) {
            left.insert(key);
            return;
        }
        Integer median = findMedian();
        if (key <= median) {
            left.insert(key);
            if (left.size() - right.size() > 1) {
                right.insert(left.delMax());
            }
        } else {
            right.insert(key);
            if (right.size() - left.size() > 1) {
                left.insert(right.delMin());
            }
        }
    }

    public Integer findMedian() {
        if (right.size() > left.size()) {
            return right.findMin();
        }
        return left.findMax();
    }

    public Integer removeMedian() {
        if (right.size() > left.size()) {
            return right.delMin();
        }
        return left.delMax();
    }
    public static void main(String[] args) {
        MedianHeap mh = new MedianHeap(10);
        mh.insert(1);
        // System.out.println(mh.findMedian());
        mh.insert(2);
        // System.out.println(mh.findMedian());
        mh.insert(3);
        // System.out.println(mh.findMedian());
        mh.insert(4);
        // System.out.println(mh.findMedian());
        mh.insert(5);
        // System.out.println(mh.findMedian());

        assert mh.removeMedian() == 3;
        assert mh.removeMedian() == 2;
        assert mh.removeMedian() == 4;
        assert mh.removeMedian() == 1;
        assert mh.removeMedian() == 5;
    }
}