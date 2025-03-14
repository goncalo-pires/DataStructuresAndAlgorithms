package Algorithms.Sorting;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] list, int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(list, left, right);
        quickSort(list, left, pivotIndex - 1);
        quickSort(list, pivotIndex + 1, right);
    }

    public int partition(int[] list, int left, int right) {
        int pivot = list[right];
        int min = left - 1; // pointer to place the next value less than pivot

        // this if ensures all values less than pivot are placed on the left
        for (int i=left; i<right; i++) {
            if (list[i] <= pivot) {
                min++;
                swap(list, min, i);
            }
        }

        // put pivot in the right position
        swap(list, min + 1, right);
        return min + 1;
    }

    public void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public int[] quickSort2(int[] list, int left, int right) {
        if (list.length <= 1) return list;

        int pivotIndex = right;
        int pivot = list[pivotIndex];

        boolean swapped = false;
        for(int i=0; i<pivotIndex; i++) {
            if (list[i] > pivot) {
                swap2(list, i, pivotIndex);
                pivotIndex--;
                i--;
                swapped = true;
            }
        }

        if (!swapped) {
            return list;
        }

        int[] first = partition2(list, 0, pivotIndex);
        int[] second = partition2(list, pivotIndex, list.length);

        int[] mergedArray = new int[first.length + second.length];

        System.arraycopy(first, 0, mergedArray, 0, first.length);
        System.arraycopy(second, 0, mergedArray, first.length, second.length);

        return mergedArray;
    }

    public int[] partition2(int[] list, int left, int right) {
        int[] partitionedList = Arrays.copyOfRange(list, left, right);
        return quickSort2(partitionedList, left, right-left-1);
    }

    private void swap2(int[] list, int i, int j) {
        if (i + 1 == j) {
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        } else {
            int temp = list[j - 1];
            list[j - 1] = list[j];
            list[j] = list[i];
            list[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] sorted = quickSort.quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sorted));
    }

}
