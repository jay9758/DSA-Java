//https://www.naukri.com/code360/problems/subset-sum_630213?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
//partially accepted

public class Check_if_exists_subsequence_with_sum_K {

    public static boolean checkSub(int id,int[] arr,int sum,int k){
        int n=arr.length;
        
        if (id==n) {
            if (sum==k) {
                return true;
            }
            return false;
        }

        if (checkSub(id+1, arr, sum+arr[id], k)==true) {
            return true;
        }
        if (checkSub(id+1, arr, sum, k)==true) {
            return true;
        }
        return false;
    }
     public static void main(String[] args) {
     int[] arr={1,2,3};
     int k=5;

     boolean ans=checkSub(0,arr,0,k);
     System.out.println(ans);
     }
}
