public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;

        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    private Node root;

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public int size() {
        return size(root);
    }

    public Value get(Key key) {
        Node curr = root;
        while (curr != null) {
            if (key.compareTo(curr.key) > 0) curr = curr.right;
            else if (key.compareTo(curr.key) < 0) curr = curr.left;
            else return curr.value;
        }
        return null;
    }

    // wrote this myself
    public Node min() {
        if (root == null) {
            return null;
        }
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }
    public Node min(Node root) {
        if (root == null) {
            return null;
        }
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    // Hibbard deletion
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        x.left = delete(x.left, key);
        else if (cmp > 0)   x.right = delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            // we have both children
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public static void main(String[] args) {
        BST<String, String> bst = new BST<String, String>();
        assert bst.size() == 0;
        bst.put("key1", "value1");
        bst.put("key1", "value1new");
        bst.put("key2", "value2");
        bst.put("key3", "value3");
        bst.put("key4", "value4");
        assert bst.get("notexist") == null;
        assert bst.get("key1") == "value1new";
        assert bst.get("key2") == "value2";
        assert bst.get("key3") == "value3";
        assert bst.size() == 4;
        assert bst.min().key == "key1";
        bst.deleteMin();
        assert bst.get("key1") == null;

        bst.delete("key3");
        bst.delete("key2");
        assert bst.get("key1") == null;
        assert bst.get("key2") == null;
        assert bst.get("key3") == null;
        assert bst.get("key4") == "value4";
    }
}