package arrays;

public class Sort {

    private Sort() {
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPosition = getMin(array, i);
            int tmp = array[i];
            array[i] = array[minPosition];
            array[minPosition] = tmp;
        }
    }

    private static int getMin(int[] array, int i) {
        int min = array[i];
        int minPosition = i;
        for (int j = i; j < array.length; j++) {
            if (min > array[j]) {
                min = array[j];
                minPosition = j;
            }
        }
        return minPosition;
    }

    public static void bubbleSort(int[] array) {
        boolean isSort;
        do {
            isSort = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    isSort = false;
                }
            }
        } while (!isSort);
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            sortBack(array, i);
        }
    }

    private static void sortBack(int[] array, int i) {
        int j = i;
        while (j > 0 && array[j] < array[j - 1]) {
            int tmp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = tmp;
            j--;
        }
    }

    public static void mergeSort(int[] array) {
        int l = 0;
        int r = array.length;
        mergeSort(array, l, r);
    }

    private static void mergeSort(int[] array, int l, int r) {
        int m = l + (r - l) / 2;
        if (r > l) {
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        for (int i = l; i < r; i++) {
            int pos = getMin(array,i,r);
            int tmp = array[i];
            array[i] = array[pos];
            array[pos] = tmp;

        }

    }

    private static int getMin(int[] array, int l, int r) {
        int pos = l;
        int min = array[l];
        for (int i = l; i < r; i++) {
            if (min > array[i]) {
                min = array[i];
                pos = i;
            }
        }
        return pos;
    }
}
