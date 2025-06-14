//https://leetcode.com/problems/valid-parentheses/submissions/1561108038/

import java.util.Stack;

public class Check_for_balanced_paranthesis {

    public static boolean checkParenthesis(String s){
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
                st.push(s.charAt(i));
            }
            else{
                if (st.isEmpty()) {
                    return false;
                }
                System.out.println("stack "+st);
                char c=st.peek();
                st.pop();
                if (c=='(' && s.charAt(i)==')' || c=='{' && s.charAt(i)=='}' || c=='[' && s.charAt(i)==']') {
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String s="()[{}()]";

        boolean ans=checkParenthesis(s);
        System.out.println(ans);
    }
}
