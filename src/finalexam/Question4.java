package finalexam;

public class Question4 {
    public static void main(String[] args) {
        // Time Complexity O(m x n)
        int[][] obstacleGrid1 = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid2 = new int[][]{{0, 1}, {0, 0}};
        System.out.println(findWays(obstacleGrid1));
    }

    public static int findWays(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][0] != 1) dp[i][0] = 1;
            else dp[i][0] = 0;
        }
        for(int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] != 1) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid.length; j++) {
                if(grid[i][j] != 1) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else dp[i][j] = 0;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}