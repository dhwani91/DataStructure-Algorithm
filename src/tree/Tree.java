package tree;

import java.util.Stack;

class Node {
	public int idata;
	public int dData;
	public Node leftChild;
	public Node rightChild;

	public void displayNode() {
		System.out.print(" { ");
		System.out.print(idata);
		System.out.print(",");
		System.out.println(dData);
		System.out.println("} ");
	}

}

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public Node find(int key) {
		Node curr = root;
		while (curr.idata != key) {
			if (key < curr.idata) {
				curr = curr.leftChild;
			} else {
				curr = curr.rightChild;
			}
			if (curr == null) {
				return null;
			}
		}
		return curr;
	}

	public void insert(int id, int key) {
		Node newNode = new Node();
		newNode.idata = id;
		newNode.dData = key;
		if (root == null) {
			root = newNode;
		} else {
			Node curr = root;
			Node parent;
			while (true) {
				parent = curr;
				if (id < curr.idata) {
					curr = curr.leftChild;
					if (curr == null) {
						parent.leftChild = newNode;
						return;
					} else {
						curr = curr.rightChild;
						if (curr == null) {
							parent.rightChild = newNode;
							return;
						}
					}
				}

			}
		}
	}

	public boolean delete(int key) {
		Node parent = root;
		Node curr = root;
		boolean isLeftchild = true;
		while (curr.idata != key) {// search for node
			parent = curr;
			if (key < curr.idata) { // go left
				curr = curr.leftChild;
				isLeftchild = true;
			} else {
				curr = curr.rightChild;// or go right
				isLeftchild = false;
			}
			if (curr == null) {// end of line
				return false; // did't find it
			}
			// found node to delete

		}
		// if no children ,simply delete it
		if (curr.leftChild == null && curr.rightChild == null) {
			if (curr == root) {
				root = null;
			} else if (isLeftchild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}
		// if no right child,replace with left subtree

		else if (curr.rightChild == null) {
			if (curr == root) {
				root = curr.leftChild;
			} else if (isLeftchild) {
				parent.leftChild = curr.leftChild;
			} else {
				parent.rightChild = curr.leftChild;
			}
		}
		// if no left child,replace with right subtree
		else if (curr.leftChild == null) {
			if (curr == root) {
				root = curr.rightChild;
			} else if (isLeftchild) {
				parent.leftChild = curr.rightChild;
			} else {
				parent.rightChild = curr.rightChild;
			}
		} else { // two children,replace with successor
			Node successor = getSuccessor(curr);
			if (curr == root) {
				root = successor;
			} else if (isLeftchild) {
				curr.leftChild = successor;
			} else {
				curr.rightChild = successor;
			}

		}
		return true;
	}
	// return node with next highest vale after delNode
	// goes to right child then right child's left descedants

	Node getSuccessor(Node delNode) {
		Node curr = delNode.rightChild;
		Node successor = delNode;
		Node parentSuccessor = delNode;
		while (curr != null) {
			parentSuccessor = successor;
			successor = curr;
			curr = curr.leftChild;

		}
		if (successor != delNode.rightChild) {
			parentSuccessor.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;

	}

	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.println("preorder traversal");
			preOrder(root);
			break;
		case 2:
			System.out.println("inorder traversal");
			inOrder(root);
			break;
		case 3:
			System.out.println("postOrder traversal");
			postorder(root);
			break;
		}

	}

	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			localRoot.displayNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			localRoot.displayNode();
			inOrder(localRoot.rightChild);
		}
	}

	private void postorder(Node localRoot) {
		if (localRoot != null) {
			postorder(localRoot.leftChild);
			postorder(localRoot.rightChild);
			localRoot.displayNode();
		}
	}
	public void displayTree(){
		Stack globalStack =new Stack<>();
		globalStack.push(root);
		boolean isRowempty=false;
		
	}
	
}
