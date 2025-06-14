//https://leetcode.com/problems/count-number-of-nice-subarrays/

public class number_of_nice_subarrays {

    public static int countSubarray(int[] nums,int g){
        if (g<0) {
            return 0;
        }
        int n=nums.length;
        int l=0;
        int r=0;
        int sum=0;
        int count=0;
        while (r<n) {
            sum=sum+(nums[r]%2);
            while (sum>g) {
                sum=sum-(nums[l]%2);
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        //System.out.println(count);
        return count;
    }

    public static int niceSubarray(int[] nums,int k){
        return countSubarray(nums,k) - countSubarray(nums,k-1);
    }
     public static void main(String[] args) {
        int[] nums={1,1,2,1,1};
        int k=3;

        int ans=niceSubarray(nums,k);
        System.out.println(ans);
     }
}
