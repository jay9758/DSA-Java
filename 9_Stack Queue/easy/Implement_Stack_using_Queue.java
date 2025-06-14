
import java.util.LinkedList;
import java.util.Queue;

class stack{
    Queue<Integer> q=new LinkedList<>();
    void push(int x){
        q.add(x);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.peek());
            q.remove(q.peek());
        }
    }
    int pop(){
        int x=q.peek();
        q.remove(q.peek());
        return x;
    }
    int top(){
        return q.peek();
    }
    int size(){
        return q.size();
    }
    void print(){
        System.out.println(q);
    }
}
public class Implement_Stack_using_Queue {
    public static void main(String[] args) {
        stack s=new stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        System.out.println("pop "+s.pop());
        System.out.println("top "+s.top());
        s.push(6);
        s.print();
        System.out.println("pop "+s.pop());
        System.out.println("top "+s.top());
        System.out.println("size "+s.size());
    }
}
