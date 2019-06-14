import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item> {

    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
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