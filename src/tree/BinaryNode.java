package tree;
//
// Name: Just, Kyle
// Project: #4
// Due: 04/29/21
// Course: cs-2400-03-sp21
//
// Description:
// 	Used as the building block for all the binary trees, holds data, a left node and a right node
//

public class BinaryNode<T> {
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	
	BinaryNode() {
		this(null);
	}
	
	BinaryNode(T dataPortion) {
		this(dataPortion, null, null);
	}
	
	BinaryNode(T dataPortion, BinaryNode<T> leftChild,
			  				  BinaryNode<T> rightChild) {
		this.data = dataPortion;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		if(leftChild != null)
			leftNumber = leftChild.getNumberOfNodes();
		if(rightChild != null)
			rightNumber = rightChild.getNumberOfNodes();
		return 1 + leftNumber + rightNumber;
	}
	
	public int getHeight() {
		return getHeight(this); //Call a private getHeight();
	}
	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		
		if(node != null) {
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
		return height;
	}
	
	public BinaryNode<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<>(data);
		if(leftChild != null)
			newRoot.setLeftChild(leftChild.copy());
		if(rightChild != null)
			newRoot.setRightChild(rightChild.copy());
		return newRoot;
	}
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryNode<T> rightChild) {
		this.rightChild = rightChild;
	}
}//END OF CLASS
