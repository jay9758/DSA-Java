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
//https://www.naukri.com/code360/problems/add-two-numbers_1170520?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/add-two-numbers/

public class Add_2_numbers_in_LL {

    public static Node add2No(Node head1,Node head2){
        Node dummyNode=new Node(-1);
        Node curr=dummyNode;

        Node t1=head1;
        Node t2=head2;
        int carry=0;

        while (t1!=null || t2!=null) {

            int sum=carry;
            if (t1!=null) {
                sum=sum+t1.data;
            }
            if (t2!=null) {
                sum=sum+t2.data;
            }

            int s=sum%10;
            Node newNode=new Node(s);
            curr.next=newNode;
            curr=curr.next;
            carry=sum/10;

            if (t1!=null) {
                t1=t1.next;
            }
            if (t2!=null) {
                t2=t2.next;
            }
        }
        if (carry!=0) {
            Node newNode=new Node(carry);
            curr.next=newNode;
        }
        return dummyNode.next;
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
        int[] arr={3,5};
        int[] arr1={4,5,9,9};
        Node head1=arrto2DLL(arr);
        Node head2=arrto2DLL(arr1);

        Node ans=add2No(head1,head2);
        printll(ans);
    }
}