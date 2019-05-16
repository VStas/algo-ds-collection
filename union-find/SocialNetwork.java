/* Social network connectivity. 

Given a social network containing n members and a log file containing m timestamps at which times pairs of members
formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).
Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
The running time of your algorithm should be mlogn or better and use extra space proportional to n.
*/

class QuickUnion {
    private int id[];
    private int sz[]; // number of objects

    QuickUnion(int N) {
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

public class SocialNetwork {
    private QuickUnion qu;
    private int disjointComponents;

    SocialNetwork(int N) {
        qu = new QuickUnion(N);
        disjointComponents = N;
    }

    // return true if end
    public boolean makeFriends(int p, int q) {
        if (qu.connected(p, q)) {
            return disjointComponents == 1;
        }
        qu.union(p, q);
        disjointComponents -= 1;
        return disjointComponents == 1;
    }

    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork(4);
        System.out.println(sn.makeFriends(0, 1));
        System.out.println(sn.makeFriends(2, 3));
        System.out.println(sn.makeFriends(3, 2));
        System.out.println(sn.makeFriends(0, 3)); // true
        System.out.println(sn.makeFriends(1, 3)); // true
    }
}