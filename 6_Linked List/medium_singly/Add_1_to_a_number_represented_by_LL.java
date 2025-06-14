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

public class Add_1_to_a_number_represented_by_LL {

    public static Node reverse(Node head){
        if (head==null || head.next==null) {
            return head;
        }
        Node newHead=reverse(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    public static Node add1No(Node head){
        head=reverse(head);
        Node temp=head;
        int carry=1;
        
        while (temp!=null) {
            temp.data=temp.data+carry;
            if (temp.data<10) {
                carry=0;
                break;
            }
            else{
                temp.data=0;
                carry=1;
            }
            temp=temp.next;
        }
        if (carry==1) {
            Node newNode=new Node(1);
            head=reverse(head);
            newNode.next=head;
            return newNode;
        }
        head=reverse(head);
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
        int[] arr={1,5,9};
        Node head=arrto2DLL(arr);

        head=add1No(head);
        printll(head);
    }
}


