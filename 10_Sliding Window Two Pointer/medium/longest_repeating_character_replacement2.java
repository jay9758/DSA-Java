//optimal
//https://leetcode.com/problems/longest-repeating-character-replacement/

import java.util.HashMap;
import java.util.Map;

public class longest_repeating_character_replacement2 {

    public static int longestRepeatCharReplace(String s,int k){
        int n=s.length();
        int l=0;
        int r=0;
        int maxLen=0;
        int maxFreq=0;
        Map<Character,Integer> map=new HashMap<>();

        while (r<n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            //System.out.println(map);
            maxFreq=Math.max(maxFreq, map.get(s.charAt(r)));
            if ((r-l+1) - maxFreq > k) {
                map.replace(s.charAt(l), map.get(s.charAt(l))-1);
                if (map.get(s.charAt(l))==0) {
                    map.remove(s.charAt(l));
                }
                maxFreq=0;
                l++;
            }
            if ((r-l+1) - maxFreq <= k) {
                maxLen=Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
      public static void main(String[] args) {
        String s="AAABBCCD";
        int k=2;

        int length=longestRepeatCharReplace(s,k);
        System.out.println(length);
      }
}
