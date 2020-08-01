package exam.written.safe360;

import java.util.Scanner;

/**
 * @author liusandao
 * @description T4
 * @date 2020-4-16 15:12
 */
public class T4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, a0;
        N = sc.nextInt();
        a0 = sc.nextInt();
        double[][] dp = new double[N+1][a0+1];
        dp[1][0] = 1;
        for (int i = 1; i <= a0; i++) {
            dp[1][i] = (1.0) / (double)(i+1);
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= a0; j++) {
                double sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i-1][k] * ((1.0) / (double)(j + 1));
                }
                dp[i][j] = sum;
            }
        }

        double ans = (double) Math.round(dp[N][a0] * 100000) / 100000;

        System.out.println(ans);

    }

}
