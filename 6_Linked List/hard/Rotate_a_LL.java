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

//https://www.naukri.com/code360/problems/rotate-linked-list_920454?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/rotate-list/submissions/1546141409/

public class Rotate_a_LL {

    public static Node findNthnode(Node temp,int k){
        int cnt=1;
        while (temp!=null) {
            if (cnt==k) {
                return temp;
            }
            cnt++;
            temp=temp.next;
        }
        return temp;
    }

    public static Node rotateKtime(Node head,int k){
        if (k==0) {
            return head;
        }
        Node tail=head;
        int length=1;
        while (tail.next!=null) {
            length++;
            tail=tail.next;
        }
        if (k%length==0) {
            return head;
        }
        else{
            k=k%length;
        }
        tail.next=head;

       Node newLastNode=findNthnode(head, length-k);
       head=newLastNode.next;
       newLastNode.next=null;
       return head;
    }

    private static Node arrtolinklist(int[] arr){
        Node head=new Node(arr[0]);
        Node mover=head;
        for (int i = 1; i < arr.length; i++) {
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    public static void printll(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        Node head=arrtolinklist(arr);
        int k=2;

        head=rotateKtime(head, k);
        printll(head);
    }   
}
