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

//https://www.naukri.com/code360/problems/delete-middle-node_763267?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class Delete_the_middle_node_of_LL_TortoiseHare_Method {

    public static Node deleteMidNode(Node head){
        if (head==null || head.next==null) {
            return null;
        }
        Node slow=head;
        Node fast=head;
        fast=fast.next.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
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

       head=deleteMidNode(head);
       printll(head);
    }
}
