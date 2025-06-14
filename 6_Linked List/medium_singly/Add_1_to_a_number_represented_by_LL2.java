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

//https://www.naukri.com/code360/problems/add-one-to-a-number-represented-as-linked-list_920557?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list

public class Add_1_to_a_number_represented_by_LL2 {

    public static int addHelper(Node head){
        Node temp=head;
        if (temp==null) {
            return 1;
        }
        int carry=addHelper(temp.next);

        temp.data=temp.data+carry;
        if (temp.data<10) {
            return 0;
        }
        else{
            temp.data=0;
        }
        return 1;
    }

    public static Node add1No(Node head){
        int carry=addHelper(head);
        if (carry==1) {
            Node newHead=new Node(1);
            newHead.next=head;
            return newHead;
        }

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
        int[] arr={1,5,9};
        Node head=arrto2DLL(arr);

        head=add1No(head);
        printll(head);
    }
}



