public class BinarySearchTree {
    public class Node {
        // Instance variables of Node class
        public int data;
        public Node left;
        public Node right;

        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Instance variable for the root
    public Node root;

    // Constructor to initialize the root to null by default
    public BinarySearchTree() {
        this.root = null;
    }

    // Insert method to insert new data
    public void insert(int newData) {
        this.root = insert(root, newData);
    }

    private Node insert(Node root, int newData) {
        // Base Case: If root is null, insert the new data
        if (root == null) {
            return new Node(newData);
        }

        // Recursive case: Decide the position of the new node
        if (newData < root.data) {
            root.left = insert(root.left, newData);
        } else if (newData > root.data) {
            root.right = insert(root.right, newData);
        }

        return root;
    }

    // Display the 1-D array representation
    public void displayArrayRepresentation() {
        int[] array = new int[getSize(root)];
        int index = 0;
        fillArray(root, array, index);
        System.out.println("1-D Array Representation:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
    }

    private void fillArray(Node node, int[] array, int index) {
        if (node == null) {
            return;
        }
        fillArray(node.left, array, index);
        array[index++] = node.data;
        fillArray(node.right, array, index);
    }

    // Display the three tree traversals: Preorder, Inorder, Postorder
    public void displayTraversals() {
        System.out.println("Preorder Traversal:");
        preorderTraversal(root);

        System.out.println("\nInorder Traversal:");
        inorderTraversal(root);

        System.out.println("\nPostorder Traversal:");
        postorderTraversal(root);
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Accept integer input from the user and insert into the BST
        // Display the 1-D array representation (implement this method)
        // Display the three tree traversals
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        bst.displayTraversals();
    }
}
