//optimal

class Node {

    int data;
    Node next;
    Node child;

    Node(int data1, Node next1, Node child1) {
        this.data = data1;
        this.next = next1;
        this.child = child1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.child = null;
    }
}

//https://www.naukri.com/code360/problems/flatten-a-linked-list_1112655?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list

public class Flattening_of_LL2 {

    public static Node mergeLists(Node l1,Node l2){
        Node dummyNode = new Node(-1);
        Node res=dummyNode;
        while (l1 != null && l2 !=null) {
            if (l1.data < l2.data) {
                res.child = l1;
                res=l1;
                l1 = l1.child;
            }
            else {
                res.child = l2;
                res=l2;
                l2 = l2.child;
            }
            res.next=null;
        }
        if (l1!=null) {
            res.child = l1;
        }
        else {
            res.child = l2;
        }

        if (dummyNode.child!=null) {
            dummyNode.child.next=null;
        }
        return dummyNode.child;
    } 

    public static Node flattenLL(Node head) {
        if (head==null || head.next==null) {
            return head;
        }
        Node mergeHead=flattenLL(head.next);
        head= mergeLists(head, mergeHead);
        return head;
    }

    public static void printllwithchild(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
    }

    private static Node arrtolinklist(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void printll(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.child = new Node(14);

        head.next = new Node(10);
        head.next.child = new Node(4);

        head.next.next = new Node(12);
        head.next.next.child = new Node(20);
        head.next.next.child.child = new Node(13);

        head.next.next.next = new Node(7);
        head.next.next.next.child = new Node(17);

        head = flattenLL(head);
        printllwithchild(head);
    }
}
