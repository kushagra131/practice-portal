package org.example.algorithms;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        System.out.println("Array -> " + Arrays.toString(array));

        RandomizedQuickSort obj = new RandomizedQuickSort();
        obj.randomizedQuickSort(array, 0, array.length - 1);
        System.out.println("SORTED Array -> " + Arrays.toString(array));
    }

    //swapper function
    void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

    //Randomized Partition()
    int randomizedPartition(int[] array, int low, int high) {

        int n = high - low + 1;
        int randomPivot = (int) (Math.random() * (n - 1));//random pivot
        System.out.println("Random Pivot Index -> " + randomPivot);

        //swap array[high] with with array[low + pivot]
        swap(array, low + randomPivot, high);
        System.out.println("Array -> " + Arrays.toString(array) + "\n");

        return partition(array, low, high);
    }

    //normal QuickSort Partition procedure
    int partition(int[] array, int low, int high) {

        //normal partition now
        int pivot = array[high];
        System.out.println("Pivot Element -> " + pivot);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            //swap every element smaller than pivot
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
                System.out.println("i -> " + i + " j -> " + j + " Swap");
            }
        }
        //swap element greater than pivot
        swap(array, i + 1, high);
        System.out.println("Array -> " + Arrays.toString(array) + "\n");

        return (i + 1);
    }

    void randomizedQuickSort(int[] array, int low, int high) {
        System.out.println("low -> " + low + " high -> " + high);

        // using tail recursion sorting
        while (low < high) {
            int pi = randomizedPartition(array, low, high);
            System.out.println("PIndex -> " + pi);
            randomizedQuickSort(array, low, pi - 1);
            //randomizedQuickSort(array, pi+1, high);
            low = pi + 1;
        }
    }

}
