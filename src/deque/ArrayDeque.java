package deque;

import java.lang.reflect.Array;

public class ArrayDeque<T> implements DequeInterface<T> {
	
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
	public ArrayDeque() {
		this.array = (T[])Array.newInstance(Object.class, DEAFAULT_CAPACITY);
		integrityOK = true;
		nil = -1;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
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
		
}
	


