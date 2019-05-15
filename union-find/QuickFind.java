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
        UnionFindInterface qf = new QuickFindUF(5);

        qf.union(0, 1);
        qf.union(3, 4);
        qf.union(0, 3);
        assert(qf.connected(0, 1) == true);
        assert(qf.connected(1, 2) == false);
        assert(qf.connected(1, 4) == true);
    }
}

