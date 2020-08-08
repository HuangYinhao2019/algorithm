package newcode.topcompetition.m8d08;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-08 20:58
 */

public class NewCodeM8D08 {

    public int solve (int n, int[] a) {
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = a[i] / n;
            a[i] = a[i] % n;
            if (a[i] > i) {
                times[i]++;
            }
        }
        int minTime = Integer.MAX_VALUE;
        int minPos = -1;
        for (int i = 0; i < n; i++) {
            if (times[i] < minTime) {
                minTime = times[i];
                minPos = i;
            }
        }
        return minPos + 1;
    }

    public int Highestscore (int n, int p1, int q1, int m1, int p2, int q2, int m2) {
        int win = 0;
        int lose = 0;
        //  牛妹出石头 p2
        while (p2 > 0) {
            if (m1 > 0) {
                if (m1 > p2) {
                    win += p2;
                    m1 -= p2;
                    p2 = 0;
                } else {
                    win += m1;
                    p2 -= m1;
                    m1 = 0;
                }
            } else if (p1 > 0) {
                if (p1 > p2) {
                    p1 -= p2;
                    p2 = 0;
                } else {
                    p2 -= p1;
                    p1 = 0;
                }
            } else {
                if (q1 > p2) {
                    lose += p2;
                    q1 -= p2;
                    p2 = 0;
                } else {
                    lose += q1;
                    p2 -= q1;
                    q1 = 0;
                }
            }
        }
        //  牛妹出剪刀 q2
        while (q2 > 0) {
            if (p1 > 0) {
                if (p1 > q2) {
                    win += q2;
                    p1 -= q2;
                    q2 = 0;
                } else {
                    win += p1;
                    q2 -= p1;
                    p1 = 0;
                }
            } else if (q1 > 0) {
                if (q1 > q2) {
                    q1 -= q2;
                    q2 = 0;
                } else {
                    q2 -= q1;
                    q1 = 0;
                }
            } else {
                if (m1 > q2) {
                    lose += q2;
                    m1 -= q2;
                    q2 = 0;
                } else {
                    lose += m1;
                    q2 -= m1;
                    m1 = 0;
                }
            }
        }
        //  牛妹出布 m2
        while (m2 > 0) {
            if (q1 > 0) {
                if (q1 > m2) {
                    win += m2;
                    q1 -= m2;
                    m2 = 0;
                } else {
                    win += q1;
                    m2 -= q1;
                    q1 = 0;
                }
            } else if (m1 > 0) {
                if (m1 > m2) {
                    m1 -= m2;
                    m2 = 0;
                } else {
                    m2 -= m1;
                    m1 = 0;
                }
            } else {
                if (p1 > m2) {
                    lose += m2;
                    p1 -= m2;
                    m2 = 0;
                } else {
                    lose += p1;
                    m2 -= p1;
                    p1 = 0;
                }
            }
        }

        return win - lose;
    }

    public int GetNumberOfPath (int n, int m, int x0, int y0, int x1, int y1) {
        long[][] dp = new long[n + 1][m + 1];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i >= x0 && i <= x1 && 1 >= y0 && 1 <= y1) {
                dp[i][1] = 0;
            } else {
                dp[i][1] = dp[i - 1][1];
            }
        }
        for (int j = 2; j <= m; j++) {
            if (1 >= x0 && 1 <= x1 && j >= y0 && j <= y1) {
                dp[1][j] = 0;
            } else {
                dp[1][j] = dp[1][j - 1];
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (i >= x0 && i <= x1 && j >= y0 && j <= y1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }
        return (int)dp[n][m];
    }

    public static void main(String[] args) {
        NewCodeM8D08 newCodeM8D08 = new NewCodeM8D08();
        System.out.println(newCodeM8D08.GetNumberOfPath(4, 4, 2, 2, 3, 3));
    }

}
