package queue;

public interface QueueInterface<T> {
	
	/**
	 * Add an item to the back of the queue
	 * @param data
	 * @return
	 * 	Whether the operation was succesful or not
	 */
	public boolean enqueue(T data);
	
	/**
	 * Remove an item from the front of the queue,
	 * first in, first out
	 * @return
	 * 	The data stored in the object
	 */
	public T dequeue();
	
	/**
	 * Returns the data at the front of the queue without removing
	 * it like dequeue()
	 * @return
	 * 	The data stored in the object
	 */
	public T getFront();
	
	/**
	 * True if the queue is empty
	 * false if not
	 * 
	 */
	public boolean isEmpty();
	
	/**
	 * Will get the amount of objects in the queue
	 * @return
	 */
	public int getSize();
	
	/**
	 * Wipes the queue of all references
	 */
	public void clear();
	
	/**
	 * transforms the queue into an array
	 * the leftmost being the first in the queue
	 * @return
	 * 	The readable, iteratable array
	 */
	public T[] toArray();
	
	/**
	 * Turns the queue into a printable string
	 * : [A,B,C]
	 * @return
	 * 	The string to represent the queue
	 */
	public String toString();
	
	
}
