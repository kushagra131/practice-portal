package com.DataStructures;

import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;

//User Built Stack Class
public class Stacks<T> {
	int top = 0;

	private void push(int data){

	}
	
	private void pop(){

	}
	
	private boolean isEmpty(Stack<T> stack){
		return (stack.isEmpty()) ? true : false;
	}
	
	private void peek(Stack<T> stack){

	}
	
	public static void main(String[] args){
		/* stack_peek(stack);
		stack_push(stack, 10);
		stack_push(stack, 20);
		stack_push(stack, 80);
		stack_push(stack, 70);
		stack_push(stack, 60);
		stack_push(stack, 90);
		stack_peek(stack);
		//stack_pop(stack);
		stack_peek(stack);
		stack_search(stack, 10);
		*/
		
		/*QueueUsingStack queueObj = new QueueUsingStack();
		queueObj.stack1 = new Stack<Integer>();
		queueObj.stack2 = new Stack<Integer>();
		
		queueObj.enqueue(queueObj, 1);
		queueObj.enqueue(queueObj, 4);
		queueObj.enqueue(queueObj, 5);
		queueObj.enqueue(queueObj, 2);
		queueObj.enqueue(queueObj, 3);
		queueObj.enqueue(queueObj, 10);
		queueObj.dequeue(queueObj);
		queueObj.dequeue(queueObj);
		queueObj.dequeue(queueObj);
		queueObj.dequeue(queueObj);
		queueObj.dequeue(queueObj);
		queueObj.dequeue(queueObj);
		queueObj.dequeue(queueObj);*/
		
		/*StackUsingQueue stackObj = new StackUsingQueue();
		stackObj.queue1 = new LinkedList<Integer>();
		stackObj.queue2 = new LinkedList<Integer>();
		
		stackObj.push(stackObj, 10);
		stackObj.push(stackObj, 20);
		stackObj.push(stackObj, 30);
		stackObj.push(stackObj, 40);
		stackObj.push(stackObj, 50);
		stackObj.push(stackObj, 60);
		stackObj.push(stackObj, 70);
		stackObj.pop(stackObj);
		stackObj.pop(stackObj);
		stackObj.pop(stackObj);
		stackObj.pop(stackObj);
		stackObj.pop(stackObj);
		stackObj.pop(stackObj);
		stackObj.pop(stackObj);
		stackObj.pop(stackObj);*/
		
		/*TwoStacks twoStacksObj = new TwoStacks(10);
		twoStacksObj.push1(1);
		twoStacksObj.push1(2);
		twoStacksObj.push1(3);
		twoStacksObj.push1(4);
		twoStacksObj.push1(5);
		twoStacksObj.push2(1);
		twoStacksObj.push2(10);
		twoStacksObj.push1(8);
		twoStacksObj.push2(100);
		twoStacksObj.push2(100);
		twoStacksObj.push2(100);
		twoStacksObj.pop2();
		twoStacksObj.pop1();
		twoStacksObj.pop1();
		twoStacksObj.pop1();
		twoStacksObj.pop1();
		twoStacksObj.pop1();
		twoStacksObj.pop1();
		System.out.println("Poped Array -> " + Arrays.toString(twoStacksObj.array));*/
		
		/*
		String str = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Infix Expression -> " + str);
		System.out.println("PostFix -> " + InfixToPostfix.infixToPostfix(str));
		*/
		
		String str = "*-A/BC-/AKL";
		System.out.println("Prefix Expression -> " + str);
		System.out.println("InFix -> " + PrefixToInfix.prefixToInfix(str));
		
		
 	}
}

//Implementing Queues using 2 Stacks
class QueueUsingStack{
	
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	static void stack_push(Stack<Integer> top, int element){
		top.push(element);
	}
	
	static int stack_pop(Stack<Integer> top){
		if(top.isEmpty()){
			System.out.println("Stack Underflow!!");
			System.exit(0);
		}
		int topElement = top.pop();
		return topElement;
	}
	
	void enqueue(QueueUsingStack queue, int data){
		stack_push(queue.stack1, data);
	}
	
	int dequeue(QueueUsingStack queue){
		int front;
		int top1;
		if(queue.stack1.isEmpty() && queue.stack2.isEmpty()){
			System.out.println("Queue Empty!!");
			System.exit(0);
		}
		
		if(queue.stack2.isEmpty()){
			while(!queue.stack1.isEmpty()){
				top1 = stack_pop(queue.stack1);
				stack_push(queue.stack2, top1);
			}
		}
		front = stack_pop(queue.stack2);
		System.out.println("DeQueued Element: " + front);
		return front;
	}
	
}

//Implementing Stacks using 2 Queues
class StackUsingQueue{
	
	Queue<Integer> queue1;
	Queue<Integer> queue2;
	static int size;
	
	static void queue_enqueue(Queue<Integer> front, int element){
		front.offer(element);
		size++;
	}
	
	static int queue_dequeue(Queue<Integer> front){
		if(front.isEmpty()){
			System.out.println("Queue Empty!!");
			System.exit(0);
		}
		int frontElement = front.poll();
		//System.out.println("Element Dequeued -> " + frontElement);
		size--;
		return frontElement;
	}
	
	void push(StackUsingQueue stackObj, int element){
		queue_enqueue(queue1, element);
		System.out.println("Pushed Element -> " + element);
	}
	
