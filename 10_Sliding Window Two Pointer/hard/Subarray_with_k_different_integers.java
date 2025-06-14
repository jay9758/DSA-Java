//https://leetcode.com/problems/subarrays-with-k-different-integers/

import java.util.HashMap;
import java.util.Map;

public class Subarray_with_k_different_integers {

    public static int countSubarray(int[] arr,int k){
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int l=0;
        int r=0;
        while (r<n) {
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
            while (map.size()>k) {
                map.replace(arr[l], map.get(arr[l])-1);
                if (map.get(arr[l])==0) {
                    map.remove(arr[l]);
                }
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        return count;
    }

    public static int noOfSubarrays(int[] arr,int k){
        return countSubarray(arr, k) - countSubarray(arr, k-1);
    }

    public static void main(String[] args) {
        int[] arr={2,1,1,1,3,4,3,2};
        int k=3;

        int length=noOfSubarrays(arr,k);
        System.out.println(length);
    }
}
