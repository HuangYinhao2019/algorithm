package leetcode.special.leetcode2020fall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-09-12 14:55
 */

public class Solution {

    public int calculate(String s) {
        int x = 1, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        final int MOD = 1000000007;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int sum = 0;
        int i = 0, j = drinks.length - 1;
        while (i < staple.length && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                i++;
                sum = (sum + j + 1) % MOD;
            } else {
                j--;
            }
        }
        return sum;
    }

    public int minimumOperations(String leaves) {
        int[] dp = new int[3];
        dp[0] = leaves.charAt(0) == 'r' ? 0 : 1;
        dp[1] = 1000000000;
        dp[2] = 1000000000;
        for (int i = 1; i < leaves.length(); i++) {
            dp[2] = Math.min(dp[2], dp[1]) + (leaves.charAt(i) == 'r' ? 0 : 1);
            dp[1] = Math.min(dp[1], dp[0]) + (leaves.charAt(i) == 'y' ? 0 : 1);
            dp[0] = dp[0] + (leaves.charAt(i) == 'r' ? 0 : 1);
        }
        return dp[2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumOperations("rrryyyrryyyrr"));
    }

}
