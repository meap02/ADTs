package heap;

public interface MinHeapInterface<T extends Comparable<? super T>> extends HeapInterface<T> {
	
	public T removeMin();
	
	public T getMin();
}
