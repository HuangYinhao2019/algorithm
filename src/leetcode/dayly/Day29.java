package leetcode.dayly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liusandao
 * @description Day29
 * @date 2020-3-29 10:02
 */
public class Day29 {

    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        if (q.size() == 0 || q.size() == grid.length * grid[0].length){
            return -1;
        }
        int count1 = q.size();
        int count2 = 0;
        int Max = 0;
        while(count1!=0){
            int[] ij = q.poll();
            int i = ij[0], j = ij[1];
            count1--;
            if (i-1>=0&&!visited[i-1][j]){
                visited[i-1][j] = true;
                q.offer(new int[]{i-1,j});
                count2++;
            }
            if (i+1<grid.length&&!visited[i+1][j]){
                visited[i+1][j] = true;
                q.offer(new int[]{i+1,j});
                count2++;
            }
            if (j-1>=0&&!visited[i][j-1]){
                visited[i][j-1] = true;
                q.offer(new int[]{i,j-1});
                count2++;
            }
            if (j+1<grid[0].length&&!visited[i][j+1]){
                visited[i][j+1] = true;
                q.offer(new int[]{i,j+1});
                count2++;
            }
            if(count1 == 0){
                count1 = count2;
                count2 = 0;
                Max += count1 == 0 ? 0 : 1;
            }

        }
        return Max;
    }

    public static void main(String[] args) {
        System.out.println(new Day29().maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }
}
