//https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=infix-to-postfix

import java.util.Stack;

public class Infix_to_Postfix_Conversion {

    public static int priority(char c){
        if (c=='^') {
            return 3;
        }
        else if (c=='*' || c=='/') {
            return 2;
        }
        else if (c=='+' || c=='-') {
            return 1;
        }
        else{
            return -1;
        }
    }

    public static String infixTopostfix(String s){
        int n=s.length();
        Stack<Character> st=new Stack<>();
        String ans="";
        int i=0;
        while (i<n) {
            if (s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9') {
                ans=ans+s.charAt(i);
            }
            else if (s.charAt(i)=='(') {
                st.push(s.charAt(i));
            }
            else if (s.charAt(i)==')') {
                while (!st.isEmpty() && st.peek()!='(') {
                    ans=ans+st.peek();
                    st.pop();
                }
                st.pop();
            }
            else{
                while (!st.isEmpty() && priority(s.charAt(i))<=priority(st.peek())) {                    ans=ans+st.peek();
                    st.pop();
                }
                st.push(s.charAt(i));
            }
            //System.out.println("st "+st+" , "+"ans "+ans);
            i++;
        }
        while (!st.isEmpty()) {
            ans=ans+st.peek();
            st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="A*(B+C)/D";

        String ans=infixTopostfix(s);
        System.out.println(ans);
    }
}
