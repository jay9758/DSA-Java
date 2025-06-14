//https://leetcode.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static boolean isPalindrome(String s,int start,int end){
        while (start<=end) {
            if (s.charAt(start++)!=s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public static void Partitioning(int id,String s,List<String> part,List<List<String>> ls){
        int n=s.length();
        if (id==n) {
            ls.add(new ArrayList<>(part));
            return;
        }
        
        for (int i = id; i < n; i++) {
            if (isPalindrome(s, id, i)) {
                part.add(s.substring(id,i+1));
                Partitioning(i+1, s, part, ls);
                part.remove(part.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        String s="aabb";
        int n=s.length();
        List<String> part=new ArrayList<>();
        List<List<String>> ls=new ArrayList<>();

        Partitioning(0,s,part,ls);
        
        for (List<String> parti : ls) {
            System.out.println(parti);
        }
    }
}
