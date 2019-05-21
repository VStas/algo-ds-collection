// Union-find with specific canonical element.
// Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i.
// The operations, union(), connected(), and find() should all take logarithmic time or better.

// For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.

class QuickUnionImprovedUF {
    private int id[];
    private int sz[]; // number of objects
    private int max[]; // max element value (if that is root element)

    QuickUnionImprovedUF(int N) {
        id = new int[N];
        sz = new int[N];
        max = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
        }
    }

    public int find(int p) {
        return max[root(p)];
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
        int maxP = max[rootP];
        int maxQ = max[rootQ];
        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];

            if (maxP > maxQ) {
                max[rootQ] = maxP;
            }

        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];

            if (maxQ > maxP) {
                max[rootP] = maxQ;
            }
        }    
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

public class UnionFindMaxElement {
    public static void main(String[] args) {
        QuickUnionImprovedUF uf = new QuickUnionImprovedUF(10);
        uf.union(1, 2);
        uf.union(2, 6);
        uf.union(2, 9);
        assert(uf.find(1) == 9);
        assert(uf.find(2) == 9);
        assert(uf.find(6) == 9);
        assert(uf.find(9) == 9);
        assert(uf.find(5) == 5);
    }
}