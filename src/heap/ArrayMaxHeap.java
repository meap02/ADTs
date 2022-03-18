package heap;

import java.util.Iterator;

import tree.BinaryTreeInterface;

@SuppressWarnings("unused")
public class ArrayMaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
	
	
	private T[] heap;
	private final static int DEFAULT_CAPACITY = 8;
	private final static int MAX_CAPACITY = 1000;
	private int lastIndex;
	private boolean integrityOK = false;
	
	
	public ArrayMaxHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayMaxHeap(int capacity) {
		if(capacity < MAX_CAPACITY) {
			T[] tempHeap = (T[]) new Comparable[capacity + 1];
			heap = tempHeap;
			integrityOK = true;
			lastIndex = 0;
		}else
			throw new IllegalStateException("Desired capacity is too large");
	}
	
	
	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRootData(T RootData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
