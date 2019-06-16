import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    private Node sentinel;
    private int N = 0;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public Deque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }


    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

   public void addFirst(Item item) {
       if (item == null) {
           throw new IllegalArgumentException();
       }
       N += 1;
       Node oldFirst = sentinel.next;
       Node newNode = new Node();
       newNode.item = item;
       newNode.next = oldFirst;
       newNode.prev = sentinel;
       sentinel.next = newNode;
       oldFirst.prev = newNode;
   }
   public void addLast(Item item) {
       if (item == null) {
           throw new IllegalArgumentException();
       }
       N += 1;
       Node oldLast = sentinel.prev;
       Node newNode = new Node();
       newNode.item = item;
       newNode.next = sentinel;
       newNode.prev = oldLast;
       sentinel.prev = newNode;
       oldLast.next = newNode;
   }
   public Item removeFirst() {
       if (isEmpty()) {
           throw new NoSuchElementException();
       }
       N -= 1;
       Node oldFirst = sentinel.next;
       Item item = oldFirst.item;
       sentinel.next = oldFirst.next;
       sentinel.next.prev = sentinel;
       oldFirst = null;
       return item;
   }
   public Item removeLast() {
       if (isEmpty()) {
           throw new NoSuchElementException();
       }
       N -= 1;
       Node oldLast = sentinel.prev;
       Item item = oldLast.item;
       sentinel.prev = oldLast.prev;
       sentinel.prev.next = sentinel;
       oldLast = null;
       return item;         
   }

   private class DequeIterator implements Iterator<Item> {
       private Node current = sentinel.next;

       public boolean hasNext() {
           return current != sentinel;
       }

       public Item next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           Item item = current.item;
           current = current.next;
           return item;
       }

       public void remove() {
           throw new UnsupportedOperationException();
       }
   }
   // return an iterator over items in order from front to end
   public Iterator<Item> iterator() {
       return new DequeIterator();
   }
   public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        d.addFirst("1");
        d.addLast("2");
        d.addLast("3");
        d.addFirst("4");
        d.addFirst("5");
        for (String str : d) {
            System.out.print(str); System.out.print(" ");
        }
        System.out.println();
        assert(d.removeFirst() == "5");
        assert(d.removeFirst() == "4");
        assert(d.removeFirst() == "1");
        assert(d.removeFirst() == "2");
        assert(d.removeFirst() == "3");
        assert(d.isEmpty());

        d.addFirst("6");
        d.addLast("7");
        d.addFirst("8");
        for (String str : d) {
            System.out.print(str); System.out.print(" ");
        }

   }
}