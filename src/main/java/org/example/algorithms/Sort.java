package org.example.algorithms;

import java.util.Arrays;

public class Sort {

    //Selection Sort In Place Algorithm
    //TC = O(N^2)
    //SC = O(N), AuxSpace = O(1)
    private static void selectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < length; j++) {

                if (array[minIndex] > array[j]) minIndex = j;
            }
            //Swap
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println("Sorted Array --> " + Arrays.toString(array));
    }

    //Stable Selection Sort, maintains order of similar elements
    //TC = O(N^2)
    //SC = O(N), AuxSpace = O(1)
    private static void stableSelectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j]) minIndex = j;
            }

            int key = array[minIndex];
            while (minIndex > i) {
                array[minIndex] = array[minIndex - 1];
                minIndex--;
            }
            array[minIndex] = key;
        }
        System.out.println("Sorted Array --> " + Arrays.toString(array));
    }

    //Selection Sort for String array
    //TC = O(N^2)
    //SC = O(N), AuxSpace = O(1)
    private static void stringSelectionSort(Object[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex].toString().compareTo(array[j].toString()) > 0) minIndex = j;
            }

            //Swap
            Object temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println("Sorted String Array --> " + Arrays.toString(array));
    }

    //Bubble Sort
    //TC = O(N^2)
    //SC = O(N), AuxSpace = O(1)
    private static void bubbleSort(int[] array) {
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
        System.out.println("Sorted Array --> " + Arrays.toString(array));
    }

    //Insertion Sort suitable for small size arrays
    //TC = O(N^2)
    //SC = O(N), AuxSpace = O(1)
    private static void insertionSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        System.out.println("Sorted Array --> " + Arrays.toString(array));
    }

    //MergeSort -> Divide & Conquer Algorithm
    //TC = O(N logN)
    //SC = O(N), AuxSpace = O(N)
    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            //calculate middle
            int middle = low + (high - low) / 2;
            System.out.println("Left=" + low + " Right=" + high + " Middle=" + middle);

            //recur for left part
            mergeSort(array, low, middle);
            //recur for right part
            mergeSort(array, middle + 1, high);

            //merge the 2 halves
            merge(array, low, middle, high);
        }
    }

    //Merge helper() for MergeSort
    private static void merge(int[] array, int left, int middle, int right) {
        //calculate size of Left and Right subArrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //create Left and Right subArrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //copy elements from array to Left Array
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        System.out.println("Left Array -> " + Arrays.toString(leftArray));

        //copy elements from array to Right Array
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle + 1 + j];
        System.out.println("Right Array -> " + Arrays.toString(rightArray));

        int i = 0, j = 0; //initialize index i and j for Left & Right Arrays
        int k = left; //index for sorted array

        //copy elements from Left & Right Array to Sorted Array
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

        //copy the remaining elements in Left Array
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        //copy the remaining elements in Right Array
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
        System.out.println("Array[K] -> " + Arrays.toString(array) + "\n");

    }

    //QuickSort Algorithm
    //TC Average = O(N logN), TC Worst = O(N^2)
    //SC = O(N) for Recursive Solution without Tail Call Optimization
    //SC = O(LogN) for Recursive Solution with Tail Call Optimization
    //AuxSpace = O(1)
    private static void quickSort(int[] array, int left, int right) {
        System.out.println("Left=" + left + " Right=" + right);


        // Without Tail Call Optimization
		/*if(left < right){
			int pi = partition(array, left, right); //calculate the Partition Index and 
													//put pivot element at right place
			System.out.println("PI=" + pi);
			
			//Recur for Left Half
			quickSort(array, left, pi-1);
			
			//Recur for Right Half
			quickSort(array, pi+1, right);
		}*/

        // Tail Call Optimization
        while (left < right) {
            //calculate Partition Index and put pivot in correct position,
            //selects Last Element as Pivot
			/*int pi = partition(array, left, right);
			System.out.println("PI=" + pi);*/

            //calculate Random Partition Index and put Pivot in correct position
            int pi = randomizedPartition(array, left, right);
            System.out.println("PI=" + pi);

            //Recur for Left Part
            if (pi - left < right - pi) {
                quickSort(array, left, pi - 1);
                left = pi + 1;
            }
            //Recur for Right Part
            else {
                quickSort(array, pi + 1, right);
                right = pi - 1;
            }
        }
    }

    //Partition() for QuickSort
    public static int partition(int[] array, int left, int right) {

        int pivot = array[right]; //Taking Pivot Element as Last Element
        System.out.println("Pivot=" + pivot);

        int i = left - 1; //index of smaller element
        for (int j = left; j < right; j++) {
            //if current element is <= pivot
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        //swap array[i+1] with array[right] or pivot
        swap(array, i + 1, right);
        System.out.println("Array -> " + Arrays.toString(array) + "\n");

        return i + 1;
    }

    //Randomized Partition() for choosing Random Pivot
    public static int randomizedPartition(int[] array, int left, int right) {

        int length = right - left + 1;
        int randomPivot = (int) (Math.random() * length); //calculate random pivot index
        System.out.println("Random Pivot Index=" + randomPivot);

        //swap
        swap(array, left + randomPivot, right);
        return partition(array, left, right);
    }

    //swapper() for swapping elements in given array
    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    //HeapSort -> uses a Binary Heap
    //TC = O(N logN)
    //SC = O(N), AuxSpace = O(1)
    private static void heapSort(int[] array) {
        int size = array.length;

        //Build a MaxHeap / MinHeap from Array
        for (int i = size / 2 - 1; i >= 0; i--) {

            maxHeapify(array, size, i); //for sorting in INCREASING order
            //minHeapify(array, size, i); //for sorting in DECREASING order
        }

        //move Root to Last and call MaxHeapify / MinHeapify at root index

        for (int i = size - 1; i >= 0; i--) {
            swap(array, 0, i); //move current root to end

            maxHeapify(array, i, 0); //for sorting in INCREASING order
            //minHeapify(array, i, 0); //for sorting in DECREASING order
        }
        System.out.println("Sorted Array -> " + Arrays.toString(array));
    }

    //MaxHeapify() for maintaining MaxHeap property
    //TC = O(logN)
    public static void maxHeapify(int[] array, int size, int index) {

        int largest = index; //make index as largest
        int left = 2 * index + 1; //calculate left element index
        int right = 2 * index + 2; //calculate right element index

        //check left element > largest
        if (left < size && array[left] > array[largest]) largest = left;

        //check right element > largest
        if (right < size && array[right] > array[largest]) largest = right;

        //check largest is not root
        if (largest != index) {
            swap(array, index, largest); //swap index with largest
            maxHeapify(array, size, largest); //call MaxHeapify at largest
        }
    }

    //MinHeapify() for maintaining MinHeap property
    //TC = O(logN)
    public static void minHeapify(int[] array, int size, int index) {

        int smallest = index; //make index as smallest
        int left = 2 * index + 1; //calculate left element index
        int right = 2 * index + 2; //calculate right element index

        //check left element < smallest
        if (left < size && array[left] < array[smallest]) smallest = left;

        //check right element < smallest
        if (right < size && array[right] < array[smallest]) smallest = right;

        //check smallest is not parent/index
        if (smallest != index) {
            swap(array, index, smallest); //swap index/parent with smallest
            minHeapify(array, size, smallest); //call MinHeapify at smallest
        }
    }

    //getMax() to get the maximum value element from array
    public static int getMax(int[] array, int length) {
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    //Radix Sort, internally uses Counting Sort Algorithm with O(N + K)
    private static void radixSort(int[] array) {
        int max = getMax(array, array.length); // get max value element in array

        //for each exponents call Counting Sort
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, array.length, exp);
        }
        System.out.println("Sorted Array -> " + Arrays.toString(array));
    }

    //Counting Sort Algorithm
    //TC = O(N + K)
    //SC = O(N)
    private static void countSort(int[] array, int length, int exp) {
        int[] output = new int[length]; // Output Array
        int[] count = new int[10]; // Count Array to maintain counts

        Arrays.fill(count, 0); // Fill the Count Array with 0's

        //Store the count of occurrences of each digit
        for (int i = 0; i < length; i++)
            count[(array[i] / exp) % 10]++;

        //Change the Count Array so it contains actual position of digits
        for (int i = 1; i < count.length; i++)
            count[i] = count[i - 1] + count[i];

        //Build the Output Array
        for (int i = length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--; //Decrement the count at position
        }
        //Copy the Output Array to Original Array
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }

    }


    //Main()
    public static void main(String[] args) {
        int[] array = {63, 25, 12, 2, 22, 11, 19, 100, 1, 64};
        //Object[] stringArray = {"GeeksforGeeks", "Practice.GeeksforGeeks",  "GeeksQuiz"};

        System.out.println("Unsorted Array -> " + Arrays.toString(array));
        //System.out.println("Unsorted String Array --> " + Arrays.toString(stringArray));

        //selectionSort(array);
        //stableSelectionSort(array);
        //stringSelectionSort(stringArray);
        //bubbleSort(array);
        //insertionSort(array);
        //mergeSort(array, 0, array.length-1);
        //quickSort(array, 0, array.length-1);
        //heapSort(array);
        radixSort(array);
    }

}


