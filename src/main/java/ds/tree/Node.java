package ds.tree;

public class Node {
    int data, height;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}