//https://www.naukri.com/code360/problems/reverse-linked-list_920513?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries

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

public class Reverse_a_LinkedList {

    public static Node reverse(Node head){
        Node temp=head;
        Node prev=null;
        while (temp!=null) {
            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
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
        int[] arr={1,2,3,4,5};
        Node head=arrto2DLL(arr);

        head=reverse(head);
        printll(head);
    }
}
