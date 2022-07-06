package ds.tree;

// Recursive Java program for level order traversal of Binary Tree

public class TreeTraversal
{
    // Root of the Binary Tree
    Node root;

    // A utility function to do inorder traversal
    static void inOrder(Node root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // A utility function to do preorder traversal
    static void preOrder(Node root)
    {
        if (root != null)
        {
            System.out.print(root.data + " ");
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    // A utility function to do preorder traversal
    static void postOrder(Node root)
    {
        if (root != null)
        {
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    /* function to print level order traversal of tree*/
    static void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Print nodes at the given level */
    static void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    static int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
           return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        TreeTraversal tree = new TreeTraversal();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        TreeTraversal.printLevelOrder(tree.root);
        System.out.println("\nPost order traversal of binary tree is ");
        TreeTraversal.postOrder(tree.root);
        System.out.println("\nPre order traversal of binary tree is ");
        TreeTraversal.preOrder(tree.root);
    }
}

