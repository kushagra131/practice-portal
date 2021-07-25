package com.Practice;

import java.util.*;

class Practice {
    static String word = "Hello";
    static int[] arr = {11, 10, 20, 8, 1, 90, 55, 50, 45};

    public static void main(String[] args) {

        // System.out.println("String Reversed -> " + reverse(word));
        kthLargestElement(arr, 3);
        // System.out.println(Arrays.toString(kSort(arr, 4)));
    }

    static String reverse(String word) {
        char[] arr = null;
        if(word == null || word.length() == 0) {
            return new String("String cannot be reversed");
        }
        else {
            int low = 0, high = word.length() - 1;
            arr = word.toCharArray();
            while(low < high) {
                swap(arr, low, high);

                low++;
                high--;
            }
        }
        return new String(arr);
    }

    // Swapper()
    static void swap(char[] arr, int low, int high) {
        char temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    static void kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++) {
            if(maxHeap.peek() > arr[i]) {
                continue;
            }
            else{
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        Iterator<Integer> itr = maxHeap.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("kth Largest Element -> " + maxHeap.peek());
    }

    static int[] kSort(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < k + 1; i++) {
            minHeap.add(arr[i]);
        }
        int index = 0;
        for(int i = k + 1; i < arr.length; i++) {
            arr[index++] = minHeap.peek();
            minHeap.poll();
            minHeap.add(arr[i]);
        }

        Iterator<Integer> itr = minHeap.iterator();
        while(itr.hasNext()) {
            arr[index++] = minHeap.peek();
            minHeap.poll();
        }
        return arr;
    }
}
