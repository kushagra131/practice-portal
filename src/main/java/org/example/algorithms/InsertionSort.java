package org.example.algorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {12, 55, 67, 2, 3, 5, 99, 15};
        //Scanner input = new Scanner(System.in);

        InsertionSort obj = new InsertionSort();
        obj.sort(array);
    }

    void sort(int[] array) {

        if (array.length <= 1) {
            System.out.println("Array too Small to Sort!!");
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        System.out.println("Sorted Array -->  " + Arrays.toString(array));
    }
}
