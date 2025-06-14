//https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

    public static String minSubstring(String s,String t){
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        String minString=s;
        int l=0;
        int r=0;
        int count=0;
        int idx=-1;
        int length=Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0)+1);
        }
        while (r<n) {
            //System.out.println(map);
            if (map.containsKey(s.charAt(r)) && map.get(s.charAt(r))>0) {
                count++;
                map.replace(s.charAt(r), map.get(s.charAt(r))-1);
            }
            else{
                map.put(s.charAt(r),map.getOrDefault(s.charAt(r), 0)-1);
            }
            while (count==t.length()) {
                if ((r-l+1) < length) {
                    length=r-l+1;
                    idx=l;
                }
                map.replace(s.charAt(l), map.get(s.charAt(l))+1);
                if (map.get(s.charAt(l))>0) {
                    count--;
                }
                l++;
                //System.out.println("l "+l+" idx "+idx+" length "+length);
            }
            r++;
        }
        return idx==-1 ? "" : s.substring(idx, idx+length);
    }

    public static void main(String[] args) {
        String s="ddaaabbca";
        String t="abc";

        String ans=minSubstring(s,t);
        System.out.println(ans);
    }
}
