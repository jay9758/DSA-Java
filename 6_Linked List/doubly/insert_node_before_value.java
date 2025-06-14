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

public class insert_node_before_value {

    public static void insertBeforeNode(Node node,int v){
        Node prev=node.back;
        Node n=new Node(v,node,prev);
        prev.next=n;
        node.back=n;
    }
    public static void insertAfterNode(Node node,int v){
        if (node.next==null) {
            Node n=new Node(v,null,node);
            node.next=n;
        }
        else{
            Node front=node.next;
            Node n=new Node(v,front,node);
            node.next=n;
            front.back=n;
        }
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
        int[] arr={12,5,6,8};     //head=12
        Node head=arrto2DLL(arr); //head.next=5
        int v=10;

        insertBeforeNode(head.next,v);
        //insertAfterNode(head.next.next,v);
        printll(head);
    }
}

