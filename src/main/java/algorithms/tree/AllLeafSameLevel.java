package algorithms.tree;

// Java program to check if all leaves are at same level

public class AllLeafSameLevel
{
    Node root;
    int leafLevel =0;

    /* Recursive function which checks whether all leaves are at same
    level */
    boolean checkUtil(Node node, int level)
    {
        // Base case
        if (node == null)
            return true;

        // If a leaf node is encountered
        if (node.left == null && node.right == null)
        {
            // When a leaf node is found first time
            if (leafLevel == 0)
            {
                // Set first found leaf's level
                leafLevel = level;
                return true;
            }

            // If this is not first leaf node, compare its level with
            // first leaf's level
            return (level == leafLevel);
        }

        // If this node is not leaf, recursively check left and right
        // subtrees
        return checkUtil(node.left, level + 1)
                && checkUtil(node.right, level + 1);
    }

    public static void main(String args[])
    {
        // Let us create the tree as shown in the example
        AllLeafSameLevel tree = new AllLeafSameLevel();
        tree.root = new Node(12);
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(9);
        tree.root.left.left.left = new Node(1);
        tree.root.left.right.left = new Node(1);
        if (tree.checkUtil(tree.root,0))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }
}


