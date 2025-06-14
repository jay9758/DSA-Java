//https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=postfix-to-prefix-conversion

import java.util.Stack;

public class Postfix_to_Infix_Conversion {

    public static String postfixToinfix(String s){
        int n=s.length();
        Stack<String> st=new Stack<>();
        int i=0;
        while (i<n) {
            if (s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9') {
                st.push(String.valueOf(s.charAt(i)));
            }
            else{
                String t1=st.peek();
                st.pop();
                String t2=st.peek();
                st.pop();
                String con="("+t2+s.charAt(i)+t1+")";
                st.push(con);
            }
            //System.out.println(st);
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String s="AB-DE+F*/";

        String ans=postfixToinfix(s);
        System.out.println(ans);
    }
}
