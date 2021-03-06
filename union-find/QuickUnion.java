interface UnionFindInterface {
    void union(int p, int q);
    boolean connected(int p, int q);
}

class QuickUnionUF implements UnionFindInterface {

    private int id[];

    QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        id[rootP] = rootQ;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

public class QuickUnion {
    public static void main(String[] args) {
        UnionFindInterface qu = new QuickUnionUF(5);

        qu.union(0, 1);
        qu.union(3, 4);
        qu.union(0, 3);
        assert(qu.connected(0, 1) == true);
        assert(qu.connected(1, 2) == false);
        assert(qu.connected(1, 4) == true);
    }
}