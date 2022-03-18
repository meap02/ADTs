package tree;
//
// Name: Just, Kyle
// Project: #4
// Due: 04/29/21
// Course: cs-2400-03-sp21
//
// Description:
// 	Interface used to define what any tree should be able to do
//

public interface TreeInterface<T> {
	public T getRootData();
	
	public int getHeight();
	
	public int getNumberOfNodes();
	
	public boolean isEmpty();
	
	public void clear();
}
