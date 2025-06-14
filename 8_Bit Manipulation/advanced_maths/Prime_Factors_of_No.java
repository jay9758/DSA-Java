//https://www.geeksforgeeks.org/problems/prime-factors5052/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=Prime-Factors

import java.util.ArrayList;
import java.util.List;


class Prime_Factors_of_No {

    public static void primeFac(int n,List<Integer> ans){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0) {
                ans.add(i);
                while (n%i==0) {
                    n=n/i;
                }
            }
        }
        if (n!=1) {
            ans.add(n);
        }
    }
    public static void main(String[] args) {
        int n=780;

        List<Integer> ans=new ArrayList<>();
        primeFac(n,ans);
        System.out.println(ans);
    }
}