
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

//https://www.naukri.com/code360/problems/reverse-list-in-k-groups_983644?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/reverse-nodes-in-k-group/

public class Reverse_LL_in_group_of_given_size_K {

    public static Node findKthNode(Node temp,int k){
        k--;
        while (temp!=null && k>0) {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public static Node reverse(Node head){
        Node temp=head;
        Node prev=null;
        while (temp!=null) {
            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }

    public static Node reverseSizeK(Node head,int k){
        Node temp=head;
        Node prevNode=null;

        while (temp!=null) {
            Node kthNode=findKthNode(temp,k);
            if (kthNode==null) {
                if (prevNode!=null) {
                    prevNode.next=temp;
                }
                break;
            }

            Node nextNode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            
            if (temp==head) {
                head=kthNode;
            }
            else{
                prevNode.next=kthNode;
            }
            
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }

    private static Node arrtolinklist(int[] arr){
        Node head=new Node(arr[0]);
        Node mover=head;
        for (int i = 1; i < arr.length; i++) {
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    public static void printll(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Node head=arrtolinklist(arr);
        int k=3;

        head=reverseSizeK(head, k);
        printll(head);
    }   
}
