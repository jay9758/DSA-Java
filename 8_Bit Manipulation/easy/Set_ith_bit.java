
public class Set_ith_bit {
    public static void main(String[] args) {
        int n=9; //1001
        int i=2;

        n=(n | 1<<i);         //9 or 100
        System.out.println(n);
    }
}
