//https://leetcode.com/problems/asteroid-collision/

import java.util.LinkedList;
import java.util.List;

public class Asteroid_Collision {

    public static List<Integer> asteroidCollision(int[] arr){
        int n=arr.length;
        List<Integer> ls=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i]>0) {
                ls.add(arr[i]);
            }
            else{
                System.out.println(ls);
                while (ls.size()!=0 && ls.get(ls.size()-1)>0 && ls.get(ls.size()-1)<Math.abs(arr[i])) {
                    ls.remove(ls.size()-1);
                }
                if (ls.size()!=0 && ls.get(ls.size()-1)==Math.abs(arr[i])) {
                    ls.remove(ls.size()-1);
                }
                else if (ls.size()==0 || ls.get(ls.size()-1)<0) {
                    ls.add(arr[i]);
                }
            }
        }
        return ls;
    }
    public static void main(String[] args) {
        int[] arr={4,7,1,1,2,-3,-7,17,15,-16};

        List<Integer> ls=asteroidCollision(arr);
        System.out.println(ls);
    }
}
