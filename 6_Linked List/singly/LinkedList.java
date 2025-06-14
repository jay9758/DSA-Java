
class Node{
    int data;
    Node next;

    Node(int data1,Node next1) {
        this.data=data1;
        this.next=next1;
    }
    Node(int data1) {
        this.data=data1;
        this.next=null;
    }
}

class LinkedList {
    //https://www.naukri.com/code360/problems/introduction-to-linked-list_8144737?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
    //https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-linked-list
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
    //https://www.naukri.com/code360/problems/count-nodes-of-linked-list_5884?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
    //https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-nodes-of-linked-list
    private static int length(Node head){
        Node temp=head;
        int count=0;
        while (temp!=null) {
            temp=temp.next;
            count++;
        }
        return count;
    }
    //https://www.naukri.com/code360/problems/search-in-a-linked-list_975381?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM
    //https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-in-linked-list-1664434326
    private static int findelement(Node head,int v){
        Node temp=head;
        while (temp!=null) {
            if (temp.data==v) {
                return 1;
            }
            temp=temp.next;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr={2,3,4,5};
        Node head=arrtolinklist(arr);
        //System.out.println(length(head));
        System.out.println(findelement(head, 5));
    }
}