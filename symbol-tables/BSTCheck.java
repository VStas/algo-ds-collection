/*
Check if a binary tree is a BST. Given a binary tree where each Node contains a key, determine whether it is a binary search tree.
Use extra space proportional to the height of the tree.
*/

class Node<Key extends Comparable<Key>, Value> {
    Key key;
    private Value value;
    Node left, right;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}

public class BSTCheck<Key extends Comparable<Key>, Value> {

    public boolean isBST(Node<Key,Value> node) {
        return isBST(node, null, null);
    }
    private boolean isBST(Node<Key,Value> node, Key min, Key max) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0 || max != null && node.key.compareTo(max) >= 0) {
            return false;
        }
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }

    public static void main(String[] args) {
        BSTCheck<Integer, Integer> bstCheck = new BSTCheck<Integer, Integer>();

        Node<Integer, Integer> tree1 = new Node<Integer, Integer>(5, 5);
        tree1.right = new Node<Integer, Integer>(6, 6);
        tree1.right.right = new Node<Integer, Integer>(7, 7);

        Node<Integer, Integer> tree2 = new Node<Integer, Integer>(5, 5);
        tree2.right = new Node<Integer, Integer>(6, 6);
        tree2.right.right = new Node<Integer, Integer>(7, 7);
        tree2.right.right.left = new Node<Integer, Integer>(6, 6);

        assert bstCheck.isBST(tree1);
        assert !bstCheck.isBST(tree2);
    }
}