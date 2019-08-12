public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MinPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1]; // we start from index 1, not 0
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    public Key delMin() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    public Key findMin() {
        return pq[1];
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<Integer>(5);
        pq.insert(2);
        pq.insert(100);
        pq.insert(3);
        pq.insert(200);
        pq.insert(1);
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
    }
}