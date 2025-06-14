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

class Reverse_a_DLL {

    //https://www.naukri.com/code360/problems/reverse-a-doubly-linked-list_1116098?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=SUBMISSION
    //https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list
    public static Node reverse(Node head){
        if (head==null || head.next==null) {
            return head;
        }
         Node prev=null;
         Node temp=head;
         while (temp!=null) {
            prev=temp.back;
            temp.back=temp.next;
            temp.next=prev;

            temp=temp.back;
         } 
         return prev.back;
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

        head=reverse(head);
        printll(head);
    }    
}