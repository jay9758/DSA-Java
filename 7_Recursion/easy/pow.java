//https://leetcode.com/problems/powx-n/
public class pow {

    public static double myPow(double x, int n) {
        double ans = 1;
        long nn = n;
        if (nn < 0) {
            nn = -1 * nn;
        }
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) {
            ans = (double) 1.0 / (double) ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        double x = 2;
        int n = -3;

        double ans = myPow(x, n);
        System.out.println(ans);
    }
}
