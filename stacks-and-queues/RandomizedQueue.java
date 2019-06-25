import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

// todo exceptions and other stuff and testing

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n = 0;
    private Item[] arr;

    public RandomizedQueue() {
        arr = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (n == arr.length) {
            resize(arr.length * 2);
        }
        arr[n] = item;
        n += 1;
    }

    public Item dequeue() {
        int randomIndex = (int) (Math.random() * n); // [0, n) 
        Item randomItem = arr[randomIndex];
        arr[randomIndex] = arr[n - 1];
        arr[n - 1] = null;
        n -= 1;
        if (n > 0 && n == arr.length / 4) {
            resize(arr.length / 2);
        }
        return randomItem;
    }

    public Item sample() {
        int randomIndex = (int) (Math.random() * n); // [0, n) 
        return arr[randomIndex];
    }

    private void resize(int length) {
        Item[] newArr = (Item[]) new Object[length];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {

        private Item[] queue = (Item[]) new Object[n];
        private int currentIndex = 0;

        public RandomizedIterator() {
            for (int i = 0; i < n; i++) {
                queue[i] = arr[i];
            }
            List<Item> list = Arrays.asList(queue);
            Collections.shuffle(list);
            queue = (Item[]) list.toArray();
        }

        public boolean hasNext() {
            return currentIndex != queue.length;
        }

        public Item next() {
            Item item = queue[currentIndex];
            currentIndex += 1;
            return item;
        }
    }

    public static void main(String[] args) {
        System.out.println("HEllo");
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("now dequeue");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("again");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        for (String s : queue) {
            System.out.println(s);
        }
    }

}