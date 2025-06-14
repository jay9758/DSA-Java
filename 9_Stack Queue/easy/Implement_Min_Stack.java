
import java.util.Stack;
class pair{
    int first,second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
    @Override
    public String toString(){
        return "("+first+","+second+")";
    }
}
class stack{
    Stack<pair> st=new Stack<>();
    void push(int x){
        if (st.isEmpty()) {
            st.push(new pair(x, x));
        }
        else{
            st.push(new pair(x, Math.min(x, st.peek().second)));
        }
    }
    int pop(){
        return st.pop().first;
    }
    int top(){
        return st.peek().first;
    }
    int getMin(){
        return st.peek().second;
    }
    void print(){
        System.out.println(st);
    }
}
public class Implement_Min_Stack {
    public static void main(String[] args) {
        stack s=new stack();

        s.push(12);
        s.push(15);
        s.push(10);
        s.print();
        System.out.println("getMin "+s.getMin());
        System.out.println("pop "+s.pop());
        s.print();
        System.out.println("top "+s.top());
        System.out.println("getMin "+s.getMin());
    }
}
