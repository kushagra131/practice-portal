package org.example.algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {12, 55, 67, 2, 2, 2, 2, 3, 5, 99, 15};

        BubbleSort obj = new BubbleSort();
        obj.sort(array);
        System.out.println("Sorted Array -> " + Arrays.toString(array));

    }

    void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
