import java.util.Arrays;
import java.util.Random;
public class MergeSort2 {
    public static int ctr = 0;
    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m, i = 0, j = 0, k = l; ctr++;

        int L[] = new int[n1], R[] = new int[n2]; ctr++;

        System.arraycopy(arr, l, L, 0, n1); ctr++;
        System.arraycopy(arr, m + 1, R, 0, n2); ctr++;

        ctr++;
        for (;i < n1 && j < n2; k++) { ctr++; ctr++;
            if (L[i] <= R[j]) {
                arr[k] = L[i]; ctr++;
                i++; ctr++;
            } else {
                arr[k] = R[j]; ctr++;
                j++; ctr++;
            }
        }

        ctr++;
        for (;i < n1; i++, k++) { ctr++; ctr++;
            arr[k] = L[i]; ctr++;
        }

        ctr++;
        for (;j < n2; j++, k++) { ctr++; ctr++;
            arr[k] = R[j]; ctr++;
        }
    }
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2; ctr++;

            sort(arr, l, m); ctr++;
            sort(arr, m + 1, r); ctr++;

            merge(arr, l, m, r); ctr++;
        }
    }
    public static void main(String args[]) {
        Random rand = new Random();
        int arr[] = new int[1000]; ctr++;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }

        sort(arr, 0, arr.length - 1); ctr++;
        System.out.println("Sorted array\n" + Arrays.toString(arr) + "\n\nCounter: " + ctr ); ctr++;
    }
}