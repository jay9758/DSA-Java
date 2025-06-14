
import java.util.Stack;


public class Infix_to_prefix_Conversion {

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

    public static String reverse(String s){
        String r="";
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)==')') {
                r=r+'(';
            }
            else if (s.charAt(i)=='(') {
                r=r+')';
            }
            else{
                r=r+s.charAt(i);
            }
        }
        return r;
    }

    public static String infixToprefix(String s){
        String r=reverse(s);
        int n=r.length();
        Stack<Character> st=new Stack<>();
        String ans="";
        int i=0;
        while (i<n) {
            if (r.charAt(i)>='A' && r.charAt(i)<='Z' || r.charAt(i)>='a' && r.charAt(i)<='z' || r.charAt(i)>='0' && r.charAt(i)<='9') {
                ans=ans+r.charAt(i);
            }
            else if (r.charAt(i)=='(') {
                st.push(r.charAt(i));
            }
            else if (r.charAt(i)==')') {
                while (!st.isEmpty() && st.peek()!='(') {
                    ans=ans+st.peek();
                    st.pop();
                }
                st.pop();
            }
            else{
                if (r.charAt(i)=='^') {
                    while (!st.isEmpty() && priority(r.charAt(i))<=priority(st.peek())) {
                        ans=ans+st.peek();
                        st.pop();
                    }
                }
                else{
                    while (!st.isEmpty() && priority(r.charAt(i))<priority(st.peek())) {
                        ans=ans+st.peek();
                        st.pop();
                    }
                }
                st.push(r.charAt(i));
            }
            i++;
        }
        while (!st.isEmpty()) {
            ans=ans+st.peek();
            st.pop();
        }
        String ans1=reverse(ans);
        return ans1;
    }
    public static void main(String[] args) {
        String s="(A+B)*C-D+F";

        String ans=infixToprefix(s);
        
        System.out.println(ans);
    }
}
