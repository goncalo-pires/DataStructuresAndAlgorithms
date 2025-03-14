package Algorithms.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(Integer[] list) {
        for (int n = list.length; n>1 ; n--) {
            boolean swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (list[i] > list[i+1]) {
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public void bubbleSort2(Integer[] list) {
        for (int i=0; i<list.length; i++) {
            boolean swapped = false;
            for (int j=0; j<list.length-1; j++) {
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
