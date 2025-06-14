import java.util.HashMap;
import java.util.Map;

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

public class Length_of_Loop_in_LL {

    public static int loopLength(Node head){
        int t=1;
        Node temp=head;
        Map<Node,Integer> map=new HashMap<>();

        while (temp!=null && temp.next!=null) {
            if (map.containsKey(temp)) {
                int l=t-map.get(temp);
                return l;
            }
            map.put(temp, t);
            t++;
            temp=temp.next;
        }
        return 0;
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
        Node head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(4);
        Node five=new Node(5);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=five;

        //Looping
        five.next=third;

       int length=loopLength(head);
       System.out.println(length);
    }
}

