package queue;

import java.lang.reflect.Array;

public class CircularArrayQueue<T> implements QueueInterface<T> {
	private final int DEFAULT_CAPACITY = 50;
	private final int MAX_CAPACITY = 50;
	private boolean integrityOK;
	private T[] array;
	private int numberOfEntries;
	private int frontIndex;
	private int backIndex;
	
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue() {
		this.array = (T[]) Array.newInstance(Object.class, DEFAULT_CAPACITY);
		numberOfEntries = 0;
		frontIndex = 0;
		backIndex = array.length;
		integrityOK = true;

	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity) {
		
		if (capacity < MAX_CAPACITY) {
			this.array = (T[]) Array.newInstance(Object.class, capacity);
			frontIndex = 0;
			backIndex = array.length;
			numberOfEntries = 0;
			integrityOK = true;
			
		}else
			throw new IllegalStateException("Attempt to create a bag whose " +
					"capacity exceeds allowed maximum.");
	}

	@Override
	public boolean enqueue(T data) {
		checkIntegrity();
		if(frontIndex == backIndex) {
			throw new RuntimeException("queue is full :'(");
		}
		backIndex = (backIndex + 1) % array.length;
		array[backIndex] = data;
		numberOfEntries++;
		return true;
	}

	@Override
	public T dequeue() {
		checkIntegrity();
		if (!isEmpty()) {
			T temp = array[frontIndex];
			array[frontIndex] = null;
			frontIndex = (frontIndex + 1) % array.length;
			numberOfEntries--;
			return temp;
		}else
			return null;
	}

	@Override
	public T getFront() {
		checkIntegrity();
		return array[frontIndex];
	}

	@Override
	public boolean isEmpty() {
		checkIntegrity();
		return numberOfEntries == 0;
	}

	@Override
	public void clear() {
		checkIntegrity();
		while(isEmpty()) {
			dequeue();
		}
		
	}

	@Override
	public T[] toArray() {
		checkIntegrity();
		// TODO Auto-generated method stub
		return null;
	}
	
	private void checkIntegrity() {
		if(!integrityOK) {
			throw new SecurityException("ArrayBag Object is corrupt");
		}
	}

}
