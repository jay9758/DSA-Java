//optimal
//https://www.naukri.com/code360/problems/distinct-characters_2221410

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_with_At_Most_K_Distinct_Characters2 {

    public static int longestSunstring(String s,int k){
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int l=0;
        int r=0;
        while (r<n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            if (map.size()>k) {
                map.replace(s.charAt(l), map.get(s.charAt(l))-1);
                if (map.get(s.charAt(l))==0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if (map.size()<=k) {
                maxLen=Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s="aaabbccd";
        int k=2;

        int length=longestSunstring(s,k);
        System.out.println(length);
    }
}
