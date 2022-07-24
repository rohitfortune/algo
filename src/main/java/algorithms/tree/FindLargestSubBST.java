package algorithms.tree;

//Java program to find largest BST subtree in given Binary Tree 

class Value { 

	int max_size = 0; // for size of largest BST 
	boolean is_bst = false; 
	int min = Integer.MAX_VALUE; // For minimum value in right subtree 
	int max = Integer.MIN_VALUE; // For maximum value in left subtree 

} 

public class FindLargestSubBST { 
	
	Value val; 

	/* Returns size of the largest BST subtree in a Binary Tree 
	(efficient version). */
	int largestBST(Node node) { 

		val = new Value(); 
		largestBSTUtil(node); 

		return val.max_size; 
	} 

	/* largestBSTUtil() updates *max_size_ref for the size of the largest BST 
	subtree. Also, if the tree rooted with node is non-empty and a BST, 
	then returns size of the tree. Otherwise returns 0.*/
	int largestBSTUtil(Node node) { 

		/* Base Case */
		if (node == null) { 
			val.is_bst = true; // An empty tree is BST 
			return 0; // Size of the BST is 0 
		} 

		//int min = Integer.MAX_VALUE; 

		/* A flag variable for left subtree property 
		i.e., max(root->left) < root->data */
		boolean left_flag = false; 

		/* A flag variable for right subtree property 
		i.e., min(root->right) > root->data */
		boolean right_flag = false; 

		int ls, rs; // To store sizes of left and right subtrees 

		/* Following tasks are done by recursive call for left subtree 
		a) Get the maximum value in left subtree (Stored in *max_ref) 
		b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref) 
		c) Get the size of maximum size BST in left subtree (updates *max_size) */
		//val.max = Integer.MIN_VALUE; 
		ls = largestBSTUtil(node.left); 
		if (val.is_bst == true && node.data > val.max) { 
			left_flag = true; 
		} 

		/* Before updating *min_ref, store the min value in left subtree. So that we 
		have the correct minimum value for this subtree */
		int min = val.min; 

		/* The following recursive call does similar (similar to left subtree) 
		task for right subtree */
		val.min = Integer.MAX_VALUE; 
		rs = largestBSTUtil(node.right); 
		if (val.is_bst == true && node.data < val.min) { 
			right_flag = true; 
		} 

		// Update min and max values for the parent recursive calls 
		if (min < val.min) { 
			val.min = min; 
		} 
		if (node.data < val.min) // For leaf nodes 
		{ 
			val.min = node.data; 
		} 
		if (node.data > val.max) { 
			val.max = node.data; 
		} 

		/* If both left and right subtrees are BST. And left and right 
		subtree properties hold for this node, then this tree is BST. 
		So return the size of this tree */
		if (left_flag && right_flag) { 
			if (ls + rs + 1 > val.max_size) { 
				val.max_size = ls + rs + 1; 
			} 
			return ls + rs + 1; 
		} else { 
			//Since this subtree is not BST, set is_bst flag for parent calls 
			val.is_bst = false; 
			return 0; 
		} 
	} 

	public static void main(String[] args) { 
		/* Let us construct the following Tree 
			   50 
			 /	 \ 
			10	  60 
		   / \	  / \ 
		  5  20  55 70 
		        /  / \ 
			   45 65 80 
		*/

		FindLargestSubBST tree = new FindLargestSubBST(); 
		Node root = new Node(50); 
		root.left = new Node(10); 
		root.right = new Node(60); 
		root.left.left = new Node(5); 
		root.left.right = new Node(20); 
		root.right.left = new Node(55); 
		root.right.left.left = new Node(45); 
		root.right.right = new Node(70); 
		root.right.right.left = new Node(65); 
		root.right.right.right = new Node(80); 

		/* The complete tree is not BST as 45 is in right subtree of 50. 
		The following subtree is the largest BST 
			60 
			/ \ 
		   55 70 
		  /	  / \ 
		 45	 65 80 
		*/
		System.out.println("Size of largest BST is " + tree.largestBST(root)); 
	} 
} 

