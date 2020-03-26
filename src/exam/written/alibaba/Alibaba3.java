package exam.written.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba3
 *              3-25 16:00-17:00场第二题
 * @date 2020-3-25 15:42
 */
public class Alibaba3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int res = Integer.MAX_VALUE;
        int[][] arr = new int[3][N];
        int[][] dp = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < 3; i++) {
                dp[i][j%2] = Math.min(dp[i][j%2],Math.abs(arr[i][j] - arr[0][j-1])  + dp[0][(j+1)%2]);
                dp[i][j%2] = Math.min(dp[i][j%2],Math.abs(arr[i][j] - arr[1][j-1])  + dp[1][(j+1)%2]);
                dp[i][j%2] = Math.min(dp[i][j%2],Math.abs(arr[i][j] - arr[2][j-1])  + dp[2][(j+1)%2]);
            }
            dp[0][(j+1)%2] = Integer.MAX_VALUE;
            dp[1][(j+1)%2] = Integer.MAX_VALUE;
            dp[2][(j+1)%2] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < 3; i++) {
            res = Math.min(res,dp[i][(N+1)%2]);
        }
        System.out.println(res);

    }

}
