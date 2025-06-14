//https://leetcode.com/problems/divide-two-integers/

public class Divide_integers_without_using_multiply_divide_mod {

    public static int divide(int dividend,int divisor){

        if (dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
        if (dividend==divisor) {
            return 1;
        }
        boolean sign=true;
        if (dividend>=0 && divisor<0) {
            sign=false;
        }
        else if (dividend<=0 && divisor>0) {
            sign=false;
        }

        long n= Math.abs((long)dividend);
        long d= Math.abs((long)divisor);

        int ans=0;
        while (n>=d) {
            int count=0;
            while (n >= (d<<(count+1))) {
                count++;
            }
            ans += (1<<count);
            n -= (d<<count);
        }

        return sign ? ans : -ans;
    }
    public static void main(String[] args) {
        int n=22;
        int d=3;

        int ans=divide(n,d);
        
        System.out.println(ans);
    }
}
