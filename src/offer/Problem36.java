package offer;

public class Problem36 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = root;
        Node tail = root;
        while (head.left != null)
            head = head.left;
        while (tail.right != null)
            tail = tail.right;
        root.left = p36(root.left,true);
        if (root.left != null)
            root.left.right = root;
        root.right = p36(root.right,false);
        if (root.right != null)
            root.right.left = root;
        head.left = tail;
        tail.right = head;
        return head;
    }

    private Node p36(Node root, boolean left){
        if (root == null) return null;
        root.left = p36(root.left,true);
        if (root.left != null)
            root.left.right = root;
        root.right = p36(root.right,false);
        if (root.right != null)
            root.right.left = root;
        if (left){
            Node p = root;
            while (p.right != null)
                p = p.right;
            return p;
        }
        else {
            Node p = root;
            while (p.left != null)
                p = p.left;
            return p;
        }

    }

}
