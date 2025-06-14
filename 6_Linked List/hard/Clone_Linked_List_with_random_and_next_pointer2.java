//optimal

class Node {

    int data;
    Node next;
    Node random;

    Node(int data1, Node next1, Node random1) {
        this.data = data1;
        this.next = next1;
        this.random = random1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.random = null;
    }
}

//https://www.naukri.com/code360/problems/clone-a-linked-list-with-random-pointers_983604?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://leetcode.com/problems/copy-list-with-random-pointer/

public class Clone_Linked_List_with_random_and_next_pointer2 {

    public static Node cloneLL(Node head){
        Node temp=head;
        while (temp!=null) {
            Node newNode=new Node(temp.data);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        temp=head;
        while (temp!=null) {
            Node copyNode=temp.next;
            if (temp.random!=null) {
                copyNode.random=temp.random.next;
            }
            else{
                copyNode.random=null;
            }
            temp=temp.next.next;
        }
        Node dummyNode=new Node(-1);
        Node res=dummyNode;
        temp=head;
        while (temp!=null) {
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }

    public static void printll(Node head) {
        while (head != null) {
            System.out.print("data= "+head.data + " ");
            if (head.random!=null) {
                System.out.print("random= "+head.random.data + ",");
            }
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(7);
        head.next=new Node(14);
        head.next.next=new Node(21);
        head.next.next.next=new Node(28);

        head.random=head.next.next;
        head.next.random=head;
        head.next.next.random=head.next.next.next;
        head.next.next.next.random=head.next;

        Node cloneHead=cloneLL(head);
        printll(cloneHead);
    }
}

