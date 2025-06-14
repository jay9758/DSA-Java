//brute
import java.util.ArrayList;

//optimal

class Node{
    int data;
    Node next;
    Node back;

    Node(int data1,Node next1,Node back1) {
        this.data=data1;
        this.next=next1;
        this.back=back1;
    }
    Node(int data1) {
        this.data=data1;
        this.next=null;
        this.back=null;
    }
}

public class Segrregate_odd_and_even_nodes_in_LL {

    public static Node oddandEvenNode(Node head){
        if (head==null || head.next==null) {
            return head;
        }
        ArrayList<Integer> ls=new ArrayList<>();
        Node temp=head;
        while (temp!=null && temp.next!=null) {
            ls.add(temp.data);
            temp=temp.next.next;
        }
        if (temp!=null) {
            ls.add(temp.data);
        }
        temp=head.next;
        while (temp!=null && temp.next!=null) {
            ls.add(temp.data);
            temp=temp.next.next;
        }
        if (temp!=null) {
            ls.add(temp.data);
        }

        temp=head;
        int i=0;
        while (temp!=null) {
            temp.data=ls.get(i);
            temp=temp.next;
            i++;
        }
        
        return head;
    }

    private static Node arrto2DLL(int[] arr){
        Node head=new Node(arr[0]);
        Node prev=head;
        for (int i = 1; i < arr.length; i++) {
            Node temp=new Node(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
    private static void printll(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        //        1 2 3 4 5 6
       int[] arr={1,3,4,2,5,6};
       Node head=arrto2DLL(arr);

       head=oddandEvenNode(head);
       printll(head);
    }
}

