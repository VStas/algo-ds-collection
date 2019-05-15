interface UnionFindInterface {
    void union(int p, int q);
    boolean connected(int p, int q);
}

class QuickFindUF implements UnionFindInterface {

    private int id[];

    QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idp) {
                id[i] = idq;
            }
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}

public class QuickFind {
    public static void main(String[] args) {
        UnionFindInterface qu = new QuickFindUF(5);

        qu.union(0, 1);
        qu.union(3, 4);
        qu.union(0, 3);
        assert(qu.connected(0, 1) == true);
        assert(qu.connected(1, 2) == false);
        assert(qu.connected(1, 4) == true);
    }
}

