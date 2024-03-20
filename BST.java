import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BSTP {
    Node root;

    BSTP() {
        root = null;
    }

    void insert(int key) {
        if (key == 0) {
            System.out.println("0 cannot be inserted into the tree.");
            return;
        }
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void deleteKey(int key, boolean deleteFromLeft) {
        if (key == 0) {
            System.out.println("0 cannot be deleted from the tree.");
            return;
        }
        root = deleteRec(root, key, deleteFromLeft);
    }

    Node deleteRec(Node root, int key, boolean deleteFromLeft) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key, deleteFromLeft);
        else if (key > root.key)
            root.right = deleteRec(root.right, key, deleteFromLeft);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            if (deleteFromLeft) {
                root.key = maxValue(root.left);
                root.left = deleteRec(root.left, root.key, deleteFromLeft);
            } else {
                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key, deleteFromLeft);
            }
        }
        return root;
    }

    int maxValue(Node root) {
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    public int[] toArray() {
        int height = height(root);
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

    private int height(Node root) {
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
}

public class BST {
    public static void main(String[] args) {
        BSTP bst = new BSTP();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3){
            System.out.print("1. Insert\n2. Delete\n3. End\nEnter your choice: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter the value to insert: ");
                int item = scanner.nextInt();
                scanner.nextLine(); 
                bst.insert(item);
                choice = 0;
            }
            else if (choice == 2) {
                System.out.print("Enter the value to delete: ");
                int item2 = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Delete from:\n1. Left\n2. Right\nEnter your choice: ");
                int deleteFrom = scanner.nextInt();
                scanner.nextLine();
                bst.deleteKey(item2, deleteFrom == 1);
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
        bst.displayIndex();
        System.out.println("\nPreorder traversal: ");
        bst.preorder();
        System.out.println("\n\nPostorder traversal: ");
        bst.postorder();
        System.out.println("\n\nInorder traversal: ");
        bst.inorder();
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