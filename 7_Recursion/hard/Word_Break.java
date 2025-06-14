//https://leetcode.com/problems/word-break/
//Time Limit Exceeded

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break {

    public static boolean solve(int start,int end,String s,Set<String> wd){
        if (end==s.length()-1) {
            if (wd.contains(s.substring(start, end+1))) {
                return true;
            }
            return false;
        }

        if (wd.contains(s.substring(start, end+1))) {
            if (solve(end+1, end+1, s, wd)) {
                return true;
            }
        }

        return solve(start, end+1, s, wd);
    }

    public static boolean wordBreak(String s,List<String> wordDict){
        return solve(0, 0, s, new HashSet<>(wordDict));
    }

    public static void main(String[] args) {
        List<String> wordDict= Arrays.asList("leet","code");
        String s = "leetcode";

        boolean ans=wordBreak(s, wordDict);
        
        System.out.println(ans);
    }
}
