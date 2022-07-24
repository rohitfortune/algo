package algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedListImpl {

    Node root;

    public void insert(int data){
        if (root == null){
            root = new Node(data);
            return;
        }
        Node presentNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            presentNode = queue.remove();
            if (presentNode.left == null){
                presentNode.left = new Node(data);
                break;
            }
            else if (presentNode.right == null){
                presentNode.right = new Node(data);
                break;
            }
            else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public void delete(int  data){
        Node target= null, deepest = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            deepest = queue.remove();
            if (deepest.data == data){
                target = deepest;
                break;
            }
            if (deepest.left != null){
                queue.add(deepest.left);
            }
            else if (deepest.right != null){
                queue.add(deepest.right);
            }
        }
        if (target != null){
            target.data = root.data;
            if (root.left != null){
                Node childRight = root.left.right;
                Node rootRight = root.right;
                root = root.left;
                root.right = rootRight;
                root.left.right = childRight;
            }
            else if (root.right != null){
                Node childLeft = root.right.left;
                Node rootLeft = root.left;
                root = root.right;
                root.left = rootLeft;
                root.right.left = childLeft;
            }
            else {
                root = null;
            }
        }
        else {
            System.out.println("\ndata not found");
        }
    }

    public void delete(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node presentNode = null, previousNode = null;
        while (!queue.isEmpty()){
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null){
                previousNode.right = null;
                break;
            }
            else if (presentNode.right == null){
                presentNode.left = null;
                break;
            }
            else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public void inorderTraversal(Node root){
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data+"\t");
        inorderTraversal(root.right);
    }

    public void postTraversal(Node root){
        if (root == null)
            return;
        postTraversal(root.left);
        postTraversal(root.right);
        System.out.print(root.data+"\t");
    }

    public void preTraversal(Node root){
        if (root == null)
            return;
        System.out.print(root.data+"\t");
        preTraversal(root.left);
        preTraversal(root.right);
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
        BinaryTreeLinkedListImpl tree = new BinaryTreeLinkedListImpl();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        System.out.println("\nPreOrder Traversal: ");
        tree.preTraversal(tree.root);
        System.out.println("\nInOrder Traversal: ");
        tree.inorderTraversal(tree.root);
        System.out.println("\nPostOrder Traversal: ");
        tree.postTraversal(tree.root);
        System.out.println("\nLevel Traversal: ");
        tree.levelTraversal(tree.root);
        tree.delete();
        System.out.println("\nLevel Traversal: ");
        tree.levelTraversal(tree.root);
        tree.delete(2);
        System.out.println("\nLevel Traversal: ");
        tree.levelTraversal(tree.root);
    }
}
