import java.util.*;
class Tree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static Scanner sc = new Scanner(System.in);
    Node buildTree() {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        root.left = buildTree();
        root.right = buildTree();

        return root;
    }
    void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    void levelOrder(Node root) {
    if (root == null) return;

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        Node curr = q.poll();
        System.out.print(curr.data + " ");

        if (curr.left != null) {
            q.add(curr.left);
        }

        if (curr.right != null) {
            q.add(curr.right);
        }
    }
    }
    void levelOrderLevelWise(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        int size = q.size();   
        for (int i  = 0; i < size; i++) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
    Tree t = new Tree();
    Node root = t.buildTree();
    t.inorder(root);
    System.out.println();
    t.preorder(root);
    System.out.println();
    t.postorder(root);
    }
}