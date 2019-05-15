// Two improvements:
// 1. Weighted
// 2. With path compression

interface UnionFindInterface {
    void union(int p, int q);
    boolean connected(int p, int q);
}

class QuickUnionImprovedUF implements UnionFindInterface {
    private int id[];
    private int sz[]; // number of objects

    QuickUnionImprovedUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ]; 
        }
        
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

public class QuickUnionImproved {
    public static void main(String[] args) {
        UnionFindInterface qu = new QuickUnionImprovedUF(5);

        qu.union(0, 1);
        qu.union(3, 4);
        qu.union(0, 3);
        assert(qu.connected(0, 1) == true);
        assert(qu.connected(1, 2) == false);
        assert(qu.connected(1, 4) == true);
    }
}