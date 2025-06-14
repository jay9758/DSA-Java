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

public class Remove_Nth_node_from_the_back_of_LL {

    public static Node deleteNode(Node head,int p){
        int count=0;
        Node temp=head;
        while (temp!=null) {
            count++;
            temp=temp.next;
        }

        if (count==p) {
            head=head.next;
            return head;
        }
        int i=count-p;
        
        temp=head;
        while (i>0) {
            i--;
            temp=temp.next;
        }
        Node front=temp.next.next;
        temp.next=front;
        
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
       int p=5;

       head=deleteNode(head,p);
       printll(head);
    }
}

