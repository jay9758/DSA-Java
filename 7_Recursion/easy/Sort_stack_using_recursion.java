//https://www.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-a-stack

import java.util.Stack;

public class Sort_stack_using_recursion {

    public static void insert(Stack<Integer> st,int x) {
        if (st.size()==0 || st.peek()<x) {
            st.push(x);
            return;
        }
        else{
        int top=st.pop();
            insert(st,x);
            st.push(top);
        }
    }

    public static void sort(Stack<Integer> st){
        if (st.size()>0) {
            int x=st.pop();
            sort(st);
            insert(st,x);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(41);  // 11
        st.push(3);   // 2
        st.push(32);  // 32
        st.push(2);   // 3
        st.push(11);  // 41
                    
        sort(st); 

        while (st.size()!=0) {
            System.out.println(st.peek());
            st.pop();
        }
    }
}
