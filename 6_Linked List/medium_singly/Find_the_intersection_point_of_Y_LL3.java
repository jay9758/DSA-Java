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

//https://www.naukri.com/code360/problems/-intersection-of-two-linked-lists_630457?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class Find_the_intersection_point_of_Y_LL3 {

    public static Node interectionP(Node head1,Node head2){
        if (head1==null || head2==null) {
            return null;
        }

        Node t1=head1;
        Node t2=head2;

        while (t1 != t2) {
            if (t1==t2) {
                return t1;
            }
            t1= (t1==null) ? head2:t1.next;
            t2= (t2==null) ? head1:t2.next;
        }
        return t1;
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
        Node head1=new Node(3);
        Node second=new Node(1);
        Node third=new Node(4);
        Node fourth=new Node(6);
        Node five=new Node(2);

        Node head2=new Node(1);
        Node second2=new Node(2);
        Node third2=new Node(4);
        Node fourth2=new Node(5);

        head1.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=five;

        head2.next=second2;
        second2.next=third2;
        third2.next=fourth2;

        //merge
        fourth2.next=third;

        Node ans=interectionP(head1,head2);
        System.out.println(ans.data);
    }
}

