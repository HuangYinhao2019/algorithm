package exam.written.netease;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author liusandao
 * @description NeTease4
 * @date 2020-4-7 20:02
 */
public class NeTease4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[N][M];
        int[][] ans  = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = s.charAt(j) - '0';
                if (grid[i][j] == 0){
                    ans[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0){
                    boolean[][] visited = new boolean[N][M];
                    Queue<int[] > q = new LinkedList<int[] >();
                    q.offer(new int[]{i+1,j});
                    q.offer(new int[]{i-1,j});
                    q.offer(new int[]{i,j+1});
                    q.offer(new int[]{i,j-1});
                    int deep = 1;
                    while (!q.isEmpty()){
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int[] ij = q.poll();
                            if (ij[0] < 0 || ij[0] >= N || ij[1] < 0 || ij[1] >= M || visited[ij[0]][ij[1]]){
                                continue;
                            }
                            else if (grid[ij[0]][ij[1]] == 0 || ans[ij[0]][ij[1]] <= deep){
                                continue;
                            }
                            else {
                                visited[ij[0]][ij[1]] = true;
                                ans[ij[0]][ij[1]] = deep;
                                q.offer(new int[]{ij[0]+1,ij[1]});
                                q.offer(new int[]{ij[0]-1,ij[1]});
                                q.offer(new int[]{ij[0],ij[1]+1});
                                q.offer(new int[]{ij[0],ij[1]-1});
                            }
                        }
                        deep++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0){
                    System.out.print(" ");
                }
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }

}
