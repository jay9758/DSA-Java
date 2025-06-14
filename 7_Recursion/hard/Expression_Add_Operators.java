//https://leetcode.com/problems/expression-add-operators/submissions/1556118550/
//https://youtu.be/WcgjFrZceU8?si=rqO1cccK7dn6ztDZ

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {

    public static void addOperators(int i,String path,long resSoFar,long prevNo,String s,int target,List<String> ans){
        if (i==s.length()) {
            if (resSoFar==target) {
                ans.add(path);
                return;
            }
        }
        for (int j = i; j < s.length(); j++) {
            if (j!=i && s.charAt(i)=='0') {
                break;
            }
            long currNo=Long.parseLong(s.substring(i, j+1));
            if (i==0) {
                addOperators(j+1, path+currNo, currNo, currNo, s, target, ans);
            }
            else{
                addOperators(j+1, path+"+"+currNo, resSoFar+currNo, currNo, s, target, ans);
                addOperators(j+1, path+"-"+currNo, resSoFar-currNo, -currNo, s, target, ans);
                addOperators(j+1, path+"*"+currNo, resSoFar-prevNo+prevNo*currNo, prevNo*currNo, s, target, ans);
            }
        }
    }
    public static void main(String[] args) {
        String s="1023";
        int target=6;

        List<String> ans=new ArrayList<>();
        addOperators(0, "", 0, 0, s, target,ans);

        System.out.println(ans);

    }
}
