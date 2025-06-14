//https://leetcode.com/problems/course-schedule/submissions/1663783496/
//https://www.geeksforgeeks.org/problems/prerequisite-tasks/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule1 {

    public static boolean canFinish(List<List<Integer>> adj){
        int n = adj.size();
        int[] indgree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            for (int it : adj.get(i)) {
                indgree[it]++;
            }
        }
        for (int i = 1; i < n; i++) {
            if (indgree[i] == 0) {
                q.offer(i);
            }
        }

        int cnt=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for (int it : adj.get(node)) {
                indgree[it]--;
                if (indgree[it] == 0) {
                    q.add(it); 
                }
            }
        }

        if (cnt==n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites={{1,2},{2,4},{4,3},{4,1}};
        int n=4;

        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
         for (int[] p : prerequisites) {
            int u = p[0];
            int v = p[1];
            adj.get(u).add(v);
        }

        boolean ans=canFinish(adj);
        System.out.println(ans);
    }
}
