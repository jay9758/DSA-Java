//optimal

import java.util.Stack;

class stack{
    Stack<Integer> st=new Stack<>();
    int min=Integer.MAX_VALUE;
    void push(int x){
        if (st.isEmpty()) {
            st.push(x);
            min=x;
        }
        else{
            if (x>min) {
                st.push(x);
            }
            else{
                st.push((2*x)-min);
                min=x;
            }
        }
    }
    int pop(){
        if (st.isEmpty()) {
            return -1;
        }
        int x=st.peek();
        st.pop();
        if (x<min) {
            min=(2*min-x);
            int p=(x+min)/2;
            return p;
        }
        return x;
    }
    int top(){
        if (st.isEmpty()) {
            return -1;
        }
        int x=st.peek();
        if (x<min) {
            return min;
        }
        return x;
    }
    int getMin(){
        return min;
    }
    void print(){
        System.out.println(st);
    }
}
public class Implement_Min_Stack2 {
    public static void main(String[] args) {
        stack s=new stack();

        s.push(12);
        s.push(15);
        s.push(10);
        s.push(9);
        s.print();
        System.out.println("getMin "+s.getMin());
        System.out.println("pop "+s.pop());
        s.print();
        System.out.println("top "+s.top());
        System.out.println("pop "+s.pop());
        s.print();
        System.out.println("getMin "+s.getMin());
    }
}
