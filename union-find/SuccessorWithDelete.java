// Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following form:

// Remove x from S
// Find the successor of x: the smallest y in S such that y≥x.
// design a data type so that all operations (except construction) take logarithmic time or better in the worst case.


// TODO: maybe allow to call find with very big or very small numbers that dont belong S.

class UnionFindMaxElement {
    private int id[];
    private int sz[]; // number of objects
    private int max[]; // max element value (if that is root element)

    UnionFindMaxElement(int N) {
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

public class SuccessorWithDelete {

    private boolean maxElementDeleted;
    private UnionFindMaxElement uf;
    private int N;

    SuccessorWithDelete(int N) {
        this.N = N;
        maxElementDeleted = false;
        uf = new UnionFindMaxElement(N);
    }

    public void remove(int x) {
        if (x < N - 1) {
            uf.union(x, x + 1);
        } else if (x == N - 1) {
            maxElementDeleted = true;
        }
    }

    public int find(int x) {
        int maxUF = uf.find(x);
        if (maxUF == N - 1 && maxElementDeleted) {
            return -1;
        } else {
            return maxUF;
        }
    }

    public static void main(String[] args) {
         SuccessorWithDelete swd = new SuccessorWithDelete(10);
         assert(swd.find(3) == 3);
         swd.remove(2);
         assert(swd.find(2) == 3);
         swd.remove(3);
         assert(swd.find(2) == 4);
         assert(swd.find(3) == 4);
         assert(swd.find(8) == 8);
         swd.remove(8);
         assert(swd.find(8) == 9);
         swd.remove(9);
         assert(swd.find(8) == -1);
         assert(swd.find(9) == -1);
         swd.remove(5);
         swd.remove(4);
         assert(swd.find(3) == 6);
    }
}