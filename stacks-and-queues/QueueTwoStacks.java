import java.util.Stack;

class Queue<T> {
    private Stack<T> inbox = new Stack<T>();
    private Stack<T> outbox = new Stack<T>();

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    public void enqueue(T item) {
        inbox.push(item);
    }

    public T dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }
}

public class QueueTwoStacks {
    public static void main(String[] args) {
        Queue<Number> q = new Queue<Number>();
        q.enqueue(1);
        q.enqueue(2);
        assert(q.dequeue().intValue() == 1);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        assert(q.dequeue().intValue() == 2);
        assert(q.dequeue().intValue() == 3);
        assert(!q.isEmpty());
        assert(q.dequeue().intValue() == 4);
        assert(q.dequeue().intValue() == 5);
        assert(q.isEmpty());
    }
}