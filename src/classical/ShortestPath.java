package classical;

import java.util.*;

public class ShortestPath {
    private int[][] path;

    public int[] Dijkstra(int[][] grid, int index){
        //节点个数
        int n = grid.length;
        //index到各个节点的最短距离
        int[] shortest = new int[n];
        //OPEN表
        boolean[] visited = new boolean[n];
        //存储路径
        String[] path = new String[n];
        for (int i = 0; i < grid.length; i++) {
            path[i] = new String(index + "->" + i);
        }

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
                    path[j] = path[p] + "->" + j;
                }
            }

        }
        return shortest;
    }

    public int[][] Floyd(int[][] grid){
        int n = grid.length;
        path = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = -1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][k] + grid[k][j] < grid[i][j]){
                        grid[i][j] = grid[i][k] + grid[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        return grid;
    }

    private void findpath(int i, int j){
        int m = path[i][j];
        if (m == -1)
            return;
        findpath(i,m);
        System.out.println("->" + m);
        findpath(m,j);
    }

    public static void main(String[] args) {

    }
}