	void pop(StackUsingQueue stackObj){
		int topElement = 0;
		if(stackObj.queue1.isEmpty()){
			System.out.println("Queue Empty!!");
			return;
		}
		while(queue1.size() != 1){
			int front = queue_dequeue(stackObj.queue1);
			queue_enqueue(stackObj.queue2, front);
		}
		
		topElement = stackObj.queue1.poll();
		System.out.println("Poped Element -> " + topElement);
		
		stackObj.queue1.poll();
			
		Queue<Integer> temp = queue1;
		queue1 = queue2;
		queue2 = temp;
		
		return;
	}
}

//Implementing 2 Stacks using Array
class TwoStacks{
	
	int top1, top2;
	int size;
	int[] array;
	
	TwoStacks(int size){
		this.size = size;
		array = new int[size];
		System.out.println("Initializing Array -> " + Arrays.toString(array));
		top1 = -1;
		top2 = size;
	}
	
	//Push Element to Stack1, in Array[0] to Array[n/2]
	void push1(int element){
		if(top1 < top2 - 1){
			top1++;
			System.out.println("Top1 -> " + top1);
			array[top1] = element;
			System.out.println("Element Pushed to Stack1");
		}
		else{
			System.out.println("Stack1 Overflow!!");
		}
		return;
	}
	
	//Push Element to Stack2, in Array[n-1] to Array[n/2 + 1]
	void push2(int element){
		if(top1 < top2 - 1){
			top2--;
			System.out.println("Top2 -> " + top2);
			array[top2] = element;
			System.out.println("Element Pushed to Stack2");
		}
		else{
			System.out.println("Stack2 Overflow!!");
		}
		return;
	}
	
	//Pop from Stack1, from Array[n/2] to Array[0]
	int pop1(){
		if(top1 >= 0){
			int element = array[top1];
			top1--;
			System.out.println("Element Poped from Stack1 -> " + element);
			return element;
		}
		else{
			System.out.println("Stack UnderFlow!!");
		}
		return -1;
	}
	
	//Pop from Stack2, from Array[n/2 + 1] to Array[n-1]
	int pop2(){
		if(top2 < size){
			int element = array[top2];
			top2++;
			System.out.println("Element Poped from Stack2 -> " + element);
			return element;
		}
		else{
			System.out.println("Stack UnderFlow!!");
		}
		return -1;
	}
}


class InfixToPostfix{
	
	//utility func for Precendence Check of operators
	static int precCheck(char ch){
		switch(ch){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
		}
		return -1;
	}
	
	static String infixToPostfix(String exp){
		//empty String to store postfix exp
		String result = "";
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < exp.length(); i++){
			
			char ch = exp.charAt(i);
			System.out.println("\nch -> " + ch + "    at    i = "+ i);
			
			//check for letter or digits first, add to result
			if(Character.isLetterOrDigit(ch)){
				result = result + ch;
				System.out.println("Add Letter/Digit to Result -> " + result.toString());
			}
			//check for '(', store it in stack
			else if(ch == '('){
				stack.push(ch);
				System.out.println("if '(' Stack Push -> " + stack.toString());
			}
			//check for ')', pop and add to result until '('
			else if(ch == ')'){
				
				while(!stack.isEmpty() && stack.peek() != '('){
					result = result + stack.pop();
					System.out.println("Stack Pop & add to Result -> " + result.toString());
				}
				if(!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Exp";
				else{
					System.out.println("Stack Pop");
					stack.pop();
				}
			}
			//if operator is encountered, check precendence, pop and add to result
			else{
				while(!stack.isEmpty() && precCheck(ch) <= precCheck(stack.peek())){
					result = result + stack.pop();
					System.out.println("Add Stack top operator to Result -> " + result.toString());
				}
				stack.push(ch);
				System.out.println("Stack Push -> " + stack.toString());
			}
		}
		//pop and add remaining characters in result
		while(!stack.isEmpty()){
			result = result + stack.pop();
			System.out.println("Add Remaining to Result -> " + result.toString());
		}
		return result;
	}
}


class PrefixToInfix{
	
	//utility() to check precedence of operators
	static boolean isOperator(char ch){
		switch(ch){
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return true;
		}
		return false;
	}
	
	static String prefixToInfix(String exp){
		Stack<String> stack = new Stack<String>();
		int length = exp.length();
		
		//read the expression from right to left
		for(int i = length - 1; i >= 0; i--){
			char ch = exp.charAt(i);
			System.out.println("\nStack -> " + stack.toString());
			System.out.println("ch -> " + ch + "     at    i = " + i);
			
			//if symbol == operator, then pop 2 operands from Stack
			if(isOperator(ch)){
				StringBuilder operand1 = new StringBuilder(stack.pop());
				StringBuilder operand2 = new StringBuilder(stack.pop());
				System.out.println("Operand1 -> " + operand1.toString());
				System.out.println("Operand2 -> " + operand2.toString());
				
				//concat a string with "(operand1 + operator + operand2)"
				StringBuilder concatStr = new StringBuilder("(" + operand1 + ch + operand2 + ")");
				System.out.println("concatStr -> " + concatStr);
				System.out.println("Push concatStr onto Stack -> " + concatStr.toString());
				
				//push the concatenated string onto Stack
				stack.push(concatStr.toString());
			}
			//if symbol == operand, then push it onto the Stack
			else{
				StringBuilder chStr = new StringBuilder(String.valueOf(ch));
				System.out.println("Push chStr to Stack -> " + chStr.toString());
				
				stack.push(chStr.toString());
			}
		}
		
		return stack.peek();
	}
}


