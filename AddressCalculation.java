// Carbonel, Radge Daryll A. | BSCS 1 | CC4 1B | Array Address Calculation - RMS
import java.util.Scanner;

public class AddressCalculation {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        int baseAddress = input("Enter number of Base Address (B): ", choice), weight = input("Enter number of Weight (w): ", choice), dimensions = input("Enter number of Dimensions: ", choice), sum = 0;
        int[] dimensionsArray = new int[dimensions], elementArray = new int[dimensions];
        if (dimensions == 2) System.out.println("Upper Bound 1 = r (Number of Rows), Upper Bound 2 = c (Number of Columns), Array Index 1 = i (Row Index), Array Index 2 = j (Column Index). If not stated, use 0.");
        for (int i = 0; i < dimensions; i++) {
            dimensionsArray[i] = input("Enter number of Upper Bound " + (i + 1) + ": ", choice);
        }
        for (int i = 0; i < dimensions; i++) {
            elementArray[i] = input("Enter number of Array Index " + (i + 1) + ": ", choice);
        }
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
            if (Integer.parseInt(input) < 0){
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