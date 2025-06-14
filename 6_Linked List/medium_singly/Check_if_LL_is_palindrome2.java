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

//https://www.naukri.com/code360/problems/check-if-linked-list-is-palindrome_985248?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=SUBMISSION
//https://leetcode.com/problems/palindrome-linked-list/

public class Check_if_LL_is_palindrome2 {

    public static Node reverse(Node head){
        if (head==null || head.next==null) {
            return head;
        }
        Node newHead=reverse(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    public static boolean checkPalindrome(Node head){
        if (head==null || head.next==null) {
            return true;
        }
        Node slow=head;
        Node fast=head;
        while (fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node newHead=reverse(slow.next);

        Node first=head;
        Node second=newHead;
        while (second!=null) {
            if (first.data!=second.data) {
                reverse(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverse(newHead);
        return true;
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
       int[] arr={1,2,3,2,1};
       Node head=arrto2DLL(arr);

       boolean ans=checkPalindrome(head);
       System.out.println(ans);
    }
}


