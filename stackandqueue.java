import java.util.*;

public class stackandqueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Stack\n2. Queue\nEnter your choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.print("Enter the upper bound: ");
            int upperBound = scanner.nextInt();
            stackProgram(upperBound, scanner);
        } else if (choice == 2) {
            System.out.print("Enter the upper bound: ");
            int upperBound = scanner.nextInt();
            queueProgram(upperBound, scanner);
        } else {
            System.out.println("Invalid choice. Please enter either 'stack' or 'queue'.");
        }
    }

    public static void stackProgram(int upperBound, Scanner scanner) {
        Stack<Integer> stack = new Stack<>();
        int action = 0;
        while (action != 3) {
            System.out.print ("1. Push\n2. Pop\n3. Finish\nEnter your choice: ");
            action = scanner.nextInt();
            if (action == 1) {
                if (stack.size() < upperBound) {
                    System.out.print("Enter the item to push into the stack: ");
                    int item = scanner.nextInt();
                    stack.push(item);
                    System.out.println("Pushed " + item + " into the stack.");
                } else {
                    System.out.println("Stack is full");
                }
            } else if (action == 2) {
                if (!stack.isEmpty()) {
                    System.out.println("Popped " + stack.pop() + " from the stack");
                } else {
                    System.out.println("Stack is empty");
                }
            }
        }
        System.out.println("Final stack: " + stack);
    }

    public static void queueProgram(int upperBound,Scanner scanner) {
        Queue<Integer> queue = new LinkedList<>();
        int action = 0;
        while (action != 3) {
            System.out.print ("1. Enqueue\n2. Dequeue\n3. Finish\nEnter your choice:");
            action = scanner.nextInt();
            if (action == 1) {
                if (queue.size() < upperBound) {
                    System.out.print("Enter the item to enqueue into the queue: ");
                    int item = scanner.nextInt();
                    queue.add(item);
                    System.out.println("Enqueued " + item + " into the queue");
                } else {
                    System.out.println("Queue is full");
                }
            } else if (action == 2) {
                if (!queue.isEmpty()) {
                    System.out.println("Dequeued " + queue.remove() + " from the queue");
                } else {
                    System.out.println("Queue is empty");
                }
            }
        }
        System.out.println("Final queue: " + queue);
    }
}