//https://leetcode.com/problems/jump-game/submissions/1572404953/

public class Jump_Game {

    public static boolean isPossible(int[] arr){
        int n=arr.length;
        int maxIdx=0;
        for (int i = 0; i < n; i++) {
            if (i>maxIdx) {
                return false;
            }
            maxIdx=Math.max(maxIdx, i+arr[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,1,1,0,2,5};
        //int[] arr={1,2,4,1,1,0,2,5};

        boolean ans=isPossible(arr);
        System.out.println(ans);
    }
}
