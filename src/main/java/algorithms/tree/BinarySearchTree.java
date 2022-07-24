package algorithms.tree;

//Java program to demonstrate delete operation in binary search tree 
public class BinarySearchTree
{ 
	// Root of BST 
	Node root; 

	// This method mainly calls deleteRec() 
	void deleteKey(int key) 
	{ 
		root = deleteRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	Node deleteRec(Node root, int key) 
	{ 
		/* Base Case: If the tree is empty */
		if (root == null) return root; 

		/* Otherwise, recur down the tree */
		if (key < root.data) 
			root.left = deleteRec(root.left, key); 
		else if (key > root.data) 
			root.right = deleteRec(root.right, key); 

		// if key is same as root's key, then This is the node 
		// to be deleted 
		else
		{ 
			// node with only one child or no child 
			if (root.left == null) 
				return root.right; 
			else if (root.right == null) 
				return root.left; 

			// node with two children: Get the inorder successor (smallest 
			// in the right subtree) 
			root.data = minValueRecursive(root.right);

			// Delete the inorder successor 
			root.right = deleteRec(root.right, root.data); 
		} 

		return root; 
	} 

	int minValue(Node root) 
	{ 
		int minv = root.data; 
		while (root.left != null) 
		{ 
			minv = root.left.data; 
			root = root.left; 
		} 
		return minv; 
	}

	int minValueRecursive(Node root)
	{
		if (root.left == null){
			return root.data;
		}
		return minValueRecursive(root.left);
	}

	// This method mainly calls insertRec() 
	void insert(int key) 
	{ 
		root = insertRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) 
	{ 

		/* If the tree is empty, return a new node */
		if (root == null) 
		{ 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key < root.data) 
			root.left = insertRec(root.left, key); 
		else if (key > root.data) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	void inorder() 
	{ 
		inorderRec(root); 
	}
	void preOrderTraversal() {
		preOrderTraversal(root);
	}

	void postOrderTraversal() {
		postOrderTraversal(root);
	}

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) 
	{ 
		if (root != null) 
		{ 
			inorderRec(root.left); 
			System.out.print(root.data + " "); 
			inorderRec(root.right); 
		} 
	}

	void preOrderTraversal(Node root){
		if (root != null)
		{
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	void postOrderTraversal(Node root){
		if (root != null)
		{
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	Node search(int value){
		return search(root, value);
	}

	Node search(Node root, int value){
		if (root == null)
			return null;
		else if (value < root.data){
			return search(root.left, value);
		}
		else if (value > root.data){
			return search(root.right, value);
		}
		else {
			return root;
		}
	}

	// Driver Program to test above functions 
	public static void main(String[] args) 
	{ 
		BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST 
		    50 
		  /	   \ 
		 30	   70 
		 / \   / \ 
		20 40 60 80 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		System.out.println("Inorder traversal of the given tree"); 
		tree.inorder();
		System.out.println("\nPost order traversal of the given tree");
		tree.postOrderTraversal();
		System.out.println("\nPre order traversal of the given tree");
		tree.preOrderTraversal();
		Node n = tree.search( 55);
		if (n != null)
			System.out.println("\nFound "+ n.data);
		else
			System.out.println("\nNot Found");

		System.out.println("\nDelete 20"); 
		tree.deleteKey(20); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inorder(); 

		System.out.println("\nDelete 30"); 
		tree.deleteKey(30); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inorder(); 

		System.out.println("\nDelete 50"); 
		tree.deleteKey(50); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inorder(); 
	}

} 