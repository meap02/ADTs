package tree;
//
// Name: Just, Kyle
// Project: #4
// Due: 04/29/21
// Course: cs-2400-03-sp21
//
// Description:
// 	Interface used to define what trees should be able to do if I would like to include iterators within it
//

import java.util.Iterator;

public interface TreeIteratorInterface<T> {
	
	public Iterator<T> getPreorderIterator();
	
	public Iterator<T> getPostorderIterator();
	
	public Iterator<T> getInorderIterator();

	public Iterator<T> getLevelOrderIterator();
	
}
