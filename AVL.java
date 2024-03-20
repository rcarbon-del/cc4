import java.util.*;

public class AVL {
    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    Node root;

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return (new Node(key));
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }
        if (root == null)
            return root;
        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }
    public int[] toArray() {
        int height = heightRepresentation(root);
        int size = (int) Math.pow(2, height) - 1;
        int[] array = new int[size];
        toArrayUtil(root, array, 0);
        return array;
    }

    private void toArrayUtil(Node root, int[] array, int index) {
        if (root != null && index < array.length) {
            toArrayUtil(root.left, array, 2 * index + 1);
            toArrayUtil(root.right, array, 2 * index + 2);
            array[index] = root.key;
        }
    }

    private int heightRepresentation(Node root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public void displayIndex() {
        int[] array = toArray();
        System.out.print("\nCurrent Index and Values: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        AVL avl = new AVL();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3){
            System.out.print("1. Insert\n2. Delete\n3. End\nEnter your choice: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter the value to insert: ");
                int item = scanner.nextInt();
                scanner.nextLine(); 
                avl.root = avl.insert(avl.root, item);
                choice = 0;
            }
            else if (choice == 2) {
                System.out.print("Enter the value to delete: ");
                int item2 = scanner.nextInt();
                scanner.nextLine();
                avl.root = avl.deleteNode(avl.root, item2);
                choice = 0;
            }
            else if (choice == 3) {
                break;
            }
            else {
                System.out.println("Invalid choice.");
                choice = 0;
            }
        }
        avl.displayIndex();
        System.out.println("\nPreorder traversal: ");
        avl.preOrder(avl.root);
        System.out.println("\n\nPostorder traversal: ");
        avl.postOrder(avl.root);
        System.out.println("\n\nInorder traversal: ");
        avl.inOrder(avl.root);
        System.out.println();
        System.out.print("Do you want to try again? (y/n): ");
        scanner.nextLine();
        String tryAgain = scanner.nextLine();
        if (tryAgain.equals("y")) {
            main(args);
        } else if (tryAgain.equals("n")){
            System.out.println("Thank you for using the program.");
        } else {
            System.out.println("Invalid input.");
        }
        scanner.close();
    }
}