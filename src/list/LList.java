package list;


import java.lang.reflect.Array;
import java.util.Iterator;

import stack.ArrayStack;
import stack.StackInterface;


public class LList<T> implements ListInterface<T> {
	
	private Node head;
	private int numOfEntries;

	public LList() {
		initializeDataFields();
	}

	@Override
	public boolean add(T data) {
		try {
			Node newNode = new Node(data, head);
			head = newNode;
			numOfEntries++;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void add(int index, T data) {
		if(index <= numOfEntries) {
			Node prevNode = getNodeAt(index);
			Node nextNode = getNodeAt(index -1);
			Node newNode = new Node(data,nextNode);
			prevNode.setNext(newNode);
			numOfEntries++;
		}else
			add(data);
		
	}

	@Override
	public T remove(int index) {
		if (index <= numOfEntries) {
			Node currentNode = head;
			Node last = null;
			for (int i = numOfEntries; i > index; i--) {
				last= currentNode;
				currentNode = currentNode.getNext();
			}
			T temp = currentNode.getData();
			try {
				last.setNext(currentNode.getNext());
			}catch(Exception e) {
				//Will not mind if last is still null
			}
			currentNode.setData(null);
			currentNode.setNext(null);
			return temp;
		}else
			return null;
	}

	@Override
	public boolean remove(T data) {
		Node currentNode = head;
		boolean found = false;
		while(!found && currentNode != null) {
			if(currentNode.getData().equals(data)) {
				found = true;
				currentNode.setData(head.getData());
				head = head.getNext();
				numOfEntries--;
			}else
				currentNode = currentNode.getNext();
		}
		if(!found)
			throw new RuntimeException("The entry " + data + " does not exist");
		else
			return found;
	}

	@Override
	public T set(int index, T newData) {
		return null;
	}

	@Override
	public T get(int index) {
		return getNodeAt(index).getData();
	}

	@Override
	public boolean contains(T anEntry) {
		Node currentNode = head;
		boolean found = false;
		while(!found && currentNode != null) {
			if(currentNode.getData() == anEntry)
				found = true;
			else
				currentNode = currentNode.getNext();
		}
		return found;
	}

	@Override
	public int size() {
		return numOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numOfEntries == 0;
	}
	
	@Override
	public void clear() {
		initializeDataFields();
	}
	
	public Iterator<T> getLinkedListIterator() {
		return new LinkedListIterator();
	}
	
	private Node getNodeAt(int index) {
		if (index <= numOfEntries) {
			Node currentNode = head;
			for (int i = numOfEntries; i > index; i--) {
				currentNode = currentNode.getNext();
			}
			return currentNode;
		}else
			throw new RuntimeException("Index requested does not exist");
	}
	
	private void initializeDataFields() {
		head = null;
		numOfEntries = 0;
	}
	
	@Override
	public String toString() {
		String temp = "";
		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(Object.class, numOfEntries);
		Node currentNode = head;
		for(int i = numOfEntries - 1; i >= 0; i--) {
			array[i] = currentNode.getData();
			currentNode = currentNode.getNext();
		}
		for(T element: array) {
			temp = temp.concat(element.toString() + " ");
		}
		return temp;
	}
	
	public void display() {
		System.out.println(display(head));
	}
	
	private Node display(Node node) {
		if(node == null) {
			return null;
		}else {
			return display(node.getNext());
		}
	}
	
	private class LinkedListIterator implements Iterator<T> {
		
		Node currentNode;
		StackInterface<Node> stack;
		
		private LinkedListIterator() {
			currentNode = head;
			stack = new ArrayStack<>(numOfEntries);
			while(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getNext();
			}
		}
		
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			return stack.pop().getData();
		}
		
	}

	private class Node {
		Node next;
		T data;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}

		@SuppressWarnings("unused")
		public Node(T data) {
			this(data, null);
		}
		
		public Node getNext() {
			return next;
		}

		public T getData() {
			return data;
		}
		
		@SuppressWarnings("unused")
		public void setData(T data) {
			this.data = data;
		}
	}//END OF NODE
}//END OF LList CLASS
