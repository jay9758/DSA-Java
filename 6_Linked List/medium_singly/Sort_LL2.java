//optimal

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

//https://www.naukri.com/code360/problems/sort-linked-list_920517?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
//https://leetcode.com/problems/sort-list/

public class Sort_LL2 {

    public static Node mergeTwoLists(Node list1,Node list2) {
        Node dummyNode=new Node(-1);
        Node temp=dummyNode;

        while (list1 !=null && list2 !=null) {
            if (list1.data<=list2.data) {
                temp.next=list1;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if (list1!=null) {
            temp.next=list1;
        }
        else{
            temp.next=list2;
        }
        return dummyNode.next;
    }

    public static Node findMiddle(Node head){
        if (head==null || head.next==null) {
            return head;
         }
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head){
       if (head==null || head.next==null) {
          return head;
       }

       Node middle=findMiddle(head);

       Node lefthead=head;
       Node righthead=middle.next;

       middle.next=null;

       lefthead=mergeSort(lefthead);
       righthead=mergeSort(righthead);

       return mergeTwoLists(lefthead,righthead);
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
       int[] arr={3,4,2,1,5};
       Node head=arrto2DLL(arr);

       head=mergeSort(head);
       printll(head);
    }
}

