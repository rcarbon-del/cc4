import java.util.Scanner;

public class AddressCalculation {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        int baseAddress = input("Enter number of Base Address (B): ", choice);
        int weight = input("Enter number of Weight (w): ", choice);
        int dimensions = input("Enter number of Dimensions: ", choice);
        int[] dimensionsArray = new int[dimensions];
        int[] elementArray = new int[dimensions];
        for (int i = 0; i < dimensions; i++) {
            String message = "Enter number of Dimension " + (i + 1) + ": ";
            dimensionsArray[i] = input(message, choice);
        }
        for (int i = 0; i < dimensions; i++) {
            String message = "Enter number of Element " + (i + 1) + ": ";
            elementArray[i] = input(message, choice);
        }
        int sum = 0;
        choice.close();
        for (int i = 1; i <= dimensions; i++) {
            int temp = elementArray[i - 1];
            for (int j = i; j < dimensions; j++) {
                temp *= dimensionsArray[j];
            }
            sum += temp;
        }
        int total = baseAddress + (weight * sum);
        System.out.println("Address: " + total);
    }
    public static int input(String message, Scanner choice) {
        System.out.print(message);
        String input = choice.nextLine();
        int input1 = 0;
        try {
            if (Integer.parseInt(input) <= 0){
                System.out.println("Invalid Input");
                input(message, choice);
            }
            else{
                input1 = Integer.parseInt(input);
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
            input(message, choice);
        }
        return input1;
    }
}