public class Power_of_n_to_x {

    public static void power(double x,int n){
        int m=n;
        n=Math.abs(n); //make positive
        double ans=1;
        while (n>0) {
            if (n%2==1) {
                ans=ans*x;
                n=n-1;
            }
            else{
                x=x*x;
                n=n/2;
            }
        }
        if (m<0) {
            ans=1/ans;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int x=2;
        int n=5;

        power(x,n);
    }
}
