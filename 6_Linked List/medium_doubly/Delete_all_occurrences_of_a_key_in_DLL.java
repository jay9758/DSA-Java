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

//https://www.naukri.com/code360/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries
//https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list

class Delete_all_occurrences_of_a_key_in_DLL {

    public static Node deleteAllOcc(Node head,int k){
         Node temp=head;
         while (temp!=null) {
             if (temp.data==k) {
                if (temp==head) {
                    head=head.next;
                }
                Node prev=temp.back;
                Node front=temp.next;
                if (front!=null) {
                    front.back=prev;
                }
                if (prev!=null) {
                    prev.next=front;
                }
                temp=front;
            }
            else{
                temp=temp.next;
            }
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
        int[] arr={10,4,10,10,6};
        Node head=arrto2DLL(arr);
        int k=10;

        head=deleteAllOcc(head, k);
        printll(head);
    }
    
}