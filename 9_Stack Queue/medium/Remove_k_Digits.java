//https://leetcode.com/problems/remove-k-digits/submissions/1564802192/

import java.util.Stack;

public class Remove_k_Digits {

    public static String removeKdigit(String s,int k){
        int n=s.length();
        Stack<Character> st=new Stack<>();
        String res="";
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k>0 && st.peek()-'0'>s.charAt(i)-'0') {
                st.pop();
                k=k-1;
            }
            st.push(s.charAt(i));
            //System.out.println(st);
        }
        while (k>0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) {
            return "0";
        }
        while (!st.isEmpty()) {
            res=res+st.peek();
            st.pop();
        }
        while (res.length()!=0 && res.charAt(res.length()-1)=='0') {
            res.substring(0, res.length()-1);
        }

        String newans=new StringBuilder(res).reverse().toString();
        if (newans.isEmpty()) {
            return "0";
        }
        return newans;
    }

    public static void main(String[] args) {
        String s="1432219";
        int k=3;

        String ans=removeKdigit(s,k);
        System.out.println(ans);
    }
}
