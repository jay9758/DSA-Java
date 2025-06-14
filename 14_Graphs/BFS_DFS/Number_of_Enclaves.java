//https://leetcode.com/problems/number-of-enclaves/submissions/1659714705/

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;

    Pair(int row,int col) {
        this.row=row;
        this.col=col;
    }
}

public class Number_of_Enclaves {

    public static void bfs(int[][] grid, int[][] vis, Queue<Pair> q) {
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int r=q.peek().row;
            int c=q.peek().col;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }

    public static int noOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<Pair> q=new LinkedList<>();

        //fist & last row/col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1) {
                    vis[i][j]=1;
                    q.offer(new Pair(i,j));
                }
            }
        }

        bfs(grid, vis, q);

        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && grid[i][j]==1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
        {0,0,0,1,1},
        {0,0,1,1,0},
        {0,1,0,0,0},
        {0,1,1,0,0},
        {0,0,0,1,1}};

        int ans=noOfEnclaves(grid);

        System.out.println(ans);
    }
}
