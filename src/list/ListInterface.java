package list;


public interface ListInterface<T> {
	
	public boolean add(T data);
	
	public void add(int index, T data);
	
	public T remove(int index);
	
	public boolean remove(T data);
	
	public T set(int index, T newData);
	
	public T get(int index);
	
	public boolean contains(T anEntry);
	
	public int size();
	
	public boolean isEmpty();
	
	public void clear();
}
