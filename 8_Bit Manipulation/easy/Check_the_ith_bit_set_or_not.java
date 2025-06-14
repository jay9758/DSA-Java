//https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1

public class Check_the_ith_bit_set_or_not {
    public static void main(String[] args) {
        int n=13;
        int i=2;
        if((n & (1<<i)) != 0){        // 1101
            System.out.println(true); // 0100
        }                             // 0100
        else{
            System.out.println(false);
        }
        //2nd method
        // if(((n>>i) & 1) != 0){
        //     System.out.println(true);
        // }
        // else{
        //     System.out.println(false);
        // }
    }
}
