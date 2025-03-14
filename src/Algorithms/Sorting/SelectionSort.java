package Algorithms.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public void selectionSort(Integer[] list) {
        for (int i=0; i<list.length-1; i++) {
            int min = i;
            for (int j=i+1; j<list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = list[i];
                list[i] = list[min];
                list[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
