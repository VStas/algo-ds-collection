public class LinkedQueue<Item> {

    private Node first, last;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node prevLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            prevLast.next = last;
        }
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.enqueue("hello");
        queue.enqueue("boop");
        queue.enqueue("bye");
        assert(queue.dequeue() == "hello");
        assert(!queue.isEmpty());
        assert(queue.dequeue() == "boop");
        assert(queue.dequeue() == "bye");
        assert(queue.isEmpty());
    }
}