package tree;
//
// Name: Just, Kyle
// Project: #4
// Due: 04/29/21
// Course: cs-2400-03-sp21
//
// Description:
// 	Interface used to define what a binary tree should be able to do
//

public interface BinaryTreeInterface<T> extends TreeInterface<T>, 
												TreeIteratorInterface<T> {
	/**
	 * Set the root data for this binary tree
	 * @param RootData
	 * The desired data to be set to
	 */
	public void setRootData(T RootData);
	
	/**
	 * This will setup the entire tree
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 */
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
									BinaryTreeInterface<T> rightTree);
}
