//optimal

import java.util.ArrayList;
import java.util.List;

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

//https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list

public class Find_pairs_with_given_sum_in_DLL2 {

    public static List findPair(Node head,int k){
        ArrayList<List<Integer>> ls=new ArrayList<>();
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        Node left=head;
        Node right=temp;
        while (left.data<right.data) {
            if (left.data+right.data==k) {
                ArrayList<Integer> s=new ArrayList<>();
                s.add(left.data);
                s.add(right.data);
                ls.add(s);
                left=left.next;
                right=right.back;
            }
            else if (left.data+right.data>k) {
                right=right.back;
            }
            else{
                left=left.next;
            }
        }
        return ls;
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
        int[] arr={1,2,3,4,9};
        Node head=arrto2DLL(arr);
        int k=5;

        List ans=findPair(head, k);
        System.out.println(ans);
    }
}
