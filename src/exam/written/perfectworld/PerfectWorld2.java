package exam.written.perfectworld;

import java.util.Scanner;

/**
 * @author liusandao
 * @description PerfectWorld2
 * @date 2020-4-14 19:38
 */
public class PerfectWorld2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int le = sc.nextInt();
                if (le == -1){
                    grid[i][j] = 100000000;
                }
                else {
                    grid[i][j] = le;
                }
            }
        }

        int[] ans = Dijkstra(grid,0);
        for (int i = 1; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int[] Dijkstra(int[][] grid, int index){
        int n = grid.length;
        int[] shortest = new int[n];
        boolean[] visited = new boolean[n];

        visited[index] = true;
        shortest[index] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int p = -1;
            for (int j = 0; j < grid.length; j++) {
                if (grid[index][j] < min && !visited[j]){
                    min = grid[index][j];
                    p = j;
                }
            }
            shortest[p] = min;
            visited[p] = true;
            for (int j = 0; j < grid.length; j++) {
                if (!visited[j] && grid[index][p] + grid[p][j] < grid[index][j]) {
                    grid[index][j] = grid[index][p] + grid[p][j];
                }
            }

        }
        return shortest;
    }

}
