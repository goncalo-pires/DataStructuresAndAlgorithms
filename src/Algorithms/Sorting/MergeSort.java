package Algorithms.Sorting;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] list) {
        if (list.length <= 1) return list;

        int middle = list.length / 2;
        int[] first = Arrays.copyOfRange(list, 0, middle);
        int[] second = Arrays.copyOfRange(list, middle, list.length);

        return mergeArrays(mergeSort(first), mergeSort(second));
    }

    private int[] mergeArrays(int[] list1, int[] list2) {
        int[] sortedList = new int[list1.length + list2.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int index = 0;
        while (firstIndex < list1.length && secondIndex < list2.length) {
            if (list1[firstIndex] <= list2[secondIndex]) {
                sortedList[index] = list1[firstIndex];
                firstIndex++;
            } else {
                sortedList[index] = list2[secondIndex];
                secondIndex++;
            }
            index++;
        }

        System.arraycopy(list1, firstIndex, sortedList, index, list1.length - firstIndex);
        System.arraycopy(list2, secondIndex, sortedList, index, list2.length - secondIndex);

        return sortedList;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 99, 44, 6, 2, 1, 5, 63, 87, 283, 4};
        MergeSort mergeSort = new MergeSort();
        int[] integers = mergeSort.mergeSort(numbers);
        System.out.println(Arrays.toString(integers));
    }

}
