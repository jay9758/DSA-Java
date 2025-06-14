

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

public class Sort_a_LL_of_0s_1s_2s {

    public static Node sortLLwith012S(Node head){
        Node temp=head;
        int cnt0=0;
        int cnt1=0;
        int cnt2=0;
        while (temp!=null) {
            if (temp.data==0) {
                cnt0++;
            }
            else if (temp.data==1) {
                cnt1++;
            }
            else{
                cnt2++;
            }
            temp=temp.next;
        }
        temp=head;
        while (temp!=null) {
            if (cnt0>0) {
                temp.data=0;
                cnt0--;
            }
            else if(cnt1>0) {
                temp.data=1;
                cnt1--;
            }
            else {
                temp.data=2;
                cnt2--;
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
        //        1 2 3 4 5
       int[] arr={1,0,1,2,0,2,1};
       Node head=arrto2DLL(arr);

       head=sortLLwith012S(head);
       printll(head);
    }
}
