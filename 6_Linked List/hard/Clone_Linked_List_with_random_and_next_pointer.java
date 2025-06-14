//brute

import java.util.HashMap;
import java.util.Map;

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

public class Clone_Linked_List_with_random_and_next_pointer {

    public static Node cloneLL(Node head){
        Map<Node,Node> map=new HashMap<>();
        Node temp=head;
        while (temp!=null) {
            Node newNode=new Node(temp.data);
            map.put(temp, newNode);
            temp=temp.next;
        }
        temp=head;
        while (temp!=null) {
            Node copyNode=map.get(temp);
            copyNode.next=map.get(temp.next);
            copyNode.random=map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
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
