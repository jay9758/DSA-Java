//brute

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

//https://www.naukri.com/code360/problems/rearrange-odd-and-even-places_920379?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/odd-even-linked-list/

public class Segrregate_odd_and_even_nodes_in_LL2 {

    public static Node oddandEvenNode(Node head){
        if (head==null || head.next==null) {
            return head;
        }
        Node odd=head;
        Node even=head.next;
        Node evenHead=head.next;

        while (even!=null && even.next!=null) {
            odd.next=odd.next.next;
            even.next=even.next.next;
            
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;

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


