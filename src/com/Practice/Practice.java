package com.Practice;

import javax.sound.midi.SysexMessage;
import java.util.*;
import java.util.function.Consumer;

public class Practice {
    static String word = "Hello";
    static int[] arr = {11, 10, 20, 8, 1, 90, 55, 50, 45};

    public static void main(String[] args) {
        Practice obj = new Practice();
        // System.out.println("String Reversed -> " + obj.reverse(word));
        System.out.println("kth Largest Element -> " + obj.kthLargestElement(arr, 3));
        System.out.println("kth Smallest Element -> " + obj.kthSmallestElement(arr, 3));
        // System.out.println(Arrays.toString(obj.kSort(arr, 4)));
    }

    public String reverse(String word) {
        char[] arr = null;
        if(word == null || word.length() == 0) {
            return null;
        }
        else if(word.length() == 1)
            return word;
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
    private static void swap(char[] arr, int low, int high) {
        char temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public int kthLargestElement(int[] arr, int k) throws NullPointerException {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++) {
            if(maxHeap.peek() > arr[i])
                continue;
            else {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        Iterator<Integer> itr = maxHeap.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
        return maxHeap.peek();
    }

    public int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++) {
            if(minHeap.peek() < arr[i])
                continue;
            else {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        Iterator itr = minHeap.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();

        for(int i = 1; i < k; i++)
            minHeap.poll();
        return minHeap.peek();
    }

    public int[] kSort(int[] arr, int k) {
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
