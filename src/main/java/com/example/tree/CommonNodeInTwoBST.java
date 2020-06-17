package com.example.tree;

// Java program of iterative traversal based method to
// find common elements in two BSTs.
import java.util.*;
public class CommonNodeInTwoBST {

    // Function two print common elements in given two trees
    static void printCommon(Node root1, Node root2)
    {

        Stack<Node> s1 = new Stack<Node> ();
        Stack<Node> s2 = new Stack<Node> ();

        while (true)
        {
            // push the Nodes of first tree in stack s1
            if (root1 != null)
            {
                s1.push(root1);
                root1 = root1.left;
            }

            // push the Nodes of second tree in stack s2
            else if (root2 != null)
            {
                s2.push(root2);
                root2 = root2.left;
            }

            // Both root1 and root2 are NULL here
            else if (!s1.isEmpty() && !s2.isEmpty())
            {
                root1 = s1.peek();
                root2 = s2.peek();

                // If current keys in two trees are same
                if (root1.data == root2.data)
                {
                    System.out.print(root1.data + " ");
                    s1.pop();
                    s2.pop();

                    // move to the inorder successor
                    root1 = root1.right;
                    root2 = root2.right;
                }

                else if (root1.data < root2.data)
                {
                    // If Node of first tree is smaller, than that of
                    // second tree, then its obvious that the inorder
                    // successors of current Node can have same value
                    // as that of the second tree Node. Thus, we pop
                    // from s2
                    s1.pop();
                    root1 = root1.right;

                    // root2 is set to NULL, because we need
                    // new Nodes of tree 1
                    root2 = null;
                }
                else if (root1.data > root2.data)
                {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }

            // Both roots and both stacks are empty
            else break;
        }
    }

    // A utility function to do inorder traversal
    static void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    /* A utility function to insert a new Node with given key in BST */
    static Node insert(Node node, int key)
    {
        /* If the tree is empty, return a new Node */
        if (node == null) return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        /* return the (unchanged) Node pointer */
        return node;
    }

    // Driver program
    public static void main(String[] args)
    {
        // Create first tree as shown in example
        Node root1 = null;
        root1 = insert(root1, 5);
        root1 = insert(root1, 1);
        root1 = insert(root1, 10);
        root1 = insert(root1, 0);
        root1 = insert(root1, 4);
        root1 = insert(root1, 7);
        root1 = insert(root1, 9);

        // Create second tree as shown in example
        Node root2 = null;
        root2 = insert(root2, 10);
        root2 = insert(root2, 7);
        root2 = insert(root2, 20);
        root2 = insert(root2, 4);
        root2 = insert(root2, 9);

        System.out.print("Tree 1 : " + "\n");
        inorder(root1);
        System.out.println();
        System.out.print("Tree 2 : " + "\n");
        inorder(root2);
        System.out.println();
        System.out.println("Common Nodes: ");

        printCommon(root1, root2);

    }
}

