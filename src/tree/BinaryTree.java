package tree;
//
// Name: Just, Kyle
// Project: #4
// Due: 04/29/21
// Course: cs-2400-03-sp21
//
// Description:
// 	This defines the Binary tree that will be extended by ExpressionTree.java.
//	Uses BinaryNode<T> to create its tree
//

import java.util.Iterator;
import java.util.NoSuchElementException;

import stack.LinkedStack;
import stack.StackInterface;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
	//////////////////////////////////////////////////////////////////////////////
	//							Fields										   //
	////////////////////////////////////////////////////////////////////////////
	private BinaryNode<T> root;
	
	//////////////////////////////////////////////////////////////////////////////
	//							Constructors								   //
	////////////////////////////////////////////////////////////////////////////
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	//////////////////////////////////////////////////////////////////////////////
	//					Public/Protected Class Methods				 	 	   //
	////////////////////////////////////////////////////////////////////////////

	@Override
	public T getRootData() {
		if(isEmpty()) 
			throw new RuntimeException("Tree is empty");
		else
			return root.getData();
	}

	@Override
	public int getHeight() {
		int height = 0;
		if(root != null)
			height = root.getHeight();
		return height;
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}
	
	@Override
	public void setRootData(T rootData) {
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNode<T> rootNode){
		root = rootNode;
	}
	
	protected BinaryNode<T> getRootNode() {
		return root;
	}

	@Override
	public void setTree(T rootData, 
						BinaryTreeInterface<T> leftTree, 
						BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, 
					  (BinaryTree<T>)leftTree,
					  (BinaryTree<T>)rightTree);
		
	}
	
	//////////////////////////////////////////////////////////////////////////////
	//							Private Methods								   //
	////////////////////////////////////////////////////////////////////////////
	private void initializeTree(T rootData, 
								BinaryTree<T> leftTree, 
								BinaryTree<T> rightTree) {
	
		root = new BinaryNode<>(rootData);
		
		if(leftTree != null && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		
		if(rightTree != null && !rightTree.isEmpty()) {
			if(rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
			}
		if((leftTree != null) && leftTree != this)
			leftTree.clear();
		if((rightTree != null) && (rightTree != this))
			rightTree.clear();
		
	}//END OF initializeTree
	
	//////////////////////////////////////////////////////////////////////////////
	//							Iterators									   //
	////////////////////////////////////////////////////////////////////////////
	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		throw new UnsupportedOperationException();
	}
	
	private class PreorderIterator implements Iterator<T>{
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;
		PreorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		}
		@Override
		public boolean hasNext() {
			return (!nodeStack.isEmpty()) || (currentNode != null);
		}

		@Override
		public T next() {
			BinaryNode<T> temp = null;;
			//First check if there is a left child that will be the next traversal
			if(currentNode.hasLeftChild()) {
				nodeStack.push(currentNode.getRightChild());//save the right child for later
				temp = currentNode;
				currentNode = currentNode.getLeftChild();
			//In the case that there is no left child, check if there is a right one
			}else if(currentNode.hasRightChild()) {
				temp = currentNode;
				currentNode = currentNode.getRightChild();
			//This option means that the node is a leaf and there is nothing below it
			}else if(!nodeStack.isEmpty()) {
				temp = currentNode;
				currentNode = nodeStack.pop(); //so resume at the most recent right child pushed onto the stack
			//If the stack is empty and we must be at a leaf node, that means that this is the end of the traversal
			}else {
				temp = currentNode;
				currentNode = null;//this will let the hasNext() function know that the tree is done
			}
			return temp.getData();
		}
	}//END OF PREORDER ITERATOR CLASS
	
	private class PostorderIterator implements Iterator<T>{
		private StackInterface<BinaryNode<T>> rootStack;
		private StackInterface<BinaryNode<T>> finalStack;
		
		/*
		 * Postorder functions differently tha other traversals becasue it does not follow a tail trend
		 * traversal (also not sure that is the right terminology) but it just has to be implemented
		 * differently
		 */
		PostorderIterator() {
			rootStack = new LinkedStack<>();
			finalStack = new LinkedStack<>();
			rootStack.push(root);
			while(!rootStack.isEmpty()) {
				finalStack.push(rootStack.pop());
				
				if(finalStack.peek().hasLeftChild())
					rootStack.push(finalStack.peek().getLeftChild());
				
				if(finalStack.peek().hasRightChild())
					rootStack.push(finalStack.peek().getRightChild());
			}
		}
		
		@Override
		public boolean hasNext() {
			return !finalStack.isEmpty();
		}

		@Override
		public T next() {
			return finalStack.pop().getData();
		}
	}//END OF POSTORDER ITERATOR
	
	private class InorderIterator implements Iterator<T>{
		
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;
		
		InorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		}

		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}

		@Override
		public T next() {
			BinaryNode<T> nextNode = null;
			//This will navigate to the leftmost leafnode to start at
			while(currentNode != null) {
				nodeStack.push(currentNode); //and will store all nodes passed on the way down
				currentNode = currentNode.getLeftChild();
			}
			
			if(!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();//Will make sure the node will be stored to bve returned 
				currentNode = nextNode.getRightChild();
			}
			else 
				throw new NoSuchElementException();
			
			return nextNode.getData();
		}
	}//END OF INORDER ITERATOR
}//END OF CLASS
