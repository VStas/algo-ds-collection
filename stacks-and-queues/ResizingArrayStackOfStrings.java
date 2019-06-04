public class ResizingArrayStackOfStrings {
    private int N = 0;
    private String[] arr;

    public ResizingArrayStackOfStrings() {
        arr = new String[1];
    }

    public void push(String item) {
        if (N == arr.length) {
            resize(2 * arr.length);
        }
        arr[N] = item;
        N += 1;
    }

    public String pop() {
        N -= 1;
        String item = arr[N];
        arr[N] = null;
        if (N > 0 && N == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    private void resize(int length) {
        System.out.println("Resizing to " + length);
        String[] newArr = new String[length];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        stack.push("hello");
        stack.push("boop");
        stack.push("bye");
        assert(stack.pop() == "bye");
        assert(!stack.isEmpty());
        assert(stack.pop() == "boop");
        assert(stack.pop() == "hello");
        assert(stack.isEmpty());
    }
}
