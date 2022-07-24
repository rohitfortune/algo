package algorithms.tree;

public class Heap {
    enum HeapType{
        min, max;
    }
    HeapType heapType;
    int[] arr;
    int sizeOfArr=0;

    public Heap(HeapType heapType, int size) {
        this.heapType = heapType;
        arr = new int[size+1];
    }

    private void insert(int value) {
       sizeOfArr++;
       arr[sizeOfArr] = value;
        heapifyBottomToTop(sizeOfArr);
    }

    private int extract() {
        int top = arr[1];
        arr[1] = arr[sizeOfArr];
        sizeOfArr--;
        heapifyTopToBottom(1);
        return top;
    }

    private void heapifyTopToBottom(int index) {
        int left = index*2;
        int right = index*2 + 1;
        int swapChild=0;
        if (left > sizeOfArr)
            return;

        if (heapType.equals(HeapType.max)){
            if (right <= sizeOfArr && arr[left] < arr[right])
                swapChild = right;
            else
                swapChild = left;
            if (arr[index] < arr[swapChild]){
                int temp = arr[index];
                arr[index] = arr[swapChild];
                arr[swapChild] = temp;
            }
           heapifyTopToBottom(swapChild);
        }
        else {
            if (right <= sizeOfArr && arr[left] > arr[right])
                swapChild = right;
            else
                swapChild = left;
            if (arr[index] > arr[swapChild]){
                int temp = arr[index];
                arr[index] = arr[swapChild];
                arr[swapChild] = temp;
            }
            heapifyTopToBottom(swapChild);
        }
    }

    private void heapifyBottomToTop(int index) {

        int parentIndex = index/2;
        if (parentIndex < 1)
            return;
        if (heapType.equals(HeapType.min)){
            if (arr[index] < arr[parentIndex]){
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];
                arr[index] = temp;
            }
            heapifyBottomToTop(parentIndex);
        }
        else {
            if (arr[index] > arr[parentIndex]){
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];
                arr[index] = temp;
            }
            heapifyBottomToTop(parentIndex);
        }

    }

    public static void main(String[] args) {
        Heap heap = new Heap(HeapType.max, 5);
        heap.insert(15);
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(30);

        heap.traversal();
        System.out.println("\nextract : "+heap.extract());
        heap.traversal();
        System.out.println("\nextract : "+heap.extract());
        heap.traversal();

        System.out.println("\nCreating min Heap: ");
        Heap minHeap = new Heap(HeapType.min, 5);
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(30);

        minHeap.traversal();
        System.out.println("\nextract : "+minHeap.extract());
        minHeap.traversal();
        System.out.println("\nextract : "+minHeap.extract());
        minHeap.traversal();
    }

    private void traversal() {
        for (int i=1; i<=sizeOfArr; i++){
            System.out.println(arr[i] +" ");
        }
    }
}
