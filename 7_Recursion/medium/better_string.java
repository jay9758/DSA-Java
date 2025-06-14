//Input:
//str1 = "gfg", str2 = "ggg"
//Output: "gfg"
//Explanation: "gfg" have 6 distinct(unique) subsequences 
//whereas "ggg" have 3 distinct subsequences. 

import java.util.HashSet;

public class better_string {

    public static int subsequence(String s) {
        int n=s.length();
        HashSet<String> set=new HashSet<>();
        for (int num = 0; num < Math.pow(2, n); num++) {
            String sub="";
            for (int i = 0; i < n; i++) {
                if ((num & (1<<i)) != 0) {
                    sub=sub+s.charAt(i);
                }
            }
                set.add(sub);
        }
        System.out.println(set);
        return set.size()-1;
    }
    public static void main(String[] args) {
        String s1="gfg";
        String s2="ggg";

        int sub1=subsequence(s1);
        int sub2=subsequence(s2);
        String ans=(sub1 >= sub2) ? s1 : s2;
        
        System.out.println(ans);
    }
}
