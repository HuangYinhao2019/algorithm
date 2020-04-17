package exam.written.meituan;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan3
 * @date 2020-4-2 18:44
 */
public class MeiTuan3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        float[] p = new float[N];
        float[] score = new float[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextFloat();
        }
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextFloat();
        }
        float[] dp = new float[N];
        float[] g = new float[N];
        dp[0] = p[0] * score[0];
        g[0] = p[0];
        for (int i = 1; i < N; i++) {
            float max = p[i] * score[i];
            float gg = p[i];
            for (int j = 0; j < i; j++) {
                if (dp[j] + (score[i-j-1] * p[i-j-1] * g[j]) > max){
                    max = dp[j] + (score[i-j-1] * p[i-j-1] * g[j]);
                    gg = p[i-j-1] * g[j];
                }
                else if (dp[j] + (score[i-j-1] * p[i-j-1] * g[j]) == max){
                    if (p[i-j-1] * g[j] > gg){
                        gg = p[i-j-1] * g[j];
                    }
                }
            }
            dp[i] = max;
            g[i] = gg;
        }
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        System.out.println(decimalFormat.format(dp[N-1]));
    }
}
