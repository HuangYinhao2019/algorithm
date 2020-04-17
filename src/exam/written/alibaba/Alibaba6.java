package exam.written.alibaba;

import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba6
 * @date 2020-4-8 15:57
 */
public class Alibaba6 {
    public static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        ans = new int[T];
        for (int i = 0; i < T; i++) {
            int N, K;
            N = sc.nextInt();
            K = sc.nextInt();
            int[][] A = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    A[j][k] = sc.nextInt();
                }
            }
            dfs(A,0,0,0,A[0][0],K,i);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int dfs(int[][] grid, int i, int j, int now, int sum, int k, int t){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] <= now){
            return sum;
        }
        else {
            sum += grid[i][j];
            for (int p = 1; p <= k; p++) {
                int g = dfs(grid,i+p,j,grid[i][j],sum,k,t);
                ans[t] = Math.max(ans[t],g);
            }
            for (int p = 1; p <= k; p++) {
                int g = dfs(grid,i-p,j,grid[i][j],sum,k,t);
                ans[t] = Math.max(ans[t],g);
            }
            for (int p = 1; p <= k; p++) {
                int g = dfs(grid,i,j+p,grid[i][j],sum,k,t);
                ans[t] = Math.max(ans[t],g);
            }
            for (int p = 1; p <= k; p++) {
                int g = dfs(grid,i,j-p,grid[i][j],sum,k,t);
                ans[t] = Math.max(ans[t],g);
            }
            sum -= grid[i][j];
            return sum;
        }
    }
}
