//https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;

public class Substring_Without_Repeating_Character {

    public static int substringWithoutRepeat(String s){
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int maxLength=0;
        while (right<n) {
            if (map.containsKey(s.charAt(right))) {
                if (map.get(s.charAt(right))>=left) {
                    left=map.get(s.charAt(right))+1;
                }
            }
            int len=right-left+1;
            maxLength=Math.max(maxLength, len);
            map.put(s.charAt(right), right);
            right++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s="cadbzabcd";

        int length=substringWithoutRepeat(s);
        System.out.println(length);
    }
}