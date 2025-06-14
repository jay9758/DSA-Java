//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

class Count_no_of_bits_to_flipped_to_convert_AtoB {
    public static void main(String[] args) {
        int start=13;
        int goal=7;

        int ans=start ^ goal;
        int count=0;
        while (ans>1) {
            count +=ans&1;
            ans=ans>>1;
        }
        if (ans==1) {
            count=count+1;
        }
        System.out.println(count);
    }  
}