//brute

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

public class Find_pairs_with_given_sum_in_DLL {

    public static List findPair(Node head,int k){
        ArrayList<List<Integer>> ls=new ArrayList<>();
        Node temp1=head;
        while (temp1!=null) {
            Node temp2=temp1.next;
            while (temp2!=null && temp1.data+temp2.data<=k) {
                if (temp1.data+temp2.data==k) {
                    ArrayList<Integer> s=new ArrayList<>();
                    s.add(temp1.data);
                    s.add(temp2.data);
                    ls.add(s);
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
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
