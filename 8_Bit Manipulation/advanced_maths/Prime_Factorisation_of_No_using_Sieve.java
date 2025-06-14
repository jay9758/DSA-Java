//optimal

import java.util.ArrayList;
import java.util.List;

public class Prime_Factorisation_of_No_using_Sieve {

    public static void getFactorisation(List<Integer> queries) {
        int n=(int)Math.pow(10, 5);
        int[] spf=new int[n+1];
        for (int i = 1; i <= n; i++) {
            spf[i]=i;
        }
        for (int i = 2; i*i <= n; i++) {
            if (spf[i]==i) {
                for (int j = i*i; j <= n; j=j+i) {
                    if (spf[j]==j) {
                        spf[j]=i;
                    }
                }
            }
        }
        for (int i = 0; i < queries.size(); i++) {
            n=queries.get(i);
            System.out.print("[");
            while (n!=1) {
                System.out.print(spf[n]+" ");
                n=n/spf[n];
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Integer> queries=new ArrayList<>();
        queries.add(16);
        queries.add(30);
        queries.add(24);

        getFactorisation(queries);
    }
}
