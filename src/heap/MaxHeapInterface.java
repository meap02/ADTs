package heap;

public interface MaxHeapInterface<T extends Comparable<? super T>> extends HeapInterface<T>  {

	public T removeMax();
	
	public T getMax();
}
