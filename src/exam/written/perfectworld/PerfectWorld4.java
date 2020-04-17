package exam.written.perfectworld;

import java.util.Scanner;

/**
 * @author liusandao
 * @description PerfectWorld4
 * @date 2020-4-14 19:46
 */
public class PerfectWorld4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, W;
        N = sc.nextInt();
        W = sc.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[N][W+1];
        for (int i = 0; i <= W; i++) {
            dp[0][i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-1][W]);

    }

}
