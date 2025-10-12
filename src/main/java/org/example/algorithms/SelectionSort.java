package org.example.algorithms;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {12, 55, 67, 2, 2, 2, 2, 3, 5, 99, 15};

        SelectionSort obj = new SelectionSort();
        obj.sort(array);
        System.out.println("Sorted Array -> " + Arrays.toString(array));
    }

    void sort(int[] array) {
        int minIDX;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            minIDX = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIDX] > array[j]) {
                    int temp = array[minIDX];
                    array[minIDX] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
