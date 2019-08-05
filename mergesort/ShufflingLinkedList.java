// Shuffling a linked list.
// Given a singly-linked list containing n items, rearrange the items uniformly at random.
// Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to nlogn in the worst case.

// Сделал, смотря на algs4 репу, но из-за того, что указатели на начало списка перетирались, не работало.
// Но так возможно есть memory leak с LinkedList rightList = new LinkedList();
// Но вроде нет, rightList удалится, а на него больше никто не ссылается...

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


class Node {
    Node next;
    Object data;
}

class LinkedList {
    Node first;
}

public class ShufflingLinkedList {

    private static LinkedList createList(List<Object> data) {
        LinkedList list = new LinkedList();
        list.first = null;
        Node head = null;

        for (Object o : data) {
            Node node = new Node();
            node.data = o;
            if (list.first == null) {
                list.first = node;
                head = node;
            } else {
                head.next = node;
                head = node;
            }
        }
        return list;
    }
    private static void printList(LinkedList list) {
        Node runner = list.first;
        while (runner != null) {
            System.out.print(runner.data + " ");
            runner = runner.next;
        }
        System.out.println();
    }

    private static void merge(LinkedList leftList, LinkedList rightList) {
        Node left = leftList.first;
        Node right = rightList.first;

        // ??? seems like ok
        Node result;
        if (Math.random() < 0.5) {
            result = leftList.first;
            left = left.next;
        } else {
            result = rightList.first;
            right = right.next;
        }
        leftList.first = result;

        while (left != null || right != null) {
            if (left == null) {
                result.next = right;
                right = right.next;
            } else if (right == null) {
                result.next = left;
                left = left.next;
            } else if (Math.random() < 0.5) {
                result.next = right;
                right = right.next;               
            } else {
                result.next = left;
                left = left.next;                
            }
            result = result.next;
        }

    }

    private static void shuffle(LinkedList list, int N) {
        if (N == 1) {
            return;
        }
        Node head = list.first;
        Node mid = head; // mid is the end of the left part => size = 1 initially
        int leftPartSize = 1;
        while (leftPartSize < N / 2) {
            mid = mid.next;
            leftPartSize += 1;
        }
        Node right = mid.next;
        mid.next = null;
        shuffle(list, N/2); // N/2 === leftPartSize because we incremented it until N/2
        LinkedList rightList = new LinkedList();
        rightList.first = right;
        shuffle(rightList, N - N/2);
        merge(list, rightList);
    }
    public static void main(String[] args) {
        Number[] arr = new Number[]{ 1, 2, 3, 4, 5, 6, 7 };
        LinkedList list = createList(new ArrayList<Object>(Arrays.asList(arr)));
        printList(list);
        shuffle(list, 7);
        printList(list);
    }
}