package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    Node root;

    public void insert(int value){
        root = insert(root, value);
    }

    public Node insert(Node node, int value){
        if (node == null){
            Node newNode = new Node(value);
            newNode.height = 1;
            return newNode;
        }
        else if (value < node.data){
            node.left = insert(node.left, value);
        }
        else {
            node.right = insert(node.right, value);
        }
        node.height = 1 + Math.max(getHeight(node.left) , getHeight(node.right));

        int balance = getBalance(node);
        if (balance > 1 && value < node.left.data){
            return rotateRight(node);
        }
        if (balance > 1 && value > node.left.data){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && value > node.right.data){
            return rotateLeft(node);
        }
        if (balance < -1 && value < node.right.data){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void delete(int value){
        root = delete(root, value);
    }


    public Node delete(Node node, int value){
        if (node == null){
            return null;
        }
        else if (value < node.data){
            node.left = delete(node.left, value);
        }
        else if (value > node.data){
            node.right = delete(node.right, value);
        }
        else {
            if (node.left != null && node.right != null){
                node.data = minValue(node.right);
                node.right = delete(node.right, node.data);
            }
            else if (node.left != null){
                node = node.left;
            }
            else if (node.right != null){
                node = node.right;
            }
            else {
                node = null;
            }
        }

        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.left)>=0){
            return rotateRight(node);
        }
        if (balance > 1 && getBalance(node.left)<0){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right)>0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        if (balance < -1 && getBalance(node.right)<=0){
            return rotateLeft(node);
        }
        return node;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = node.left.right;
        newRoot.right = node;
        node.height = 1 + Math.max(getHeight(node.left) , getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left) , getHeight(newRoot.right));
        return newRoot;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = node.right.left;
        newRoot.left = node;
        node.height = 1 + Math.max(getHeight(node.left) , getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left) , getHeight(newRoot.right));
        return newRoot;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int minValue(Node node) {
        if (node.left == null)
            return node.data;
        return minValue(node.left);
    }

    public void levelTravesal(){
        levelTraversal(root);
    }
    public void levelTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.print(temp.data+"\t");
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        tree.insert(25);

        System.out.println("\nLevel Traversal: ");
        tree.levelTravesal();
        tree.delete(15);
        System.out.println("\nLevel Traversal: ");
        tree.levelTraversal(tree.root);
    }
}
