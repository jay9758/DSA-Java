

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

//https://www.naukri.com/code360/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM
//https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicates-from-a-sorted-doubly-linked-list

public class Remove_duplicates_from_sorted_DLL {

    public static Node removeDup(Node head){
       Node temp=head;
       while (temp!=null && temp.next!=null) {
          Node nextNode=temp.next;
          while (nextNode!=null && temp.data==nextNode.data) {
             nextNode=nextNode.next;
          }
          temp.next=nextNode;
          if (nextNode!=null) {
             nextNode.back=temp;
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
        int[] arr={1,1,1,2,3,3,4};
        Node head=arrto2DLL(arr);

        head=removeDup(head);
        printll(head);
    }
}
