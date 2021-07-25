package com.DataStructures;

import java.util.HashSet;

import com.DataStructures.LinkedList.Node;

class SingleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		
//		// Calls for Stack Build
//		list.push(5);
//		list.push(10);
//		list.push(1);
//		list.push(22);
//		list.push(100);
//
//		// Calls for Queue Build
//		list.enQueue(6);
//		list.enQueue(1);
//		list.enQueue(3);
//		list.enQueue(77);
//		list.enQueue(100);
//
//		// Call for append() & delete element in LinkedList
//		list.printList(list.head);
//		list.append(list.head, 10);
//		list.append(list.head, 20);
//		list.append(list.head, 31);
//		list.append(list.head, 45);
//		list.append(list.head, 53);
//		list.append(list.head, 40);
//		list.append(list.head, 30);
//		list.append(list.head, 27);
//		list.append(list.head, 10);
//		list.append(list.head, 60);
//		list.printList(list.head);
//		list.insertAfter(3, 100);
//		list.printList(list.head);
//		list.deleteElement(100);
//		list.printList();
//		list.deleteAtPosition(4);
//		list.printList();
//		list.search(60);
//		list.getNth(5);
//		Node mid = list.midElement(list.head);
//		Node mid = list.getMiddle(list.head);
//		System.out.println("Mid Element -> " + mid.data);
//		System.out.println("Count -> " + list.countElement(list.head, 100) + "\n");
//		list.head.next.next.next.next = list.head; //----->> created a loop
//		list.detectLoop(list.head);
//		list.reverse(list.head);
//		list.reverseRecursive(list.head, null);
//		list.printList(list.head);
//		list.reverseRecursive(list.head, null);
//		list.printList(list.head);
//		System.out.println("Length of Loop -> " + list.loopLength(list.head));
//		list.deleteEven(list.head);
//
//		list.printList(list.head);
//		Node sortedList = list.mergeSort(list.head);
//
//		list.append(list.head, 'a');
//		list.append(list.head, 'b');
//		list.append(list.head, 'c');
//		list.append(list.head, 'd');
//		list.append(list.head, 'e');
//		list.append(list.head, 'e');
//		list.append(list.head, 'd');
//		list.append(list.head, 'c');
//		list.append(list.head, 'b');
//		list.append(list.head, 'a');
//		list.printList(list.head);*/
//		list.isPalindrome(list.head);
	}

}

class LinkedList {
	
	class Node {
		protected Node next;
		protected Object data;
		
		//constructor
		Node() {
			this.next = null;
			this.data = 0;
		}
		
		Node(Object data) {
			this.next = null;
			this.data = data;
		}
		
		Node(Node next, Object data) {
			this.next = next;
			this.data = data;
		}
	}
	
	Node head;
	Node tail;
	int size;
	int count;
	
	LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.count = 0;
	}
	
	//Push() for Stack -> LIFO -> Add on Head of List/Top of the Stack
	void push(Object data){
		Node nNode = new Node(data);
		Node ptr = head;
		
		if(ptr == null){
			head = nNode;
			tail = head;
			size++;
			return;
		}
		
		nNode.next = ptr;
		head = nNode;
		size++;
	}
	
	//Pop() for Stack -> LIFO -> Remove from Head of List/Top of Stack
	Node pop(){
		Node ptr = head;
		Node element = new Node();
		if(ptr == null){
			System.out.println("No Elements Present!!");
			return ptr;
		}
		
		if(ptr == head && ptr == tail){
			System.out.println("Last Element Poped\n");
			head = null;
			tail = null;
			size--;
			System.out.println("Poped Element -> " + ptr.data + "\n");
			return ptr;
		}
		if(ptr != null){
			element = ptr; // --> for returning the Node
			
			head = ptr.next;
			ptr = null;
			size--;
		}
		System.out.println("Poped Element -> " + element.data + "\n");
		return element;
			
	}
	
	//EnQueue() for Queues -> FIFO -> Add at the Head/Rear of the Queue
	void enQueue(Object data){
		Node nNode = new Node(data);
		Node ptr = head;
		
		if(ptr == null){
			head = nNode;
			tail = head;
			size++;
			return;
		}
		
		//adding at the head of the Queue
		nNode.next = ptr;
		head = nNode;
		size++;
	}
	
	//DeQueue() for Queues -> FIFO -> Remove from the Tail/Front of the Queue
	Node deQueue(){
		Node ptr = head;
		Node prv = new Node();
		Node element = new Node();
		
		if(ptr == null){
			System.out.println("No Elements in Queue!!\n");
			return ptr;
		}
		
		if(ptr == head && ptr == tail){
			System.out.println("Last Element Dequed\n");
			head = null;
			tail = null;
			size--;
			System.out.println("Element DeQued -> " + ptr.data + "\n");
			return ptr;
		}
		
		while(ptr.next != null){
			prv = ptr;
			ptr = ptr.next;
		}
		element = ptr; // --> for returning the Node
		
		prv.next = ptr.next;
		ptr = null;
		tail = prv;
		size--;
		
		System.out.println("DeQued Element -> " + element.data + "\n");
		return element;
	}
	
	//Append() integers at the end of the LinkedList
	void append(Node node, Object data){
		Node nNode = new Node(data);
		Node ptr = node;
		if(ptr == null){
			ptr = nNode;
			head = ptr;
			tail = head;
			size++;
			return;
		}
		
		tail.next = nNode;
		tail = nNode;
		size++;
	}
	
	//checks if LinkedList is Palindrome
	boolean isPalindrome(Node node){
		boolean result = false;
		Node ptr = node;
		Node secondHalf = null;
		Node middle = null;
		Node fastPtr = head;
		Node slowPtr = head;
		Node prevOfMiddle = null;
		if(ptr != null && ptr.next != null){
			
			//mid node ->  
			//fastPtr == NULL when EVEN elements,
			//fastPtr != NULL && fastPtr.next == NULL when ODD elements
			while(fastPtr != null && fastPtr.next != null){
				fastPtr = fastPtr.next.next;
				prevOfMiddle = slowPtr;// for dividing the list into 2 individual list
				slowPtr = slowPtr.next;
			}
			//fastPtr == NULL when EVEN elements,
			//when number of elements are EVEN in List
			if(fastPtr == null){
				middle = slowPtr;
				secondHalf = middle;
				prevOfMiddle.next = null;
				System.out.println("EVEN Prev Of Middle -> " + prevOfMiddle.data);
				System.out.println("EVEN Middle -> " + middle.data);
				System.out.println("EVEN Second Half -> " + secondHalf.data);
			}
			//fastPtr != NULL && fastPtr.next == NULL when ODD elements
			//when number of elements are ODD in List
			if(fastPtr != null){
				middle = slowPtr;
				secondHalf = middle.next;
				middle.next = null;
				prevOfMiddle.next = null;
				System.out.println("ODD Prev Of Middle -> " + prevOfMiddle.data);
				System.out.println("ODD Middle -> " + middle.data);
				System.out.println("ODD Second Half -> " + secondHalf.data);
			}
			
			//reverse secondHalf
			Node prev = null;
			Node current = secondHalf;
			Node next = null;
			
			while(current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			secondHalf = prev;
			//printChList(secondHalf);
			result = compareList(ptr, secondHalf);
			System.out.println("Result isPalindrome -> " + result);
		}		
		return result;
	}
	
	//Compare 2 List for same characters in Palindrome
	boolean compareList(Node node, Node secondHalf){
		Node ptr1 = node, ptr2 = secondHalf;
		
		while(ptr1 != null && ptr2 != null){
			if(ptr1.data == ptr2.data){
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;	
			}
			else
				return false;
		}
		
		//Both will be Null when Palindrome
		if(ptr1 == null && ptr2 == null)
			return true;
		
		return false;
	}
	
	//Insert After given Index
	void insertAfter(int index, Object data){
		Node nNode = new Node(data);
		Node ptr = head;
		Node prev = new Node();
		
		if(ptr == null){
			System.out.println("No Nodes to Insert After!!");
			return;
		}
		
		for(int i=1; ptr != null && i<=index; i++){
			
			prev = ptr; //--> Current Element at given Index
			ptr = ptr.next; //--> Element after the given Index
		}
		if(ptr == null || index == 0){
			System.out.println("Index Out of Bounds");
			return;
		}
		nNode.next = prev.next;
		prev.next = nNode;
		
		if(prev == tail)
			tail = nNode;
		
		size++;
	}
	
	void deleteElement(Object data){
		Node ptr = head;
		Node prev = new Node();
		
		if(ptr.data == data){
			ptr = ptr.next;
			head = ptr;
			size--;
			return;
		}
		
		while(ptr.data != data && ptr.next != null){
			prev = ptr;
			ptr = ptr.next;
		}
		
		if(ptr.next == null){
			prev.next = ptr.next;
			ptr = null;
			tail = prev;
			size--;
			return;
		}
		
		if(ptr.next != null){
			prev.next = ptr.next;
			ptr.next = null;
			ptr = null;
			size--;
			return;
		}
	}
	
	void deleteAtPosition(int index){
		Node prev = new Node();
		Node ptr = head;
		
		if(index == 0){
			System.out.println("Index Out of Bound!!");
			return;
		}
		
		if(ptr == null){
			System.out.println("No Elements to Delete!!");
			return;
		}
		
		if(index == 1){
			ptr = ptr.next;
			head = ptr;
			size--;
			return;
		}
		
		for(int i=1; i<index && ptr.next != null; i++){
			prev = ptr; // --> Previous Element before Index
			ptr = ptr.next; // --> Element to be Deleted at given Index
		}
		
		if(ptr.next == null){
			prev.next = ptr.next;
			ptr = null;
			tail = prev;
			size--;
			return;
		}
		if(ptr.next != null){
			prev.next = ptr.next;
			ptr.next = null;
			ptr = null;
			size--;
			return;
		}
	}
	
	//delete Even Elements from the list
	void deleteEven(Node node){
		Node ptr = node;
		Node prev = new Node();
		
		while(ptr != null){
			//check for Even Element
			if((Integer)ptr.data % 2 == 0){
				
				//Base Case1: if element is at head
				if(ptr == head){
					Node temp = ptr.next;
					ptr = ptr.next;
					head = temp;
					temp = null;
					size--;
				}
				
				//Base Case2: if element is at tail
				else if(ptr.next == null){
					Node temp = ptr;
					ptr = ptr.next;
					prev.next = temp.next;
					temp = null;
					tail = prev;
					size--;
				}
				
				//If element is in between
				else{
					Node temp = ptr;
					ptr = ptr.next;
					prev.next = temp.next;
					temp.next = null;
					temp = null;
					size--;
				}
			}
			else{
				prev = ptr;
				ptr = ptr.next;
			}
		}
		return;
	}
	
	// Search an Element using given Key
	boolean search(Object data){
		Node ptr = head;
		int index = 1;
		if(ptr == null){
			System.out.println("List Empty!!");
			return false;
		}
		
		while(ptr != null){
			if(ptr.data == data){
				System.out.println("Element Found at Index -> " + index);
				index++;
				return true;
			}
			ptr = ptr.next;
			index++;
		}
		System.out.println("Element not Present!!");
		return false;
	}
	
	//get the Nth Node Value
	Node getNth(int index){
		Node ptr = head;
		int i;
		if(ptr == null){
			System.out.println("No Elements Present!!");
			return ptr;
		}
		for(i=1; ptr != null && i<=index; i++){
			if(i == index){
				System.out.println("Element at Node " + i + " -> " + ptr.data);
				return ptr;
			}
			ptr = ptr.next;
		}
		//check for null and 0
		if(ptr == null || index < 1){
			System.out.println("Index Out of Bound!!");
		}
		return null;
	}
	
	//get the mid element of the List using count MOD 2
	/*void midElement(){
		Node midPtr = head;
		int count = 0;
		Node ptr = head;
		while(ptr != null){
			if(count % 2 == 1)
				midPtr = midPtr.next;
			++count;
			ptr = ptr.next;
		}
		if(midPtr != null)
			System.out.println("Mid Element -> " + midPtr.data);
	}*/
	
	//get the mid Element using 2 Pointers
	Node midElement(Node ptr){
		Node slowPtr = ptr;
		Node fastPtr = ptr;
		if(ptr == null || ptr.next == null){
			System.out.println("Too Less Elements");
			return ptr;
		}
		while(fastPtr != null && fastPtr.next != null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		return slowPtr;
	}
	
	//count the occurrences of given key Iteratively
	/*int countElement(Node node, int element){
		int count = 0;
		Node ptr = node;
		
		while(ptr != null) {
			if(ptr.data == element)
				count++;
			ptr = ptr.next;
		}
		return count;
	}*/
	
	//count the occurrences of given key Recursively
	int countElement(Node node, Object element){
		if(node == null){
			return count;
		}
		if(node.data == element)
			count++;
		return countElement(node.next, element);
	}
	
	//Detect Loop in a LinkedList using Hashing
	boolean detectLoop(Node node){
		Node ptr = node;
		HashSet<Node> set = new HashSet<Node>();
		
		while(ptr != null){
			if(set.contains(ptr)){
				System.out.println("Loop Found\n");
				return true;
			}
			set.add(ptr);
			ptr = ptr.next;
		}
		System.out.println("No Loop Found\n");
		return false;
	}
	
	// Calculate the length of the Loop
	int loopLength(Node node){
		Node slowPtr = node;
		Node fastPtr = node;
		
		while(slowPtr != null && fastPtr != null && fastPtr.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr){
				return countLength(slowPtr);
			}
		}
		return 0;
	}
	// this function calculates the number of nodes in loop
	int countLength(Node ptr){
		int length = 1;
		Node temp = ptr;
		while(temp.next != ptr){
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	// reverse a linked list iteratively
	void reverse(Node node){
		Node current = node; // head
		Node prev = null;
		Node next = null;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		printList(node);
	}
	
	// reverse a linked list Recursively
	Node reverseRecursive(Node current, Node prev){
		if(current.next == null){
			tail = head;
			head = current;
			current.next = prev;
			return head;
		}
		
		Node next = current.next;
		current.next = prev;
		reverseRecursive(next, current);
		return head;
	}
	
	//merge() for sorting and merging the 2 halves
	Node merge(Node l, Node r){
		Node node = new Node();
		if(l == null)
			return r;
		if(r == null)
			return l;
		if((Integer)l.data <= (Integer)r.data){
			node = l;
			node.next = merge(l.next, r);
		}
		else{
			node = r;
			node.next = merge(l, r.next);
		}
		return node;
	}
	
	//Recursive() for MergeSort
	Node mergeSort(Node ptr){
		if(ptr == null || ptr.next == null){
			return ptr;
		}
		Node mid = getMiddle(ptr);
		Node nextOfMid = mid.next;
		mid.next = null;
		
		Node left = mergeSort(ptr);
		Node right = mergeSort(nextOfMid);
		Node sortedMerge = merge(left, right);
		
		return sortedMerge;
	}
	
	//get the Middle Element for MergeSort
	Node getMiddle(Node ptr){
		if(ptr == null){
			System.out.println("Too Less Elements");
			return ptr;
		}
		Node fastPtr = ptr.next;
		Node slowPtr = ptr;
		
		while(fastPtr != null && fastPtr.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	//Display List
	void printList(Node node){
		Node ptr = node;
		System.out.println("\nLinkedList");
		
		if(ptr == null){
			System.out.println("No Elements present!!\n");
			return;
		}
		
		while(ptr != null){
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
		System.out.println("\n");
		System.out.println("List SIZE -> " + getSize());
		System.out.println("HEAD -> " + head.data);
		System.out.println("TAIL -> " + tail.data + "\n");
		System.out.println("----------------------------");
	}
	
	int getSize(){
		return size;
	}
}

