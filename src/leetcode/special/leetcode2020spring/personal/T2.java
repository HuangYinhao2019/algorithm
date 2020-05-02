package leetcode.special.leetcode2020spring.personal;/**
 * @description T2
 * @author liusandao
 * @date 2020-4-18 14:57
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-18 14:57
 */

public class T2 {

    public int numWays(int n, int[][] relation, int k) {
        int ans = 0;
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for(int i = 1; i <= k; i++){
            for(int j = 0; j < n; j++){
                for(int p = 0; p < relation.length; p++){
                    if(relation[p][1] == j){
                        dp[i][j] += dp[i-1][relation[p][0]];
                    }
                }
            }
        }
        return dp[k][n-1];
    }

}
