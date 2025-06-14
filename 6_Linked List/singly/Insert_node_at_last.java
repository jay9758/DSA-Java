class Node{
    int data;
    Node next;

    Node(int data1,Node next1) {
        this.data=data1;
        this.next=next1;
    }
    Node(int data1) {
        this.data=data1;
        this.next=null;
    }
}
//https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-insertion

public class Insert_node_at_last { 

    private static Node insertNodeLast(Node head,int v){
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=new Node(v);
        return head;
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
        int[] arr={2,3,4,5};
        Node head=arrtolinklist(arr);
        int v=8;
        head=insertNodeLast(head,v);
        printll(head);
    }
}
