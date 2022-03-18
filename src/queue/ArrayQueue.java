package queue;

import java.lang.reflect.Array;

public class ArrayQueue<T> implements QueueInterface<T> {

	private T[] array;
	private final int DEAFAULT_CAPACITY = 30;
	private int nil; //Stands for next in line
	/*
	 * % % % _ _ _ _
	 *     ^
	 *     |
	 *    nil
	 */
	private boolean integrityOK;
	private int MAX_CAPACITY = 1000;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		this.array = (T[])Array.newInstance(Object.class, DEAFAULT_CAPACITY);
		integrityOK = true;
		nil = -1;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		integrityOK = false;
		if (capacity <= MAX_CAPACITY ) {
			//get around the problem of no creation of generic arrays
			this.array = (T[]) Array.newInstance(Object.class, capacity);
			integrityOK = true;
			nil = -1;
		}else
			throw new IllegalStateException("Attempt to create a bag whose " +
											"capacity exceeds allowed maximum.");
	}
	

	@Override
	public boolean enqueue(T data) {
		checkIntegrity();
		nil++;
		array[nil] = data;
		return true;
	}

	@Override
	public T dequeue() {
		checkIntegrity();
		if(!isEmpty()) {
			T temp = array[0];
			for(int i = 0; i < nil; i++) {
				array[i] = array[i+1];
			}
			array[nil+1] = null;
			nil--;
			return temp;
		}else
			return null;
	}

	@Override
	public T getFront() {
		checkIntegrity();
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		checkIntegrity();
		if(nil == -1) 
			return true;
		else
			return false;
	}

	@Override
	public void clear() {
		checkIntegrity();
		
		for(int i = 0; i < nil; i++) {
			array[i] = null;
		}
		nil = -1;
	}
	
	private void checkIntegrity() {
		if(!integrityOK) {
			throw new SecurityException("ArrayBag Object is corrupt");
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) Array.newInstance(Object.class, nil + 1);
		for(int i = 0; i < nil + 1; i++) {
			temp[i] = array[i];
		}
		return temp;
	}
	
	@Override
	public String toString() {
		if(!isEmpty()) {
			String temp = "[";
			T[] cutArray = this.toArray();
			for(int i = 0; i < cutArray.length - 1; i++) {
				temp = temp.concat(String.valueOf(cutArray[i]) + ",");
			}
			temp = temp.concat(String.valueOf(cutArray[cutArray.length -1]) + "]");
			return temp;
		}else
			return "[]";
	}
}//END OF CLASS
