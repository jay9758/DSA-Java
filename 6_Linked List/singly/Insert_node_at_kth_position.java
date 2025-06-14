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
public class Insert_node_at_kth_position {

    public static Node insertNodeKth(Node head,int v,int k){
         if (head==null) {
            if (k==1) {
                return new Node(v);
            }
            return head;
         }
         if (k==1) {
            Node temp=new Node(v,head);
            return temp;
         }
         int count=0;
         Node temp=head;
         while (temp!=null) {
            count++;
            if (count==k-1) {
                Node n=new Node(v);
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
        //         1 2 3 4
        int[] arr={2,3,4,5};
        Node head=arrtolinklist(arr);
        int v=9;
        int k=2; // add 9 at 2nd position

        head=insertNodeKth(head,v,k);
        printll(head);
    }
}