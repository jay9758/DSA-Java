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

//https://www.naukri.com/code360/problems/delete-kth-node-from-end_799912?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class Remove_Nth_node_from_the_back_of_LL2 {

    public static Node deleteNode(Node head,int N){
        Node fast=head;
        for (int i = 0; i < N; i++) {
            fast=fast.next;
        }

        if (fast==null) {
            head=head.next;
            return head;
        }
        Node slow=head;
        while (fast.next!=null) {
            slow=slow.next;
            fast=fast.next;
        }
        Node front=slow.next.next;
        slow.next=front;
        
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
        //        5 4 3 2 1
       int[] arr={1,2,3,4,5};
       Node head=arrto2DLL(arr);
       int N=5;

       head=deleteNode(head,N);
       printll(head);
    }
}


