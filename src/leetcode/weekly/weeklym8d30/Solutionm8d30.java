package leetcode.weekly.weeklym8d30;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-30 10:33
 */

public class Solutionm8d30 {

    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i + (m * k) - 1 < arr.length; i++) {
            int[] num = new int[m];
            for (int j = 0; j < m; j++) {
                num[j] = arr[i + j];
            }
            boolean b = true;
            for (int j = 1; j < k; j++) {
                for (int q = 0; q < m; q++) {
                    if (arr[i + (j * m) + q] != num[q]) {
                        b = false;
                        break;
                    }
                }
                if (!b) {
                    break;
                }
            }
            if (b) {
                return true;
            }
        }
        return false;
    }

    public int getMaxLen(int[] nums) {
        int[][] dp = new int[nums.length][2];
        if (nums[0] > 0) {
            dp[0][0] = 1;
            dp[0][1] = 0;
        } else if (nums[0] < 0){
            dp[0][0] = 0;
            dp[0][1] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] == 0 ? 0 : dp[i - 1][1] + 1;
            } else if (nums[i] < 0) {
                dp[i][0] = dp[i - 1][1] == 0 ? 0 : dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

    public int minDays(int[][] grid) {
        List<List<Integer>> land = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    land.add(new ArrayList<>());
                    land.get(land.size() - 1).add(i);
                    land.get(land.size() - 1).add(j);
                }
            }
        }
        int count = isLand(grid);
        if (count != 1) {
            return 0;
        }
        for (List<Integer> integers : land) {
            int x = integers.get(0);
            int y = integers.get(1);
            grid[x][y] = 0;
            count = isLand(grid);
            if (count != 1) {
                return 1;
            }
            grid[x][y] = 1;
        }
        return 2;
    }

    private int isLand(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !visited[i][j] && grid[i][j] == 1) {
            visited[i][j] = true;
            dfs(grid, i + 1, j, visited);
            dfs(grid, i - 1, j, visited);
            dfs(grid, i, j + 1, visited);
            dfs(grid, i, j - 1, visited);
        }
    }
}
