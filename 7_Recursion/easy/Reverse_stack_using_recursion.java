//https://www.geeksforgeeks.org/problems/reverse-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-stack

import java.util.Stack;

public class Reverse_stack_using_recursion {

    public static void insertAtBottom(Stack<Integer> st,int x) {
        if (st.size()==0) {
            st.push(x);
            return;
        }
        int top=st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }

    public static void reverse(Stack<Integer> st){
        if (st.size()>0) {
            int x=st.pop();
            reverse(st);
            insertAtBottom(st,x);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(1);  // 4
        st.push(2);  // 3
        st.push(3);  // 2
        st.push(4);  // 1
                    
        reverse(st); 

        while (st.size()!=0) {
            System.out.println(st.peek());
            st.pop();
        }
    }
}
