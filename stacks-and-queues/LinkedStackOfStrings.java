public class LinkedStackOfStrings {

    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
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