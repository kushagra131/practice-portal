package com.DataStructures;

public class LinkedList {
    private static Node head;

    private static class Node {
        private Node node;
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(5);
        list.head.next = new Node(2);
        list.head.next.next = new Node(9);
        list.head.next.next.next = new Node(1);
        list.push(12);
        list.push(44);
        list.push(22);

        printList(list.head);
        list.insertAfterNth(11, 4);
        printList(list.head);
        list.deleteNode(22);
        printList(head);
        list.insertAtNth(21, 7);
        printList(head);
        printList(list.reverseList(head));
    }

    private static void printList(Node head) {
        Node ptr = head;
        while(ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        ptr = null;
        System.out.println();
        System.out.println("Length -> " + length(head));
    }

    private static int length(Node head) {
        Node ptr = head;
        int length = 0;
        if(head != null) {
            while(ptr != null) {
                ptr = ptr.next;
                length++;
            }
            ptr = null;
        }
        return length;
    }

    private void push(int data) {
        Node new_node = new Node(data);
        if(head != null) {
            Node ptr = head;
            while(ptr.next != null)
                ptr = ptr.next;

            ptr.next = new_node;
        } else {
            head = new_node;
            new_node = null;
        }
    }

    private void insertAfterNth(int data, int pos) {
        Node new_node = new Node(data);
        if(head != null && pos > 0 && pos <= length(head)) {
            Node ptr = head;
            Node prev_node = null;
            int idx = 0;
            while(ptr != null && idx < pos) {
                prev_node = ptr;
                ptr = ptr.next;
                idx++;
            }
            prev_node.next = new_node;
            new_node.next = ptr;
            ptr = null;
        }
    }

    private void insertAtNth(int data, int pos) {
        Node new_node = new Node(data);
        if(head != null && pos > 0 && pos <= length(head)) {
            Node ptr = head;
            if(pos == 1) {
                head = new_node;
                head.next = ptr;
                ptr = null;
                return;
            }
            Node prev_node = null;
            int idx = 0;
            while(ptr != null && idx < pos - 1) {
                prev_node = ptr;
                ptr = ptr.next;
                idx++;
            }
            prev_node.next = new_node;
            new_node.next = ptr;
            ptr = null;
        }
    }

    private void deleteNode(int data) {
        if(head != null) {
            if(head.data == data) {
                head = head.next;
                return;
            }
            Node ptr = head;
            Node prev_node = null;
            while(ptr != null && ptr.data != data) {
                prev_node = ptr;
                ptr = ptr.next;
            }
            if(ptr == null)
                return;
            else {
                prev_node.next = ptr.next;
                ptr = null;
            }
        }
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    private Node reverseList(Node node) {
        if(node != null) {
            if (node.next != null) {
                Node prev_node = null;
                Node curr_node = node;
                Node next_node = null;
                while (curr_node != null) {
                    next_node = curr_node.next;
                    curr_node.next = prev_node;
                    prev_node = curr_node;
                    curr_node = next_node;
                }
                node = prev_node;
            }
            return node;
        } else
            return null;
    }


}
