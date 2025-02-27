import java.util.Arrays;

public class HeapSort {
    // Main function to perform HeapSort
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to the end
            swap(arr, 0, i);
            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain max heap property
    private static void heapify(int[] arr, int heapSize, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, heapSize, largest);
        }
    }

    // Swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test HeapSort
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
