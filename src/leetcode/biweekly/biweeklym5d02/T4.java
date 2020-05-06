package leetcode.biweekly.biweeklym5d02;/**
 * @description T4
 * @author liusandao
 * @date 2020-5-4 14:00
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: Hats Problem
 * @author: liusandao
 * @date 2020-05-04 14:00
 */

public class T4 {
    public static final int MOD = 1000000007;
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<List<Integer>> peo = new ArrayList<>(41);
        for (int i = 0; i < 41; i++) {
            peo.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < hats.get(i).size(); j++) {
                peo.get(hats.get(i).get(j)).add(i);
            }
        }
        int[][] dp = new int[1 << n][41];
        dp[0][0] = 1;

        for (int i = 1; i < 41; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[j][i] = dp[j][i-1];
                for (int k = 0; k < n; k++) {
                    if (((1 << k) & j) != 0){
                        if (peo.get(i).contains(k)){
                            dp[j][i] = (dp[j][i] + dp[j - (1 << k)][i - 1]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1][40];
    }
}
