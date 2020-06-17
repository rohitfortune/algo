package com.example.tree;

// Data structure to store a Binary Tree node

public class LeftViewTree
{
    static int max_level = 0;

    // recursive function to print left view
    static void leftViewUtil(Node node, int level)
    {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.println(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    public static void main(String[] args)
    {
        System.out.println("left View: ");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        leftViewUtil(root, 1);

        max_level=0;
        System.out.println("left View: ");
        Node root1 = new Node(12);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.right.left = new Node(25);
        root1.right.right = new Node(40);

        leftViewUtil(root1,1);

        max_level=0;
        System.out.println("left View: ");
        Node root2 = new Node(10);
        root2.left = new Node(12);
        root2.left.right = new Node(4);
        root2.right = new Node(3);
        root2.right.left = new Node(5);
        root2.right.left.right = new Node(6);
        root2.right.left.right.left = new Node(18);
        root2.right.left.right.right= new Node(7);

        leftViewUtil(root2,1);
    }
}