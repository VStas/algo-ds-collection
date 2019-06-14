import java.util.Arrays;


public class ResizingArrayQueue<Item> {
    private int N = 0; // num of elements in queue
    private int start = 0;
    private int end = 0;
    private Item[] arr;

    public ResizingArrayQueue() {
        arr = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        if (N == arr.length) {
            resize(2 * arr.length);
        }
        N += 1;
        arr[end] = item;
        end = (end + 1) % arr.length;
        // System.out.println(Arrays.toString(arr));
    }

    public Item dequeue() {
        N -= 1;
        Item item = arr[start];
        arr[start] = null;
        start = (start + 1) % arr.length;
        if (N > 0 && N == arr.length / 4) {
            resize(arr.length / 2);
        }
        // System.out.println(Arrays.toString(arr));
        return item;
    }

    private void resize(int length) {
        Item[] newArr = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[(start + i) % arr.length];
        }
        arr = newArr;
        start = 0;
        end = N;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        queue.enqueue("hello");
        queue.enqueue("boop");
        queue.enqueue("bye");
        assert(queue.dequeue() == "hello");
        assert(!queue.isEmpty());
        assert(queue.dequeue() == "boop");
        assert(queue.dequeue() == "bye");
        assert(queue.isEmpty());  
    }

    public static void test2() {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");
        assert(queue.dequeue() == "1");
        assert(queue.dequeue() == "2");
        queue.enqueue("11");
        queue.enqueue("12");
        assert(queue.dequeue() == "3");
        assert(queue.dequeue() == "4");
        queue.enqueue("13");
        queue.enqueue("14"); 
        assert(queue.dequeue() == "5");
        assert(queue.dequeue() == "6");
        assert(queue.dequeue() == "7");
        queue.enqueue("15");
        queue.enqueue("16");
        queue.enqueue("17");
        queue.enqueue("18");
        queue.enqueue("19");
        queue.enqueue("20");
        queue.enqueue("21");
        assert(queue.dequeue() == "8");
        assert(queue.dequeue() == "9");
        assert(queue.dequeue() == "10");
        assert(queue.dequeue() == "11");
        assert(queue.dequeue() == "12");
        assert(queue.dequeue() == "13");
        assert(queue.dequeue() == "14");
        assert(queue.dequeue() == "15");
        assert(queue.dequeue() == "16");
        assert(queue.dequeue() == "17");
        assert(queue.dequeue() == "18");
        assert(queue.dequeue() == "19");
        assert(queue.dequeue() == "20");
        assert(queue.dequeue() == "21");
        assert(queue.isEmpty());
    }
}