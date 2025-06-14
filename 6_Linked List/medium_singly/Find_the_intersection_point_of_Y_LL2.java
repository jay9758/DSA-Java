//better

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

public class Find_the_intersection_point_of_Y_LL2 {

    public static Node collisionPoint(Node t1,Node t2,int n){
         while (n>0) {
             t2=t2.next;
             n--;
         }

         while (t1 != t2) {
            t1=t1.next;
            t2=t2.next;
         }
         return t1;
    }

    public static Node interectionP(Node head1,Node head2){
        Node t1=head1;
        int n1=0;
        
        while (t1!=null) {
            n1++;
            t1=t1.next;
        }
        Node t2=head2;
        int n2=0;
        while (t2!=null) {
            n2++;
            t2=t2.next;
        }
        
        if (n1<n2) {
            return collisionPoint(head1,head2,n2-n1);
        }
        else{
            return collisionPoint(head2,head1,n1-n2);
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
        Node head1=new Node(3);
        Node second=new Node(1);
        Node third=new Node(4);
        Node fourth=new Node(6);
        Node five=new Node(2);

        Node head2=new Node(1);
        Node second2=new Node(2);
        Node third2=new Node(4);
        Node fourth2=new Node(5);

        head1.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=five;

        head2.next=second2;
        second2.next=third2;
        third2.next=fourth2;

        //merge
        fourth2.next=third;

        Node ans=interectionP(head1,head2);
        System.out.println(ans.data);
    }
}

