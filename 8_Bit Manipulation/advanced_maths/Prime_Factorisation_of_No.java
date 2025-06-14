//brute

import java.util.ArrayList;
import java.util.List;

public class Prime_Factorisation_of_No {

    //only this function 
    //https://www.geeksforgeeks.org/problems/prime-factorization-using-sieve/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prime-factorization-using-sieve
    public static List<Integer> getFactorisation(int n) {
        List<Integer> ans=new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0) {
                while (n%i==0) {
                    ans.add(i);
                    n=n/i;
                }
            }
        }
        if (n!=1) {
            ans.add(n);
        }
        return ans;
    }

    public static void pf(List<Integer> queries) {
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> list=getFactorisation(queries.get(i));
            System.out.println(list);
        }
    }


    public static void main(String[] args) {
        List<Integer> queries=new ArrayList<>();
        queries.add(16);
        queries.add(30);
        queries.add(24);

        pf(queries);
    }
}