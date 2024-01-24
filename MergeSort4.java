import java.util.Arrays;
import java.util.Random;
public class MergeSort4 {
    public static int ctr = 0;
    public static void merge(int arr[], int temp[], int l, int m, int r) {
        int i = l, j = m+1, k = l; ctr++;
        System.arraycopy(arr, l, temp, l, r-l+1); ctr++;
        ctr++;
        while (i <= m && j <= r) { ctr++; ctr++;
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++]; ctr++;
            } else {
                arr[k++] = temp[j++]; ctr++;
            }
        }
        ctr++;
        while (i <= m) { ctr++; ctr++;
            arr[k++] = temp[i++]; ctr++;
        }
        ctr++;
        while (j <= r) { ctr++; ctr++;
            arr[k++] = temp[j++]; ctr++;
        }
    }
    public static void sort(int arr[], int temp[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2; ctr++;

            sort(arr, temp, l, m); ctr++;
            sort(arr, temp, m + 1, r); ctr++;

            merge(arr, temp, l, m, r); ctr++;
        }
    }
    public static void main(String args[]) {
        Random rand = new Random();
        int arr[] = new int[1000]; ctr++;
        int temp[] = new int[arr.length]; ctr++;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
        sort(arr, temp, 0, arr.length - 1); ctr++;
        System.out.println("Sorted array\n" + Arrays.toString(arr) + "\n\nCounter: " + ctr ); ctr++;
    }
}