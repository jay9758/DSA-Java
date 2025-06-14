//https://leetcode.com/problems/valid-parenthesis-string/

public class Valid_Paranthesis_Checker2 {

    public static boolean validParanthesis(String s){
        int n=s.length();
        int min=0;
        int max=0;
        
        for (int i = 0; i < n;i++) {
            if (s.charAt(i)=='('){
                min = min+1;
                max = max+1;
            }
            else if (s.charAt(i)==')') {
                min = min-1;
                max = max-1;
            }
            else if (s.charAt(i)=='*') {
                min = min-1;
                max = max+1;
            }
            if (min<0) {
                min=0;
            }
            if (max<0) {
                return false;
            }
        }
        return min==0 ? true : false;
    }
    public static void main(String[] args) {
        //String s="(**(";
        String s="(*()";

        boolean ans=validParanthesis(s);
        System.out.println(ans);
    }
}
