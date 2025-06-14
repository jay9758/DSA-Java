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

public class Delete_node_from_last {

    public static Node deleteLast(Node head){
        if (head==null || head.next==null) {
            return null;
        }

        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        
        Node prev=temp.back;
        prev.next=null;
        temp.back=null;
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
        int[] arr={12,5,6,8};
        Node head=arrto2DLL(arr);

        head=deleteLast(head);
        printll(head);
    }
}
