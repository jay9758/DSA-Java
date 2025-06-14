//https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

class Assign_Cookies {

    public static int assignCookies(int[] greed,int[] size){
        Arrays.sort(greed);
        Arrays.sort(size);
        int n=greed.length;
        int m=size.length;
        int l=0;
        int r=0;
        while (l<m && r<n) {
            if (size[l]>=greed[r]) {
                r++;
            }
            l++;
        }
        return r;
    }
    public static void main(String[] args) {
        int[] greed={1,5,3,3,4};
        int[] size={4,2,1,2,1,3};

        int ans=assignCookies(greed,size);
        System.out.println(ans);
    }   
}