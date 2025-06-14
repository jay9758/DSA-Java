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
class stack{
    Node top=new Node(-1);
    int size=0;
    void push(int x){
        Node temp=new Node(x);
        temp.next=top;
        top=temp;
        size++;
    }
    int pop(){
        Node temp=top;
        top=top.next;
        size--;
        return temp.data;
    }
    int top(){
        return top.data;
    }
    int size(){
        return size;
    }
}
public class Implement_stack_using_Linkedlist {
    public static void main(String[] args) {
        stack s=new stack();

        s.push(3);
        s.push(5);
        s.push(8);
        System.out.println(s.top());
        System.out.println(s.pop());
        s.push(7);
        System.out.println(s.top());
    }
}
