
import java.util.Stack;

class queue{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    void push(int x){
        s1.push(x);
    }    
    int pop(){
        if (!s2.isEmpty()) {
            int x = s2.peek();
            s2.pop();
            return x;
        }
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.peek());
                s1.pop();
            }
            return s2.pop();
        }
    }
    int top(){
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.peek());
                s1.pop();
            }
            return s2.peek();
        }
    }
    int size(){
        return s2.size()+s1.size();
    }
    void print(){
        System.out.println("s2 "+s2);
    }
}
public class Implement_Queue_using_Stack_approach2 {
    public static void main(String[] args) {
        queue q=new queue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.print();
        System.out.println("top "+q.top());
        System.out.println("pop "+q.pop());
        q.push(4);
        q.print();
        System.out.println("top "+q.top());
        System.out.println("size "+q.size());
    }
}
