package Algorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(Integer[] list) {
        for (int i=1; i<list.length; i++) {
            int current = list[i];
            int j = i-1;
            while (j >= 0 && list[j]>current) {
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = current;
        }
    }

    public void insertionSort2(Integer[] list) {
        for (int i=1; i<list.length; i++) {
            if (list[i] < list[i-1]) {
                for (int j=0; j<i; j++) {
                    if (list[j] > list[i]) {
                        shiftRightByOne(list, j, i);
                    }
                }
            }
        }
    }

    private void shiftRightByOne(Integer[] list, int initialIndex, int finalIndex) {
        int temp = list[finalIndex];
        for (int i=finalIndex; i>initialIndex; i--) {
            list[i] = list[i-1];
        }
        list[initialIndex] = temp;
    }

    public static void main(String[] args) {
        Integer[] numbers = {3, 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
