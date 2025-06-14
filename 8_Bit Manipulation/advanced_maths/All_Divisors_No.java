//https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1?utm_source=youtube&amp%3Butm_medium=collab_striver_ytdescription&amp%3Butm_campaign=all-divisors-of-a-number

import java.util.ArrayList;
import java.util.List;


public class All_Divisors_No {

    public static void divisors(int n,List<Integer> ans){
        for (int i = 1; i*i <= n; i++) {
            if (n%i==0) {
                ans.add(i);
                if (n/i!=i) {
                    ans.add(n/i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int n=36;

        List<Integer> ans=new ArrayList<>(); 
        divisors(n,ans);
        System.out.println(ans);
    }
}
