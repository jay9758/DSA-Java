

public class Surrounded_Regions {

    public static void dfs(char[][] board, int[][] vis, int r, int c) {
        int n = board.length;
        int m = board[0].length;
        vis[r][c] = 1;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(board, vis, nrow, ncol);
            }
        }
    }

    public static void replaceOwithX(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        //fist & last row
        for (int j = 0; j < m; j++) {
            if (vis[0][j]==0 && board[0][j]=='O') {
                dfs(board, vis, 0, j);
            }
            if (vis[n-1][j]==0 && board[n-1][j]=='O') {
                dfs(board, vis, n-1, j);
            }
        }

        //fist & last col
        for (int i = 0; i < n; i++) {
            if (vis[i][0]==0 && board[i][0]=='O') {
                dfs(board, vis, i, 0);
            }
            if (vis[i][m-1]==0 && board[i][m-1]=='O') {
                dfs(board, vis, i, m-1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
        {'X', 'X', 'X', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'X', 'O', 'O'}};

        replaceOwithX(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }
}
