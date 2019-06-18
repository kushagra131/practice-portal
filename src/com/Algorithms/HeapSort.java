package com.Algorithms;

import java.util.Arrays;

public class HeapSort {
	
	//swapper()
	void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	void heapSort(int[] array){
		int n = array.length;
		
		//build MaxHeap of all subTrees from bottom-up
		for (int i = n/2 - 1; i >= 0; i--){
			maxHeapify(array, n, i);
		}
		//replace the root with last
		for(int i = n-1; i >= 1; i--){
			swap(array, i, 0);
			maxHeapify(array, i, 0); /*finally MaxHeapify the root*/
		}
	}
	
	void maxHeapify(int[] array, int n, int index){
		int l = 2*index + 1;
		int r = 2*index + 2;
		int largest = index;
		
		//IF l < heap size and l element > largest
		if(l <= n-1 && array[l] > array[largest])
			largest = l;
		//IF r < heap Size and r element > largest
		if(r <= n-1 && array[r] > array[largest])
			largest = r;
		//check IF largest != index, then swap array[index] with array[largest]
		if(largest != index){
			swap(array, index, largest);
			maxHeapify(array, n, largest);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,1,1,2,16,9,10,14,8,7};
		HeapSort obj = new HeapSort();
		
		obj.heapSort(array);
		System.out.println("Sorted Array -> " + Arrays.toString(array));
	}

}
