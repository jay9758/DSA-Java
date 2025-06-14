
public class remove_last_set_bit {
    public static void main(String[] args) {
        int n=40;  //101000 
                   //  ^this
        n=n & (n-1);           //101000 & 100000
        System.out.println(n);
    }
}
