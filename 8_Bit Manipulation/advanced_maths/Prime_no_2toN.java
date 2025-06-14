//better

public class Prime_no_2toN {

    public static void primeNo(int n){
        int[] prime=new int[n+1];
        for (int i = 2; i <= n; i++) {
            prime[i]=1;
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]==1) {
                for (int j = 2*i; j <= n; j=j+i) {
                    prime[j]=0;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]==1) {
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        int n=30;

        primeNo(n);
    }
}
