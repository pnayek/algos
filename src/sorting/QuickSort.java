package sorting;

public class QuickSort {

    private static void partition(int[] a) {
        int pivot = a[0];
        int i = 1;
        for (int j = 1; j < a.length; j++) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i++] = a[j];
                a[j] = temp;
            }
        }
        a[0] = a[i - 1];
        a[i - 1] = pivot;
    }
}
