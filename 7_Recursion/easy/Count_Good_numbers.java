//https://leetcode.com/problems/count-good-numbers/
public class Count_Good_numbers {

    private static int mod = (int) 1e9 + 7;

    public static long calpow(int x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        long half = calpow(x, n / 2);
        long res = (half * half) % mod;
        if (n % 2 == 1) {
            return (res * x) % mod;
        }
        return res % mod;
    }

    public static int goodSt(long n){
        long even=(n+1)/2;
        long odd=n/2;
        long a=calpow(5,even) % mod;
        long b=calpow(4,odd) % mod;
        return (int)((a*b) % mod);
    }
    public static void main(String[] args) {
        int n = 1;

        int ans = goodSt(n);
        System.out.println(ans);
    }
}
