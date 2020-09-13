package alibaba.cloud.competition;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-09-13 09:52
 */

public class TianChiFinals {

    public long shortestTime(long n, int p, int v) {
        if (n == 1) {
            return 0;
        }
        long res = n * p + v;
        if (n <= 4) {
            return res;
        }
        for (long i = 2; i < 1000; i++) {
            double a = 1d / (double)i;
            double q = Math.pow((double)n, a);
            long l = (long)q, r = (long)Math.ceil(q);
            if (l == r) {
                res = Math.min(res, i * l * p + i * v);
            } else {
                for (long j = 0; j <= i; j++) {
                    long t = pow(r, j) * pow(l, (i - j));
                    if (t >= n) {
                        long temp = (j * r + (i - j) * l) * p + i * v;
                        res = Math.min(res, temp);
                        break;
                    }
                }
            }
        }
        return res;
    }

    private long pow (long a, long b){
        if (b == 0) {
            return 1;
        } else {
            return a * pow(a, b - 1);
        }
    }

    public int key(String s) {
        int[][] dp = new int[10][10];
        boolean[] visited = new boolean[10];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - '0';
            visited[k] = true;
            for (int j = 0; j < 10; j++) {
                if (j != k) {
                    if (dp[k][j] >= 0) {
                        dp[k][j]++;
                    } else {
                        dp[k][j] = 0;
                    }
                    if (visited[j]) {
                        max = Math.max(max, dp[k][j]);
                    }
                    dp[j][k]--;
                    max = Math.max(max, dp[j][k]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TianChiFinals t = new TianChiFinals();
        System.out.println(t.key("21222"));
    }

}
