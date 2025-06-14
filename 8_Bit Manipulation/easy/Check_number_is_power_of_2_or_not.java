//https://leetcode.com/problems/power-of-two/

public class Check_number_is_power_of_2_or_not {
    public static void main(String[] args) {
        int n=32;

        if ((n & (n-1))==0) {
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
