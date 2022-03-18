package stack;

import java.lang.reflect.Array;

public class ArrayStack<T> implements StackInterface<T>{
	
	private final int DEFAULT_SIZE = 20;
	private int numberOfEntries;
	private T[] array;
	
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this.array = (T[]) Array.newInstance(Object.class, DEFAULT_SIZE);
		numberOfEntries = 0;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		this.array = (T[]) Array.newInstance(Object.class, size);
		numberOfEntries = 0;
	}
	
	@Override
	public boolean push(T someValue) {
		if (!(numberOfEntries >= array.length-1)) {
			array[numberOfEntries] = someValue;
			numberOfEntries++;
			return true;
		}else {
			expand();
			push(someValue);
		}
		return false; //Unreachable	
	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			T temp;
			temp = array[numberOfEntries-1];
			array[numberOfEntries-1] = null;
			numberOfEntries--;
			return temp;
		}else
			return null;
	}

	@Override
	public T peek() {
		if (!isEmpty()) {
			return array[numberOfEntries-1];
		}else
			return null;
	}	

	@Override
	public boolean isEmpty() {
		if(numberOfEntries == 0) 
			return true;
		else
			return false;
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			pop();
		}
	}
	
	private void expand() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) Array.newInstance(Object.class, array.length * 2);
		for(int i = 0; i < numberOfEntries; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}
	
	@SuppressWarnings("unused")
	private void expand(int amount) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) Array.newInstance(Object.class, array.length + amount);
		for(int i = 0; i < numberOfEntries; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	
	
	public T[] toArray() {
		return array;
	}
	
	public String toString() {
		String temp = "[";
		for(int i = numberOfEntries -1 ; i > 0 ; i--) {
			temp = temp.concat(String.valueOf(array[i])+",");
		}
		temp = temp.concat(String.valueOf(array[0]) + "]");
		return temp;
	}
	
}//END OF CLASS
