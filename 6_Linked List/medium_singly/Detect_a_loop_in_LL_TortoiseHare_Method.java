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
//https://www.naukri.com/code360/problems/cycle-detection-in-a-singly-linked-list_628974?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/linked-list-cycle/

public class Detect_a_loop_in_LL_TortoiseHare_Method {

    public static boolean detectLoop(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast) {
                return true;
            }
        }
        return false;
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
        Node head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(4);
        Node five=new Node(5);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=five;

        //Looping
        five.next=third;

        Boolean ans=detectLoop(head);
        System.out.println(ans);
    }
}

