//https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prefix-to-infix-conversion

import java.util.Stack;

public class Prefix_to_Infix_Conversion {

    public static String prefixToinfix(String s){
        int n=s.length();
        Stack<String> st=new Stack<>();
        int i=n-1;
        while (i>=0) {
            if (s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9') {
                st.push(String.valueOf(s.charAt(i)));
            }
            else{
                String t1=st.peek();
                st.pop();
                String t2=st.peek();
                st.pop();
                String con="("+t1+s.charAt(i)+t2+")";
                st.push(con);
            }
            //System.out.println(st);
            i--;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String s="*+PQ-MN";

        String ans=prefixToinfix(s);
        System.out.println(ans);
    }
}

