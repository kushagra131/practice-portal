package org.example.algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        System.out.println("Array -> " + Arrays.toString(array));
        QuickSort obj = new QuickSort();
        obj.quickSort(array, 0, array.length - 1);
        System.out.println("Sorted Array -> " + Arrays.toString(array));
    }

    //swapper()
    void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

    //QuickSort Partition() to sort the elements according to the Pivot which is the last element
    int partition(int[] array, int low, int high) {

        int pivot = array[high];    //select pivot as high element or last element
        System.out.println("pivot -> " + pivot);

        int i = low - 1;//start with index - 1

        for (int j = low; j <= high - 1; j++) {
            //swap all elements smaller than pivot
            if (array[j] <= pivot) {
                i++;
                //swap all elements smaller than pivot
                swap(array, i, j);
                System.out.println("i -> " + i + " j -> " + j + " Swap");
            }
        }
        //swap element greater than pivot or array[high]
        swap(array, i + 1, high);
        System.out.println("Array -> " + Arrays.toString(array) + "\n");
        return (i + 1);
    }

    void quickSort(int[] array, int low, int high) {
        System.out.println("low -> " + low + " high -> " + high);

        // for recursively sorting left and right sub arrays
		/*if(low < high){
			int pi = partition(array, low, high);
			System.out.println("PIndex -> " + pi);

			quickSort(array, low, pi-1);
			quickSort(array, pi+1, high);
		}*/

        //for tail-recursive sorting -> good for optimizing Stack space
        while (low < high) {
            int pi = partition(array, low, high);
            System.out.println("PIndex -> " + pi);

            quickSort(array, low, pi - 1);
            //quickSort(array, pi+1, high);
            low = pi + 1;//tail recursion optimization
        }

    }

}
