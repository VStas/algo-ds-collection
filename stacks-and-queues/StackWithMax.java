class Stack {
    private int[] arr;
    private int N = 0;

    public Stack() {
        arr = new int[1];
    }

    public int peek() {
        return arr[N - 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(int item) {
        if (N == arr.length) {
            resize(2 * arr.length);
        }
        arr[N] = item;
        N += 1;
    }

    public int pop() {
        N -= 1;
        int item = arr[N];
        if (N > 0 && N == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    private void resize(int length) {
        int[] newArr = new int[length];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}

class StackWithMax {
    private Stack stack = new Stack();
    private Stack max = new Stack();

    public void push(int item) {
        stack.push(item);
        if (item >= max()) { // IMPORTANT we use >= because what if many numbers with same max value. Then no error when popping
            max.push(item);
        }
    }

    public int pop() {
        int item = stack.pop();
        if (item == max()) {
            max.pop();
        }
        return item;
    }

    public int max() {
        if (max.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return max.peek();
    }

    public static void main(String[] args) {
        StackWithMax s = new StackWithMax();
        s.push(1);
        s.push(3);
        s.push(2);
        s.push(3);
        assert(s.max() == 3);
        s.pop();
        assert(s.max() == 3);
        s.pop();
        assert(s.max() == 3);
        s.pop();
        assert(s.max() == 1);
        s.pop();
        assert(s.max() == Integer.MIN_VALUE);
    }
}