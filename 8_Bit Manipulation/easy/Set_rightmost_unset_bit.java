//https://www.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1

public class Set_rightmost_unset_bit {
    public static void main(String[] args) {
        int n=6;

        n=n | (n+1);
        System.out.println(n);
    }
}
