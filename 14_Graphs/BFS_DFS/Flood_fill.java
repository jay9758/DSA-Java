//https://leetcode.com/problems/flood-fill/

public class Flood_fill {

    public static void fill(int[][] image, int sr, int sc, int color, int[][] ans, int initialcolor) {
        int n = image.length;
        int m = image[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = sr + drow[i];
            int ncol = sc + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialcolor && ans[nrow][ncol] != color) {
                ans[nrow][ncol] = color;
                fill(image, nrow, ncol, color, ans, initialcolor);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];

        int initialcolor = image[sr][sc];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = image[i][j];
            }
        }
        ans[sr][sc] = color;

        fill(image, sr, sc, color, ans, initialcolor);
        return ans;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {2, 2, 0}, {2, 2, 2}};
        int sr = 2;
        int sc = 0;
        int color = 3;

        int[][] ans = floodFill(image, sr, sc, color);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
