import java.util.Random;

public class MergeSort {
    public static int ctr = 0;
  public static void main(String[] args) {

    Random rand = new Random();
    int[] numbers = new int[100];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(1000000);
    }

    System.out.println("Before:");
    printArray(numbers);

    mergeSort(numbers); 

    System.out.println("\nAfter:");
    printArray(numbers);
    System.out.println(ctr);
  }


  private static void mergeSort(int[] inputArray) {
    int inputLength = inputArray.length; ctr++;
    
    if (inputLength < 2) { ctr++;
      return;
    }
    
    int midIndex = inputLength / 2; ctr++;
    int[] leftHalf = new int[midIndex]; ctr++;
    int[] rightHalf = new int[inputLength - midIndex]; ctr++;
    ctr++;
    for (int i = 0; i < midIndex; i++) { ctr++; ctr++;
      leftHalf[i] = inputArray[i]; ctr++;
    }
    ctr++;
    for (int i = midIndex; i < inputLength; i++) { ctr++; ctr++;
      rightHalf[i - midIndex] = inputArray[i]; ctr++;
    }
    
    mergeSort(leftHalf); ctr++;
    mergeSort(rightHalf); ctr++;
    
    merge(inputArray, leftHalf, rightHalf); ctr++;
  }

  private static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length; ctr++;
    int rightSize = rightHalf.length; ctr++;
    
    int i = 0, j = 0, k = 0; ctr++;
    ctr++;
    while (i < leftSize && j < rightSize) { ctr++; ctr++;
      if (leftHalf[i] <= rightHalf[j]) {
        inputArray[k] = leftHalf[i]; ctr++;
        i++; ctr++;
      }
      else {
        inputArray[k] = rightHalf[j]; ctr++;
        j++; ctr++;
      }
      k++; ctr++;
    }
    
    ctr++;
    while (i < leftSize) { ctr++; ctr++;
      inputArray[k] = leftHalf[i]; ctr++;
      i++; ctr++;
      k++; ctr++;
    }
    ctr++;
    while (j < rightSize) { ctr++; ctr++;
      inputArray[k] = rightHalf[j]; ctr++;
      j++; ctr++;
      k++; ctr++;
    }
    
  }

  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}
