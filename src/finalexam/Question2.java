package finalexam;

public class Question2 {
    public static void main(String[] args) {
        // Time Complexity O(m x n)
        String[][] grid1 = new String[][]{{"1","1","1","1","0"}, {"1","1","0","1","0"}, {"1","1","0","0","0"}, {"0","0","0","0","0"}};
        String[][] grid2 = new String[][]{{"1","1","0","0","0"}, {"1","1","0","0","0"}, {"0","0","1","0","0"}, {"0","0","0","1","1"}};
        System.out.println(islands(grid2));
    }

    public static int islands(String[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j].equals("1")) {
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void helper(String[][] grid, int i, int j) {
        if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length) {
            if(grid[i][j].equals("1")) {
                grid[i][j] = "2";
                helper(grid, i - 1, j);
                helper(grid, i + 1, j);
                helper(grid, i, j - 1);
                helper(grid, i, j + 1);
            }
        }
    }
}