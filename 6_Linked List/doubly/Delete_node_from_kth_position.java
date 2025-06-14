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

public class Delete_node_from_kth_position {

    //https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list
    public static Node deletekthPosition(Node head,int p){
        if (head==null) {
            return null;
        }
        if (p==1) {
            if (head.next!=null) {
                Node t=head;
                head=head.next;

                head.back=null;
                t.next=null;
                return head;
            }
            return null;
        }

        int count=0;
        Node temp=head;
        while (temp!=null) {
            count++;
            if (count==p) {
                Node prev=temp.back;
                prev.next=temp.next;

                if (temp.next!=null) {
                    temp.next.back=prev;
                }

                temp.back=null;
                temp.next=null;
                return head;
            }
            temp=temp.next;
        }
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
        int p=4;

        head=deletekthPosition(head,p);
        printll(head);
    }
}

