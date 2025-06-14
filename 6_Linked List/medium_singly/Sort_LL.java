//brute

import java.util.ArrayList;
import java.util.Collections;

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

public class Sort_LL {

    public static Node sort_LL(Node head){
        ArrayList<Integer> ls=new ArrayList<>();
        Node temp=head;
        while (temp!=null) {
            ls.add(temp.data);
            temp=temp.next;
        }

        Collections.sort(ls);

        int i=0;
        temp=head;
        while (temp!=null) {
            temp.data=ls.get(i);
            i++;
            temp=temp.next;
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
        //        1 2 3 4 5
       int[] arr={1,5,2,4,3};
       Node head=arrto2DLL(arr);

       head=sort_LL(head);
       printll(head);
    }
}

