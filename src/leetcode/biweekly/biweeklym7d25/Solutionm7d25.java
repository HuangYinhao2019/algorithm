package leetcode.biweekly.biweeklym7d25;/**
 * @description Solutionm7d25
 * @author liusandao
 * @date 2020-7-25 22:29
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-07-25 22:29
 */

public class Solutionm7d25 {

    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return (high - low) / 2 + 1;
        }
    }

    public int numOfSubarrays(int[] arr) {
        int[][] dp = new int[arr.length][2];
        if (arr[0] % 2 == 0){
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = (res + dp[i][1]) % 1000000007;
        }
        return res;
    }

    public int numSplits(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            right[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            left[s.charAt(i) - 'a']++;
            right[s.charAt(i) - 'a']--;
            int ls = 0, rs = 0;
            for (int j = 0; j < 26; j++) {
                if (left[j] != 0) {
                    ls++;
                }
                if (right[j] != 0) {
                    rs++;
                }
            }
            if (ls == rs) {
                res++;
            }
        }
        return res;
    }

}
