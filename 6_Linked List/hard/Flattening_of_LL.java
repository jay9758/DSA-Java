//brute 

import java.util.ArrayList;
import java.util.Collections;

class Node{
    int data;
    Node next;
    Node child;

    Node(int data1,Node next1,Node child1) {
        this.data=data1;
        this.next=next1;
        this.child=child1;
    }
    Node(int data1) {
        this.data=data1;
        this.next=null;
        this.child=null;
    }
}

//answer is sorted

public class Flattening_of_LL {

    public static Node flattenLL(Node head){
        ArrayList<Integer> arr=new ArrayList<>();
        Node temp=head;
        while (temp!=null) {
            Node t2=temp;
            while (t2!=null) {
                arr.add(t2.data);
                t2=t2.child;
            }
            temp=temp.next;
        }
        Collections.sort(arr);

        if (arr.size()==0) {
            return null;
        }
        head=new Node(arr.get(0));
        temp=head;
        for (int i = 1; i < arr.size()-1; i++) {
            Node newNode=new Node(arr.get(i));
            temp.child=newNode;
            temp=temp.child;
        }
        return head;
    }

    public static void printllwithchild(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.child;
        }
    }
    private static Node arrtolinklist(int[] arr){
        Node head=new Node(arr[0]);
        Node mover=head;
        for (int i = 1; i < arr.length; i++) {
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    public static void printll(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(5);
        head.child=new Node(14);

        head.next=new Node(10);
        head.next.child=new Node(4);

        head.next.next=new Node(12);
        head.next.next.child=new Node(20);
        head.next.next.child.child=new Node(13);

        head.next.next.next=new Node(7);
        head.next.next.next.child=new Node(17);

        head=flattenLL(head);
        printllwithchild(head);
    }   
}

