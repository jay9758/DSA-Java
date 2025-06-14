//https://leetcode.com/problems/jump-game-ii/submissions/1572450585/

public class Jump_Game_type2 {

    public static int minJump(int[] arr){
        int n=arr.length;
        int jumps=0;
        int l=0;
        int r=0;
        while (r<n-1) {
            int farthest=0;
            for (int i = l; i <= r; i++) {
                farthest=Math.max(farthest, i+arr[i]);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,4,1,1,1,2};

        int ans=minJump(arr);
        System.out.println(ans);
    }
}
