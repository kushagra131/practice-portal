package org.example.data_structures;

public class DoublyLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DoubleLinkedList dlist = new DoubleLinkedList();
        dlist.printDLL(dlist.head);
        dlist.append(10);
        dlist.append(20);
        dlist.append(30);
        dlist.append(40);
        dlist.append(3);
        dlist.append(6);
        dlist.printDLL(dlist.head);
        dlist.insertAtHead(1);
        dlist.insertAtHead(99);
        dlist.printDLL(dlist.head);
        dlist.insertAfterGiven(dlist.head, 111);
        dlist.printDLL(dlist.head);
        dlist.quickSort(dlist.head, dlist.tail);
        dlist.printDLL(dlist.head);
    }

}

class DLLNode {
    DLLNode next;
    DLLNode previous;
    int data;

    DLLNode() {
        this.next = null;
        this.previous = null;
        this.data = 0;
    }

    DLLNode(int data) {
        this.next = null;
        this.previous = null;
        this.data = data;
    }

    DLLNode(DLLNode next, DLLNode previous, int data) {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }
}

class DoubleLinkedList {
    DLLNode head;
    DLLNode tail;
    int size;

    // append a Node at Tail
    void append(int data) {
        DLLNode nNode = new DLLNode(data);
        DLLNode ptr = head;

        if (ptr == null) {
            ptr = nNode;
            head = ptr;
            tail = head;
            size++;
            return;
        }
        if (ptr != null) {
            //ptr = nNode;
            tail.next = nNode;
            tail.previous = nNode.previous;
            tail = nNode;
            size++;
        }
        return;
    }

    //insert at Front
    void insertAtHead(int data) {
        DLLNode nNode = new DLLNode(data);
        DLLNode ptr = head;

        if (ptr == null) {
            ptr = nNode;
            head = ptr;
            tail = head;
            size++;
            return;
        }

        if (ptr != null) {
            nNode.next = head;
            head.previous = nNode;
            head = nNode;
            size++;
        }
        return;
    }

    // insert a new Node after a Given Node Pointer
    void insertAfterGiven(DLLNode prev, int data) {
        DLLNode nNode = new DLLNode(data);
        DLLNode ptr = prev;
        if (prev == null) {
            System.out.println("Prev cannot be Null");
            return;
        }
        nNode.next = ptr.next;
        ptr.next = nNode;
        nNode.previous = ptr;

        if (nNode.next != null) nNode.next.previous = nNode;
        size++;
        return;
    }

    //Partition() for QuickSort Partition
    DLLNode partition(DLLNode low, DLLNode high) {
        int pivot = high.data;

        DLLNode i = low.previous;
        for (DLLNode j = low; j != high; j = j.next) {
            if (j.data <= pivot) {
                i = (i == null) ? low : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }

        i = (i == null) ? low : i.next;
        int temp = i.data;
        i.data = high.data;
        high.data = temp;
        return i;
    }

    //QuickSort Recursive Function -> low:head, high:tail
    void quickSort(DLLNode low, DLLNode high) {
        if (high != null && low != high && low != high.next) {
            DLLNode partNode = partition(low, high);
            quickSort(low, partNode.previous);
            quickSort(partNode.next, high);
        }
    }

    // print DDL
    void printDLL(DLLNode node) {
        DLLNode ptr = node;
        System.out.println("\nDoubly Linked List");
        System.out.println("--------------------\n");
        if (ptr == null) {
            System.out.println("List Empty!!\n");
            return;
        }
        while (ptr != null) {
            System.out.print(ptr.data + " <-> ");
            ptr = ptr.next;
        }
        System.out.println("\n\nHEAD -> " + head.data);
        System.out.println("TAIL -> " + tail.data);
        System.out.println("Size -> " + size);
    }
}