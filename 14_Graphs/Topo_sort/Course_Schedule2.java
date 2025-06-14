//https://leetcode.com/problems/course-schedule-ii/submissions/1663811466/
//https://www.geeksforgeeks.org/problems/course-schedule/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//slightly change as Course_Schedule1
public class Course_Schedule2 {

    public static List<Integer> canFinish(List<List<Integer>> adj){
        int n = adj.size();
        int[] indgree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indgree[it]++;
            }
        }
        for (int i = 0; i < indgree.length; i++) {
            if (indgree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int it : adj.get(node)) {
                indgree[it]--;
                if (indgree[it] == 0) {
                    q.add(it); 
                }
            }
        }

        if (ans.size()==n) {
            return ans;
        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};
        int n=4;

        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
         for (int[] p : prerequisites) {
            int u = p[1];
            int v = p[0];
            adj.get(u).add(v);
        }

        List<Integer> ans=new ArrayList<>();
        ans=canFinish(adj);
        System.out.println(ans);
    }
}
