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

public class insert_node_at_kth_position {

    public static Node insertAtKthPosition(Node head,int v,int k){
        if (k==1) {
            Node n=new Node(v,head,null);
            head.back=n;
            return n;
        }
        int count=1;
        Node temp=head;
        while (temp!=null) {
             count++;
             if (count==k) {
                if (temp.next!=null) {
                    Node front=temp.next;
                    Node n=new Node(v,front,temp);
                    temp.next=n;
                    front.back=n;
                    return head;  
                }
                Node n=new Node(v,null,temp);
                temp.next=n;
                return head;
             }
             temp=temp.next;
        }
        return head;
    }
    public static Node insertBeforeKthPosition(Node head,int v,int k){
        if (k==1) {
            Node n=new Node(v,head,null);
            head.back=n;
            return n;
        }
        int count=0;
        Node temp=head;
        while (temp!=null) {
             count++;
             if (count==k) {
                    Node prev=temp.back;
                    Node n=new Node(v,temp,prev);
                    prev.next=n;
                    temp.back=n;
                    return head;  
             }
             temp=temp.next;
        }
        return head;
    }
    //https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insert-a-node-in-doubly-linked-list
    public static Node insertAfterKthPosition(Node head,int v,int k){
        int count=0;
        Node temp=head;
        while (temp!=null) {
             count++;
             if (count==k) {
                if (temp.next!=null) {
                    Node front=temp.next;
                    Node n=new Node(v,front,temp);
                    temp.next=n;
                    front.back=n;
                    return head;  
                }
                Node n=new Node(v,null,temp);
                temp.next=n;
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
        int v=14;
        int k=4;

        //head=insertAtKthPosition(head,v,k);
        head=insertBeforeKthPosition(head,v,k);
        //head=insertAfterKthPosition(head,v,k);
        printll(head);
    }
}
