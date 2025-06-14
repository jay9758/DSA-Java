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
class queue{
    Node start;
    Node end;
    int size=0;
    void push(int x){
        Node temp=new Node(x);
        if (start==null) {
            start=end=temp;
        }
        else{
            end.next=temp;
            end=temp;
        }
        size++;
    }
    int pop(){
        if (start==null) {
            return -1;
        }
        Node temp=start;
        start=start.next;
        size--;
        return temp.data;
    }
    int top(){
        if (start==null) {
            return -1;
        }
        Node temp=start;
        return temp.data;
    }
    int size(){
        return size;
    }
}
public class Implement_queue_using_Linkedlist {
    public static void main(String[] args) {
        queue q=new queue();

        q.push(5);
        q.push(6);
        q.push(7);
        System.out.println("top "+q.top());
        System.out.println("size "+q.size());
        System.out.println("pop "+q.pop());
        q.push(9);
        System.out.println("top "+q.top());
        System.out.println("size "+q.size());
    }
}
