public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public Value get(Key key) {
        Node curr = root;
        while (curr != null) {
            if (key.compareTo(curr.key) > 0) curr = curr.right;
            else if (key.compareTo(curr.key) < 0) curr = curr.left;
            else return curr.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public static void main(String[] args) {
        BST<String, String> bst = new BST<String, String>();
        bst.put("key1", "value1");
        bst.put("key1", "value1new");
        bst.put("key2", "value2");
        bst.put("key3", "value3");
        assert bst.get("notexist") == null;
        assert bst.get("key1") == "value1new";
        assert bst.get("key2") == "value2";
        assert bst.get("key3") == "value3";
    }
}