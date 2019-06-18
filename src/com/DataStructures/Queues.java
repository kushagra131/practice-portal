package com.DataStructures;

import java.util.HashMap;
import java.util.Map;
import com.DataStructures.DLLQueue.Node;

public class Queues {
	
	public static void main(String[] args){
		LRUCache lru = new LRUCache(5);
		String pageString = "";
		lru.refer(2);
		lru.refer(1);
		lru.refer(3);
		lru.refer(4);
		lru.refer(5);
		lru.refer(6);
		lru.queue.printQueue();
		lru.refer(1);
		lru.queue.printQueue();
		lru.refer(1);
		lru.queue.printQueue();
		lru.refer(3);
		lru.queue.printQueue();
		lru.refer(6);
		lru.queue.printQueue();
		System.out.println("Total Page FAULTS -> " + lru.getPageFault());
		System.out.println("Total Page HITS -> " + lru.getPageHit());
	}
}

//LRU Cache implementation using Queue and HashMap
class LRUCache {
	
	private Map<Object, Node> map;
	public DLLQueue queue;
	private final int cacheSize;
	private static int pageFault;
	private static int pageHit;
	
	public int getPageFault(){
		return pageFault;
	}
	
	public int getPageHit(){
		return pageHit;
	}
	
	public LRUCache(int cacheSize){
		this.cacheSize = cacheSize;
		map = new HashMap<Object, Node>();
		queue = new DLLQueue();
	}
	
	void refer(int pageNumber){
		
		//if page is not in cache memory
		if(!map.containsKey(pageNumber)){
			//queue size == cache memory, then remove Page from Rear
			if(queue.size == cacheSize){
				System.out.println("\nCache Memory Full!!");
				queue.printQueue();
				
				Node rearNode = queue.remove();
				System.out.println("Page FAULT, Node removed -> " + rearNode.element);
				map.remove(rearNode.element);
			}
			//when queue size < cache memory, then insert the page at Front
			queue.insert(pageNumber);
			pageFault++;
			map.put(pageNumber, queue.front);
			//System.out.println("MAP -> " + map.toString());
		}
		//if HIT occurs, means Page is in Cache Memory, then remove the page from queue
		// and cache memory, bring the new one at Front
		else{
			System.out.println("Page HIT occurred -> " + map.containsKey(pageNumber));
			Node hitNode = map.get(pageNumber);
			pageHit++;
			System.out.println("Page HIT, Node -> " + hitNode.element.toString());
			queue.moveNodeToHead(hitNode);
		}
	}
}

class DLLQueue {

	class Node{
		Object element;
		Node next;
		Node prev;
		
		Node(){
			this.element = null;
			this.next = null;
			this.prev = null;
		}
		
		Node(Object element){
			this.element = element;
			this.next = null;
			this.prev = null;
		}
		
		/*Node(Object element, Node next, Node prev){
			this.element = element;
			this.next = next;
			this.prev = prev;
		}*/
	}
	
	Node front;
	Node rear;
	int size = 0;
	
	//insert at Front
	void insert(Object element){
		Node nNode = new Node(element);
		Node ptr = front;
		
		//Base case when list empty
		if(ptr == null){
			ptr = nNode;
			front = rear = ptr;
			size++;
			System.out.println("Page enqueued -> " + front.element.toString());
			return;
		}
		
		//Insert at front
		if(ptr != null){
			nNode.next = front;
			front.prev = nNode;
			front = nNode;
			size++;
			System.out.println("Page enqueued -> " + front.element.toString());
		}
		return;
	}
	
	//remove from Rear
	Node remove(){
		Node nRear = new Node();
		Node ptr = front;
		
		//if only 1 element is present
		if(ptr == front && ptr == rear){
			front = null;
			rear = null;
			System.out.println("Page Dequeued -> " + ptr.element.toString());
			size--;
			return ptr;
		}
		
		//more than 1 element present
		if(ptr != null && ptr != rear){
			Node temp = rear;
			nRear = rear.prev;
			temp.prev = null;
			nRear.next = null;
			rear = nRear;
			System.out.println("Page Dequeued -> " + temp.element.toString());
			size--;
			return temp;
		}
		
		//if list is empty
		else{
			System.out.println("Queue Empty!!");
		}
		return null;
	}
	
	//move HIT Node to head/front
	void moveNodeToHead(Node hitNode){
		Node ptr = front;
		Node prevNode = new Node();
		Node nextNode = new Node();
		
		if(ptr == hitNode){
			System.out.println("Page HIT Node already at Front!!");
			return;
		}
		
		if(ptr != hitNode){
			while(ptr != hitNode){
				ptr = ptr.next;
			}
			//check if ptr is at Rear
			if(ptr != null && ptr.next == null){
				prevNode = ptr.prev;
				prevNode.next = ptr.next;
				ptr.prev = null;
			}
			else{
				prevNode = ptr.prev;
				nextNode = ptr.next;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				ptr.next = null;
				ptr.prev = null;
			}
			//update Front/Head
			front.prev = ptr;
			ptr.next = front;
			front = ptr;
		}
		return;
	}
	
	//returns the size of the list
	int size(){
		return this.size;
	}
	
	void printQueue(){
		Node ptr = front;
		while(ptr != null){
			System.out.print(ptr.element.toString() + " <-> ");
			ptr = ptr.next;
		}
		System.out.println("\n");
	}
}
