package ds.tree;

public class BinaryTreeArrayImpl {
    private int[] bt;
    private int lastIndex;

    public BinaryTreeArrayImpl(int size) {
        bt = new int[size+1];
        lastIndex=0;
    }

    public void insert(int data){
        if (!isFull()){
            lastIndex++;
            bt[lastIndex] = data;
            System.out.println("Inserted "+data);
        }else {
            System.out.println("Tree is full");
        }
    }

    public void delete(int data){
        int location = search(data);
        if (location != -1){
            bt[location] = bt[lastIndex];
            lastIndex--;
            System.out.println("\nDeleted "+data);
        }else {
            System.out.println("Not Found");
        }
    }

    private int search(int data) {
        for (int i=1; i<=lastIndex; i++){
            if (bt[i] == data){
                return i;
            }
        }
        return -1;
    }

    private boolean isFull() {
        if (bt.length-1 == lastIndex){
            return true;
        }else {
            return false;
        }
    }

    public void levelTraverse(){
        System.out.println("\nPrinting Tree... LevelOrder");
        for (int i=1; i<=lastIndex; i++){
            System.out.print(bt[i]+"\t");
        }
    }

    public void inorderTraversal(int index){

        if (index > lastIndex)
            return;
        inorderTraversal(index*2);
        System.out.print(bt[index]+"\t");
        inorderTraversal(index*2+1);
    }

    public void postOrderTraversal(int index){

        if (index > lastIndex)
            return;
        postOrderTraversal(index*2);
        postOrderTraversal(index*2+1);
        System.out.print(bt[index]+"\t");

    }

    public void preOrderTraversal(int index){

        if (index > lastIndex)
            return;
        System.out.print(bt[index]+"\t");
        preOrderTraversal(index*2);
        preOrderTraversal(index*2+1);
    }


    public static void main(String[] args) {
        BinaryTreeArrayImpl tree = new BinaryTreeArrayImpl(8);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        System.out.println("\nPreOrder Traversal: ");
        tree.preOrderTraversal(1);
        System.out.println("\nInOrder Traversal: ");
        tree.inorderTraversal(1);
        System.out.println("\nPostOrder Traversal: ");
        tree.postOrderTraversal(1);
        tree.levelTraverse();
        tree.delete(2);
        tree.levelTraverse();
    }
}
