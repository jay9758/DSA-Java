
import java.util.Stack;

class queue{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    void push(int x){
        while (!s1.isEmpty()) {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.peek());
            s2.pop();
            }
        }
    int pop(){
        return s1.pop();
    }
    int top(){
        return s1.peek();
    }
    int size(){
        return s1.size();
    }
    void print(){
        System.out.println("s1 "+s1);
    }
}
public class Implement_Queue_using_Stack {
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
