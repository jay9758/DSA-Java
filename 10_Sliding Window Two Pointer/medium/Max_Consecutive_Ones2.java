//optimal
//https://leetcode.com/problems/max-consecutive-ones-iii/

public class Max_Consecutive_Ones2 {

    public static int maxConsecOnes(int[] arr,int k){
        int n=arr.length;
        int l=0;
        int r=0;
        int zero=0;
        int maxLength=0;
        while (r<n) {
            if (arr[r]==0) {
                zero++;
            }
            if (zero>k) {
                if (arr[l]==0) {
                    zero--;
                }
                l++;
            }
            if (zero<=k) {
                int len=r-l+1;
                maxLength=Math.max(maxLength, len);
            }
            r++;
        }
        return maxLength;
    }
     public static void main(String[] args) {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;

        int length=maxConsecOnes(arr,k);
        System.out.println(length);
     }
}

