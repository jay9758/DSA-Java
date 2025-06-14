//brute

import java.util.Stack;

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

public class Check_if_LL_is_palindrome {

    public static boolean checkPalindrome(Node head){
        Stack<Integer> st=new Stack<>();
        Node temp=head;
        while (temp!=null) {
            st.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while (temp!=null) {
            if (temp.data!=st.peek()) {
                return false;
            }
            st.pop();
            temp=temp.next;
        }
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

