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

public class Deleting_node_from_head {

    public static Node deteleNodeHead(Node head){
        if (head==null) {
            return head;
        }
        return head=head.next;
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
        int[] arr={2,3,4,5};
        Node head=arrtolinklist(arr);

        head=deteleNodeHead(head);
        printll(head);
    }
}
