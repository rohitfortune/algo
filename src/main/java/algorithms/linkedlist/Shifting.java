package algorithms.linkedlist;

public class Shifting {
    LinkedList partition(LinkedList ll, int x){

        Node temp = ll.head;
        Node curr = ll.head;
        while(temp != null){
            if(temp.value < x){
                int i = temp.value;
                temp.value=curr.value;
                curr.value=i;
                curr=curr.next;
            }
            temp=temp.next;
        }
        ll.traversalLL();
        return ll;
    }

    LinkedList partition1(LinkedList ll, int x){

        ll.tail = ll.head;
        Node curr = ll.head;
        while(curr != null){
            Node next = curr.next;
            if(curr.value<x){
                curr.next=ll.head;
                ll.head=curr;
            }
            else{

                ll.tail.next=curr;
                ll.tail=curr;
            }
            curr=next;
        }

        ll.tail.next=null;
        ll.traversalLL();
        return ll;
    }

}

