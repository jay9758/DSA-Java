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

public class Insert_node_before_value {

    public static Node insertBeforeVal(Node head,int el,int v){
        if (head==null) {
            return head;
        }
        if (head.data==v) {
            Node n=new Node(el);
            n.next=head;
            return n;
        }
        Node temp=head;
         while (temp.next!=null) {
            if ((temp.next).data==v) {
                Node n=new Node(el);
                n.next=temp.next;
                temp.next=n;
                break;
            }
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
        int[] arr={2,3,4,5};
        Node head=arrtolinklist(arr);
        int el=9;
        int v=3; //add 9 before 3

        head=insertBeforeVal(head,el,v);
        printll(head);
    }
}
