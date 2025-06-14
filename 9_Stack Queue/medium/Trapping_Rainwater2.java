//optimal
//https://leetcode.com/problems/trapping-rain-water/

public class Trapping_Rainwater2 {

    public static int traprainwater(int[] arr){
        int n=arr.length;
        int total=0;
        int leftMax=0;
        int rightMax=0;
        int l=0;
        int r=n-1;
        while (l<=r) {
            if (leftMax<=rightMax) {
                if (leftMax>arr[l]) {
                    total += leftMax-arr[l];                
                }
                else{
                    leftMax=arr[l];
                }
                l++;
            }
            else{
                if (rightMax>arr[r]) {
                    total += rightMax-arr[r];
                }
                else{
                    rightMax=arr[r];
                }
                r--;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[] arr={4,2,0,3,2,5};
        //int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        
        int ans=traprainwater(arr);
        System.out.println(ans);
    }
}
