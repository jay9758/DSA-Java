//https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1

public class Minimum_Window_Subsequence {

    public static String minSubsequence(String s,String t){
        int n=s.length();
        int m=t.length();
        int l=0;
        int r=0;
        int k=0;
        int length=Integer.MAX_VALUE;
        String str="";

        while (r<n && k<m) {
            if (s.charAt(r)==t.charAt(k)) {
                k++;
            }
            if (k==m) {
                l=r;
                k--;
                while (l>=0 && k>=0) {
                    if (s.charAt(l)==t.charAt(k)) {
                        k--;
                    }
                    l--;
                }

                l++;
                if ((r-l+1)<length) {
                    length=r-l+1;
                    str=s.substring(l, l+length);
                }

                k=0;
                r=l; //r=l+1;
            }
            r++;
        }
        return str;
    }
    public static void main(String[] args) {
        String s="abcdebdde";
        String t="bde";
        // String s="dynamicprogramming";
        // String t="mm";

        String ans=minSubsequence(s,t);
        System.out.println(ans);
    }
}
