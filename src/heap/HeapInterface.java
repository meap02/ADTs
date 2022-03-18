package heap;


public interface HeapInterface<T extends Comparable<? super T>> {
	
	public void add(T newEntry);
	
	public boolean isEmpty();
	
	public int getSize();
	
	public void clear();
}
