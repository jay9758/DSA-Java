//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

public class Number_of_substring_containing_all_three_characters {

    public static int subsringOfThreeChar(String s){
        int n=s.length();
        int[] lastSeen={-1,-1,-1};
        int count=0;
        for (int i = 0; i < n; i++) {
            //System.out.println(Arrays.toString(lastSeen));
            lastSeen[s.charAt(i)-'a']=i;
            if (lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1) {
                count=count+(1+Math.min(lastSeen[0], Math.min(lastSeen[1] ,lastSeen[2]) ));
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s="bbacba";

        int ans=subsringOfThreeChar(s);
        System.out.println(ans);
    }
}
