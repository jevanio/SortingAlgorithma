package arrays;

public class Sort {
    private final int[] array;

    public Sort(int[] array) {
        this.array = array;
    }

    public void selectionSort() {
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

    public void bubbleSort() {
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

    public void insertionSort() {
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

    public void mergeSort() {
        int l = 0;
        int r = array.length;
        mergeSort(array, l, r);
    }

    private static void mergeSort(int[] array, int l, int r) {
        int m = l + (r - l) / 2;
        if (r > l) {
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, r);
        }
    }

    private static void merge(int[] array, int l, int r) {
        for (int i = l; i < r; i++) {
            int pos = getMin(array, i, r);
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

    public void quickSort(String pivotType) throws Exception {

        quickSort(array, 0, array.length - 1, pivotType);
    }

    private static void quickSort(int[] array, int low, int high, String pivotType) throws Exception {
        if (low < high) {
            int pi = partition(array, low, high, pivotType);
            quickSort(array, low, pi - 1, pivotType);
            quickSort(array, pi + 1, high, pivotType);
        }

    }

    /**
     * Algorithm to get partition point.
     * Pick partition element, sort array based on an element.
     * First, choose element as partition. Then, sort array based on partition value.
     * If value is greater than array[partition] -> to left, else, move to the right
     */
    private static int partition(int[] array, int low, int high, String pivotType) throws Exception {
        switch (pivotType) {
            case "first":
                return partitionFirst(array, low, high);
            case "last":
                return partitionLast(array, low, high);
            case "middle":
                return partitionMiddle(array, low, high + 1);
            default:
                throw new Exception("Invalid quicksort type");
        }
    }

    private static int partitionLast(int[] array, int low, int high) {
        int pivot = array[high];
        int finalPos = low;
        for (int i = low; i < high; i++) {
            if (pivot > array[i]) {
                swap(array, i, finalPos);
                finalPos++;
            }
        }
        swap(array, high, finalPos);
        return finalPos;
    }

    private static int partitionFirst(int[] array, int low, int high) {
        int pivot = array[low];
        int finalPos = high;
        for (int i = high; i > low; i--) {
            if (pivot < array[i]) {
                swap(array, i, finalPos);
                finalPos--;
            }
        }
        swap(array, low, finalPos);
        return finalPos;
    }

    private static int partitionMiddle(int[] array, int low, int high) {
        int middle = (low + high) / 2;
        int pivot = array[middle];
        int[] leftArray = new int[high - low];
        int leftCount = 0;
        int[] rightArray = new int[high - low];
        int rightCount = 0;
        for (int i = low; i < high; i++) {
            if (i == middle) {
                continue;
            }
            if (pivot > array[i]) {
                leftArray[leftCount++] = array[i];
            }
            if (pivot <= array[i]) {
                rightArray[rightCount++] = array[i];
            }
        }
        for (int i = 0; i < leftCount; i++) {
            array[low + i] = leftArray[i];
        }
        int pivotPos = low + leftCount;
        array[pivotPos] = pivot;

        for (int i = 0; i < rightCount; i++) {
            array[i + pivotPos + 1] = rightArray[i];
        }

        return pivotPos;
    }

    private static void swap(int[] array, int low, int finalPos) {
        int temp = array[low];
        array[low] = array[finalPos];
        array[finalPos] = temp;
    }
}
