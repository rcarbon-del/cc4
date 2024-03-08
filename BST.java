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

    void toListWithPlaceholders() {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {
                list.add(node.key);
                if (node.left != null || node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            } else {
                list.add(0);
            }
        }

        System.out.println("Array representation: " + list);
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
        bst.toListWithPlaceholders();
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