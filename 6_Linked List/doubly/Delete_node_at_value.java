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

public class Delete_node_at_value {

    public static Node deleteAtValue(Node head,int v){
        if (head==null) {
            return null;
        }
        if (head.data==v) {
            if (head.next!=null) {
                Node t=head;
                head=head.next;
    
                head.back=null;
                t.next=null;
                return head;
            }
            return null;
        }
        
        Node temp=head;
        while (temp!=null) {
           if (temp.data==v) {

              Node prev=temp.back;
              prev.next=temp.next;

              if (temp.next!=null) {
                  temp.next.back=prev;
              }

              temp.back=null;
              temp.next=null;
              break;
           }
           temp=temp.next;
        }
        return head;
    }

    // public static void deleteAtValue2(Node temp){
    //     Node prev=temp.back;
    //     Node front=temp.next;

    //     if (front==null) {
    //         prev.next=null;
    //         temp.back=null;
    //         return;
    //     }

    //     prev.next=front;
    //     front.back=prev;

    //     temp.back=null;
    //     temp.next=null;
    // }

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
        int v=6;

        head=deleteAtValue(head,v);
        // deleteAtValue2(head.next);
        printll(head);
    }
}


