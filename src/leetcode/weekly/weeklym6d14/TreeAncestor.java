package leetcode.weekly.weeklym6d14;/**
 * @description TreeAncestor
 * @author liusandao
 * @date 2020-6-14 10:52
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-06-14 10:52
 */

public class TreeAncestor {

    private int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][20];
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 20; j++) {
                if (dp[i][j-1] == -1){
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (node == -1){
            return -1;
        } else if (k == 1){
            return dp[node][0];
        } else {
            int i = 1;
            int count = 0;
            while (i * 2 < k){
                i = i * 2;
                count++;
            }
            return getKthAncestor(dp[node][count], k - i);
        }
    }

    public static void main(String[] args) {
        TreeAncestor t = new TreeAncestor(5, new int[]{-1,0,0,0,3});
        t.getKthAncestor(1, 5);
        t.getKthAncestor(3, 2);
        t.getKthAncestor(0, 1);
        t.getKthAncestor(3, 1);
        t.getKthAncestor(3, 5);
    }

}
