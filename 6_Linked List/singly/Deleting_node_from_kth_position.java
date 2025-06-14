class Node{
    int data;
    Node next;

    Node(int data1,Node next1) {
        this.data=data1;
        this.next=next1;
    }
    Node(int data1) {
        this.data=data1;
        this.next=null;
    }
}

public class Deleting_node_from_kth_position {

    public static Node deleteNodeKth(Node head,int k){
        if (head==null) {
            return head;
        }
        if (k==1) {
            head=head.next;
            return head;
        }
        int count=0;
        Node temp=head;
        Node prev=null;
        while (temp!=null) {
            count++;
            if (count==k) {
                prev.next=prev.next.next;
                return head;
            }
            prev=temp;
            temp=temp.next;
        }
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
        //         1 2 3 4
        int[] arr={2,3,4,5};
        Node head=arrtolinklist(arr);
        int k=3; // remove from 3nd position

        head=deleteNodeKth(head,k);
        printll(head);
    }
}
