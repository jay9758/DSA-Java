//optimal
//https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1

import java.util.HashMap;
import java.util.Map;

public class Fruit_Into_Baskets2 {

    public static int fruitInBasket(int[] arr,int b){
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int max=0;
        while (r<n) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            //System.out.println(map);
            if (map.size()>b) {
                map.replace(arr[l], map.get(arr[l])-1);
                if (map.get(arr[l])==0) {
                    map.remove(arr[l]);
                }
                l++;
            }
            if (map.size()<=b) {
                int len=r-l+1;
                max=Math.max(max, len);
            }
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={3,3,3,1,2,1,1,2,3,3,4};
        int b=2;

        int ans=fruitInBasket(arr,b);
        System.out.println(ans);
     }
}
