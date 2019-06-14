import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private int N = 0;
    private Item[] arr;

    public ResizingArrayStack() {
        arr = (Item[]) new Object[1];
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            i -= 1;
            return arr[i];
        }
    }

    public void push(Item item) {
        if (N == arr.length) {
            resize(2 * arr.length);
        }
        arr[N] = item;
        N += 1;
    }

    public Item pop() {
        N -= 1;
        Item item = arr[N];
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
        Item[] newArr = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        stack.push("hello");
        stack.push("boop");
        stack.push("bye");

        for (String str : stack) {
            System.out.println(str);
        }

        assert(stack.pop() == "bye");
        assert(!stack.isEmpty());
        assert(stack.pop() == "boop");
        assert(stack.pop() == "hello");
        assert(stack.isEmpty());
    }
}
