package org.example.algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {12, 55, 67, 2, 2, 2, 2, 3, 5, 99, 15};
        System.out.println("Array -> " + Arrays.toString(array));

        MergeSort obj = new MergeSort();

        obj.sort(array, 0, array.length - 1);
        System.out.println("Sorted Array -> " + Arrays.toString(array));
    }

    void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        System.out.println("N1: " + n1);
        System.out.println("N2: " + n2);
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[l + i];
        }
        System.out.println("Left: " + Arrays.toString(leftArray));
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[m + 1 + j];
        }
        System.out.println("Right: " + Arrays.toString(rightArray));

        int i = 0, j = 0;
        int k = l;

        //put elements from left sub-array or right sub-array in array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //put the remaining elements from left sub-array to array
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        //put the remaining elements from right sub-array to array
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }

    void sort(int[] array, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            System.out.println("Middle: " + mid);
            sort(array, l, mid);
            sort(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }

}
