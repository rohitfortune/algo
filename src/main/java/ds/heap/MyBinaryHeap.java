package ds.heap;

import java.util.*;

public class MyBinaryHeap<T extends Comparable<T>> {

    private List<T> heap;
    private Map<T, TreeSet<Integer>> map = new HashMap<>();
    private int heapSize, heapCapacity = 0;

    public MyBinaryHeap() {
        this(1);
    }

    public MyBinaryHeap(int size) {
        heapCapacity =size;
        heap = new ArrayList<T>(heapCapacity);
    }

    public MyBinaryHeap(T[] el) {
        heapCapacity =el.length;
        heap = new ArrayList<T>(heapCapacity);

        for (T t: el ) {
            heap.add(t);
            mapAdd(t,heapSize);
            ++heapSize;
        }
        //heapify
        for(int i= Math.max(0, (heapSize/2)-1) ; i>=0 ; i--)
            sink(i);
    }

    private void sink(int k) {

        while(true){

            int left = (k*2)+1;
            int right = (k*2)+2;
            int smallest =left;

            if(right < heapSize && !less(left, right))
                smallest = right;

            if(left >= heapSize || less(k,smallest)) break;

            swap(k,smallest);

            k=smallest;
        }
    }

    private void swap(int i, int j) {
        T item1 = heap.get(i);
        T item2 = heap.get(j);

        heap.set(i,item2);
        heap.set(j,item1);

        mapSwap(item1,item2,i,j);
    }

    private boolean less(int i, int j) {
        T item1 = heap.get(i);
        T item2 = heap.get(j);

        return item1.compareTo(item2) <=0;
    }

    public void add(T item){

        if(item == null) throw new IllegalArgumentException("can't add null");

        heap.add(item);
        mapAdd(item, heapSize);
        swim(heapSize);
        heapSize++;
    }

    public boolean remove(T elemt){
        if (heapSize == 0) return false;

        int index = mapGet(elemt);

        if (index >= 0)
            removeAt(index);

        return index >=0;
    }

    public T removeAt(int index){

        if(index < 0 || index >= heapSize) throw new IllegalArgumentException();

        T removed_data = heap.get(index);
        heapSize--;
        swap(index,heapSize);
        heap.set(heapSize,null);
        mapRemove(removed_data, heapSize);
        if(index == heapSize) return removed_data;

        T elemt = heap.get(index);
        swim(index);

        if(heap.get(index).equals(elemt))
            sink(index);

        return removed_data;
    }

    private void swim(int k) {

        int parent = (k-1)/2;

        while(k > 0 && less(k,parent)){

            swap(k,parent);
            k=parent;
            parent = (k-1)/2;
        }
    }

    public boolean isMinHeap(int k){

        if(k>=heapSize) return true;

        int left =  (k*2)+1;
        int right = (k*2)+2 ;

        if( left < heapSize &&  less(left, k)) return false;
        if( right < heapSize && less(right, k)) return false;

        return isMinHeap(left) && isMinHeap(right) ;
    }

    private int mapGet(T elemt) {
        TreeSet<Integer> set = map.get(elemt);
        if (set != null){
            return set.last();
        }
        return -1;
    }

    private void mapRemove(T elemt, int index) {
        TreeSet<Integer> set = map.get(elemt);
        set.remove(index);
        if (set.isEmpty())
            map.remove(elemt);
    }

    private void mapAdd(T elemt, int index){
        TreeSet<Integer> set = map.get(elemt);
        if (set == null){
            set = new TreeSet<>();
            set.add(index);
            map.put(elemt,set);
        }
        set.add(index);
    }

    private void mapSwap(T item1, T item2, int index1, int index2){
        Set<Integer> set1 = map.get(item1);
        Set<Integer> set2 = map.get(item2);

        set1.remove(index1);
        set1.add(index2);

        set2.remove(index2);
        set2.add(index1);
    }
}
