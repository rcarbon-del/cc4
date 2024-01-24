public class MergeSort3 {
    public static int ctr = 0;

    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1; ctr++;
        int n2 = r - m; ctr++;

        int L[] = new int[n1]; ctr++;
        int R[] = new int[n2]; ctr++;
        
        ctr++;
        for (int i = 0; i < n1; ++i){ ctr++; ctr++;
            L[i] = arr[l + i]; ctr++;
        }
        ctr++;
        for (int j = 0; j < n2; ++j){ ctr++; ctr++;
            R[j] = arr[m + 1 + j]; ctr++;
        }

        int i = 0, j = 0; ctr++;

        int k = l; ctr++;
        ctr++;
        while (i < n1 && j < n2) { ctr++; ctr++;
            if (L[i] <= R[j]) {
                arr[k] = L[i]; ctr++;
                i++; ctr++;
            } else {
                arr[k] = R[j]; ctr++;
                j++; ctr++;
            }
            k++; ctr++;
        }

        ctr++;
        while (i < n1) { ctr++; ctr++;
            arr[k] = L[i]; ctr++;
            i++; ctr++;
            k++; ctr++;
        }

        ctr++;
        while (j < n2) { ctr++; ctr++;
            arr[k] = R[j]; ctr++;
            j++; ctr++;
            k++; ctr++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2; ctr++;

            sort(arr, l, m); ctr++;
            sort(arr, m + 1, r); ctr++;

            merge(arr, l, m, r); ctr++;
        }
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7, 1, 2, 3, 4}; ctr++;

        MergeSort3 ob = new MergeSort3(); ctr++;
        ob.sort(arr, 0, arr.length - 1); ctr++;

        System.out.println("\nSorted array");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println("\n" + ctr);
    }
}