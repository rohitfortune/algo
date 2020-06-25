package com.example.tree;

//Java program to connect nodes at same level using extended 
//pre-order traversal 

//A binary tree node 
class NodeNext {
	int data;
	NodeNext left, right, nextRight;

	NodeNext(int item) {
		data = item;
		left = right = nextRight = null;
	}
}

public class ConnectNodesAtSameLevel {
	NodeNext root;

	
	/*
	 * Set next right of all descendents of p. Assumption: p is a binary
	 * tree
	 */
	void connect(NodeNext p) {
		// Base case
		if (p == null)
			return;

		// Set the nextRight pointer for p's left child
		if (p.left != null)
			p.left.nextRight = p.right;

		// Set the nextRight pointer for p's right child
		// p->nextRight will be NULL if p is the right most child
		// at its level
		if (p.right != null)
			p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null;

		// Set nextRight for other nodes in pre order fashion
		connect(p.left);
		connect(p.right);
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		

		/*
		 * Constructed binary tree is 
		 * 							   10 
		 * 							  /  \ 
		 * 							 8    2 
		 * 							/ 
		 * 						   3
		 */
		ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();
		tree.root = new NodeNext(10);
		tree.root.left = new NodeNext(8);
		tree.root.right = new NodeNext(2);
		tree.root.left.left = new NodeNext(3);

		// Populates nextRight pointer in all nodes
		tree.connect(tree.root);

		// Let us check the values of nextRight pointers
		System.out.println("Following are populated nextRight pointers in " + "the tree"
				+ "(-1 is printed if there is no nextRight)");
		
		int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.data + " is " + a);
		
		int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.data + " is " + b);
		
		int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.right.data + " is " + c);
		
		int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.left.data + " is " + d);
	}
}