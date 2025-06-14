//https://leetcode.com/problems/binary-subarrays-with-sum/

public class Binary_subarray_with_sum {

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
            sum=sum+nums[r];
            while (sum>g) {
                sum=sum-nums[l];
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        //System.out.println(count);
        return count;
    }

    public static int subarrayWithSum(int[] nums,int g){
        return countSubarray(nums,g) - countSubarray(nums,g-1);
    }
    public static void main(String[] args) {
        int[] nums={1,0,1,0,1};
        int g=2;

        int ans=subarrayWithSum(nums,g);
        System.out.println(ans);
    }
}
