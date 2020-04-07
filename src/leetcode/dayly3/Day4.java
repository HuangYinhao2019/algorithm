package leetcode.dayly3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Day4 {

    public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        Set<Integer> set = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int ans = 0;
        int fresh = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 2) {
                    set.add(i * 11 + j);
                    q.offer(i * 11 + j);
                }
                else if (grid[i][j] == 1)
                    fresh++;
                else
                    set.add(i * 11 + j);
        while (!q.isEmpty()){
            int size = q.size();
            for (int p = 0; p < size; p++) {
                int k = q.poll();
                int i = k / 11, j = k % 11;
                if (i - 1 >= 0 && grid[i-1][j] == 1 && !set.contains((i - 1) * 11 + j)){
                    q.offer((i - 1) * 11 + j);
                    set.add((i - 1) * 11 + j);
                    fresh--;
                }
                if (i + 1 < r && grid[i+1][j] == 1 && !set.contains((i + 1) * 11 + j)){
                    q.offer((i + 1) * 11 + j);
                    set.add((i + 1) * 11 + j);
                    fresh--;
                }
                if (j - 1 >= 0 && grid[i][j-1] == 1 && !set.contains(i * 11 + j - 1)){
                    q.offer(i * 11 + j - 1);
                    set.add(i * 11 + j - 1);
                    fresh--;
                }
                if (j + 1 < c && grid[i][j+1] == 1 && !set.contains(i * 11 + j + 1)){
                    q.offer(i * 11 + j + 1);
                    set.add(i * 11 + j + 1);
                    fresh--;
                }
            }
            if (!q.isEmpty())
                ans ++;
        }
        if (fresh == 0)
            return ans;
        else
            return -1;
    }

    public static void main(String[] args) {
        Day4 d = new Day4();
        int[][] grid = new int[][]{{0,2,2}};
        System.out.println(d.orangesRotting(grid));
    }

}
