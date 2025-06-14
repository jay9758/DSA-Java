//https://leetcode.com/problems/count-primes/submissions/1558882152/
//optimal

class Prime_no_2toN_Sieve_of_Eratosthenes {

    public static void primeNo(int n){
        int[] prime=new int[n+1];
        for (int i = 2; i <= n; i++) {
            prime[i]=1;
        }
        for (int i = 2; i*i <= n; i++) {
            if (prime[i]==1) {
                for (int j = i*i; j <= n; j=j+i) {
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