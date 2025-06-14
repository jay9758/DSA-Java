//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/0

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

public class Number_of_Distinct_Islands {

    public static void bfs(int row,int col,int[][] grid,int[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col]=1;

        int[] drow={-1,-1,0,1,1,1,0,-1};
        int[] dcol={0,1,1,1,0,-1,-1,-1};

        while (!q.isEmpty()) {
            int r=q.peek().row;
            int c=q.peek().col;
            q.poll();

            for (int i = 0; i < 8; i++) {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }

    public static int noOfIslands(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];

        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && grid[i][j]==1) {
                    bfs(i,j,grid,vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid={
            {0,1,1,0},
            {0,1,1,0},
            {0,0,1,0},
            {0,0,0,0},
            {1,1,0,1}
        };

        int ans=noOfIslands(grid);
        System.out.println(ans);
    }
}
