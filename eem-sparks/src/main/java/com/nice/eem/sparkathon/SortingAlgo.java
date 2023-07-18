package com.nice.eem.sparkathon;


public class SortingAlgo {

    static int[] arr = {8, 9, 5, 3, 47, 62};

    public static void main(String[] args) {
        bubbleSort();
        selectionSort();
    }

    //bubble sort algorith return sorted array
    public static void bubbleSort() {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

    //selection sort algorithm return sorted array
    public static void selectionSort() {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        // Prints the sorted array
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

    }

}
