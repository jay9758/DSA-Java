
public class Valid_Paranthesis_Checker {

    public static boolean validParanthesis(String s,int idx,int count){
        int n=s.length();
        if (count<0) {
            return false;
        }
        if (idx==n) {
            return count==0 ? true : false; 
        }
        if (s.charAt(idx)=='(') {
            return validParanthesis(s,idx+1,count+1);
        }
        else if (s.charAt(idx)==')') {
            return validParanthesis(s, idx+1, count-1);
        }
        else if (s.charAt(idx)=='*') {
            return validParanthesis(s, idx+1, count+1) || 
                   validParanthesis(s, idx+1, count-1) || 
                   validParanthesis(s, idx+1, count);
        }
        return true;
    }
    public static void main(String[] args) {
        String s="(*()";

        boolean ans=validParanthesis(s,0,0);
        System.out.println(ans);
    }
}
