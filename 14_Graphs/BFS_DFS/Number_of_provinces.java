//https://leetcode.com/problems/number-of-provinces/submissions/1596290264/
//https://www.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces

import java.util.ArrayList;

class Number_of_provinces {

    public static void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;

        for (int it : adj.get(node)) {
            if (vis[it]==0) {
                dfs(it, vis, adj);
            }
        }
    }

    public static int noOfProvinces(int[][] arr,int V){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (arr[i][j]==1 && i!=j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        //System.out.println(adj);

        int[] vis=new int[V];
        int count=0;
        for (int i = 0; i < V; i++) {
            if (vis[i]==0) {
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr={{1,1,0},{1,1,0},{0,0,1}};
        int V=3;

        int ans=noOfProvinces(arr, V);
        System.out.println(ans);
    }
}