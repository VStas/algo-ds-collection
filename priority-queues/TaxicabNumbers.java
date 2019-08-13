/*
    Taxicab numbers. A taxicab number is an integer that can be expressed as the sum of two cubes of positive integers in two different ways:
    a^3 + b^3 = c^3 + d^3
    For example, 1729 is the smallest taxicab number: 9^3 + 10^3 = 1^3 + 12^3
    Design an algorithm to find all taxicab numbers with a, b, c, and d less than n.
*/

// based on Sedgewick example https://algs4.cs.princeton.edu/24pq/Taxicab.java.html

class TaxicabNumber implements Comparable<TaxicabNumber>{
    public final int i;
    public final int j;
    public final long sum;

    public TaxicabNumber(int i, int j) {
        this.sum = (long)i*i*i + (long)j*j*j;
        this.i = i;
        this.j = j;
    }

    // Do we need to break ties by i like in example???
    // We may need it just to have more beatiful output. That starts with lower i.
    public int compareTo(TaxicabNumber that) {
        if (sum > that.sum) return 1;
        else if (sum < that.sum) return -1;
        return 0;
    }

    public String toString() {
        return i + "^3 + " + j + "^3";
    }
}

public class TaxicabNumbers {
    public static void main(String[] args) {
        int N = 100;
        MinPQ<TaxicabNumber> pq = new MinPQ<TaxicabNumber>(N);
        for (int i = 1; i <= N; i++) {
            pq.insert(new TaxicabNumber(i, i));
        }
        int runs = 1;
        TaxicabNumber prev = new TaxicabNumber(0, 0); // sentinel
        while (!pq.isEmpty()) {
            TaxicabNumber curr = pq.delMin();
            if (curr.sum == prev.sum) {
                runs += 1;
                if (runs == 2) {
                    System.out.print(curr.sum + " = " + prev);
                }
                System.out.print(" = " + curr);
            } else {
                if (runs > 1) {
                    System.out.println();
                }
                runs = 1;
            }
            prev = curr;
            if (curr.j + 1 <= N) {
                pq.insert(new TaxicabNumber(curr.i, curr.j + 1));
            }
        }
        if (runs > 1) {
            System.out.println();
        }
    }
}