package org.example.data_structures;

import java.util.Arrays;

public class BinaryHeap {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinHeap minHeap = new MinHeap(10);
        minHeap.insertKey(11);
        minHeap.insertKey(12);
        minHeap.insertKey(10);
        minHeap.insertKey(2);
        minHeap.insertKey(7);

        //System.out.println("Extract Min -> " + minHeap.extractMin());
        //minHeap.decreaseKey(3, 9);
        //System.out.println("Extract Min -> " + minHeap.extractMin());
        System.out.println("Arrays -> " + Arrays.toString(minHeap.array));
        String key = "caterz";
        for (int i = 0; i < key.length(); i++) {
            char index = key.charAt(i);
            System.out.println(key.charAt(i) + " -> " + index);
        }

    }

}

class MinHeap {

    int capacity;
    int heapsize;
    Integer[] array;

    //Constructor
    MinHeap(int capacity) {
        this.capacity = capacity;
        heapsize = 0;
        array = new Integer[capacity];
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    int leftChild(int index) {
        return (2 * index + 1);
    }

    int rightChild(int index) {
        return (2 * index + 2);
    }

    //Insert the new key at the end of the Tree. If Parent < key then do nothing
    //If Parent > key then move up and fix the violated Heap property.
    void insertKey(int key) {
        if (heapsize == capacity) {
            System.out.println("Oveflow!!");
            return;
        }
        System.out.println("Insert Key -> " + key);

        heapsize++;
        int i = heapsize - 1;
        array[i] = key;
        System.out.println("Heapsize -> " + this.heapsize);

        while (i != 0 && array[parent(i)] > key) {
            swap(i, parent(i));
            i = parent(i);
        }
        System.out.println("Get Min -> " + this.getMin());
        System.out.println("Left -> " + array[1]);
        System.out.println("Right -> " + array[2]);

        System.out.println("Array -> " + Arrays.toString(this.array) + "\n");

    }

    //decreases the key at given index with minus Infinity then calls extractMin()
    void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();

    }

    //get Root of Tree
    int getMin() {
        return array[0];
    }

    //decrease the key at index with given value, then if property violated then move up and fix
    void decreaseKey(int index, int value) {
        array[index] = value;

        while (index != 0 && array[parent(index)] > array[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
        System.out.println("Get Min -> " + this.getMin());
        System.out.println("Left -> " + array[1]);
        System.out.println("Right -> " + array[2]);

        System.out.println("Array -> " + Arrays.toString(this.array) + "\n");
    }

    //extract the root or minimum element, copy last element to root and MinHeapify(0)
    int extractMin() {
        if (heapsize <= 0) return Integer.MAX_VALUE;
        if (heapsize == 1) return array[0];

        int root = array[0];
        array[0] = array[heapsize - 1];
        heapsize--;
        minHeapify(0);

        return root;
    }

    //MinHeapify the tree with the root at given index
    void minHeapify(int index) {
        int l = leftChild(index);
        int r = rightChild(index);
        int smallest = index;

        if (l < heapsize && array[l] < array[smallest]) smallest = l;
        if (r < heapsize && array[r] < array[smallest]) smallest = r;
        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }

    }

    //swap()
    void swap(int x, int y) {
        int temp = array[y];
        array[y] = array[x];
        array[x] = temp;
    }

}

