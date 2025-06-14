//https://leetcode.com/problems/single-number/description/

public class No_appear_single_time {
    public static void main(String[] args) {
        int[] arr={4,1,2,1,2};

        int xor=0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor^arr[i];
        }
        System.out.println(xor);
    }
}
