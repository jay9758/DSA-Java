//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class Maximum_point_you_can_obtain_from_cards {

    public static int maxSumFromCard(int[] arr,int k){
        int n=arr.length;
        int leftSum=0;
        int rightSum=0;
        int maxSum=0;

        for (int i = 0; i < k; i++) {
            leftSum=leftSum+arr[i];
        }
        maxSum=leftSum;

        int rightIdx=n-1;
        for (int i = k-1; i >= 0 ; i--) {
            leftSum=leftSum-arr[i];
            rightSum=rightSum+arr[rightIdx];
            maxSum=Math.max(maxSum, leftSum+rightSum);
            rightIdx--;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr={6,2,3,4,7,2,1,7,1};
        int k=4;

        int ans=maxSumFromCard(arr,k);
        System.out.println(ans);
    }
}
