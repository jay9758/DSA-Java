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

//https://www.naukri.com/code360/problems/sort-linked-list-of-0s-1s-2s_1071937?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it

public class Sort_a_LL_of_0s_1s_2s2 {

    public static Node sortLLwith012S(Node head){
        if (head==null || head.next==null) {
            return head;
        }
        Node zeroHead=new Node(-1);
        Node oneHead=new Node(-1);
        Node twoHead=new Node(-1);

        Node zero=zeroHead;
        Node one=oneHead;
        Node two=twoHead;

        Node temp=head;

        while (temp!=null) {
            if (temp.data==0) {
                zero.next=temp;
                zero=temp;
            }
            else if (temp.data==1) {
                one.next=temp;
                one=temp;
            }
            else{
                two.next=temp;
                two=temp;
            }
            temp=temp.next;
        }

        zero.next=(oneHead.next!=null) ? oneHead.next : twoHead.next;
        one.next=twoHead.next;
        two.next=null;

        Node newHead=zeroHead.next;

        return newHead;
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
        //        1 2 3 4 5 6 7
       int[] arr={1,0,1,2,0,2,1};
       Node head=arrto2DLL(arr);

       head=sortLLwith012S(head);
       printll(head);
    }
}

