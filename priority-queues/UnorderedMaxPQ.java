public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(pq[max], pq[i])) max = i;
        }
        exch(max, N-1);
        return pq[--N];
    }

    private boolean less(Key a, Key b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        UnorderedMaxPQ<Integer> pq = new UnorderedMaxPQ<>(5);
        pq.insert(1);
        pq.insert(3);
        pq.insert(2);
        System.out.print(pq.delMax());
        System.out.print(pq.delMax());
        System.out.print(pq.delMax());
    }
}