package leetcode.biweekly.biweeklym6d13;/**
 * @description Solutionm6d13
 * @author liusandao
 * @date 2020-6-13 22:17
 */

import java.util.Arrays;
import java.util.Map;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-06-13 22:17
 */

public class Solutionm6d13 {

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
            if (ans[i] == -1){
                ans[i] = prices[i];
            }
        }
        return ans;
    }

    public int minSumOfLengths(int[] arr, int target) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        int i = 0, j = 0;
        int sum = 0;
        while (j < arr.length){
            if (j > 0){
                left[j] = left[j - 1];
            }
            sum += arr[j];
            if (sum == target){
                left[j] = Math.min(left[j], j - i + 1);
            } else if (sum > target){
                while (i <= j && sum > target){
                    sum -= arr[i];
                    if (sum == target){
                        left[j] = Math.min(left[j], j - i);
                        i++;
                        break;
                    }
                    i++;
                }
            }
            j++;
        }
        i = arr.length - 1;
        j = arr.length - 1;
        sum = 0;
        while (i >= 0){
            if (i < arr.length - 1){
                right[i] = right[i + 1];
            }
            sum += arr[i];
            if (sum == target){
                right[i] = Math.min(right[i], j - i + 1);
            } else if (sum > target){
                while (i <= j && sum > target){
                    sum -= arr[j];
                    if (sum == target){
                        right[i] = Math.min(right[i], j - i);
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i--;
        }

        int ans = Integer.MAX_VALUE;
        for (i = 0; i < arr.length - 1; i++) {
            if (left[i] != Integer.MAX_VALUE && right[i + 1] != Integer.MAX_VALUE) {
                ans = Math.min(left[i] + right[i + 1], ans);
            }
            if (ans == 2){
                break;
            }
        }
        if (ans == Integer.MAX_VALUE){
            return -1;
        } else {
            return ans;
        }

    }

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int[][] dp = new int[houses.length][k + 1];
        for (int i = 0; i < houses.length; i++) {
            dp[i][1] = getDistance(houses, 0, i);
        }

        for (int t = 2; t <= k; t++) {
            for (int i = 0; i < houses.length; i++) {
                dp[i][t] = Integer.MAX_VALUE;
                if (i < t){
                    dp[i][t] = 0;
                } else {
                    for (int j = 0; j < i; j++) {
                        dp[i][t] = Math.min(dp[i][t], dp[j][t - 1] + getDistance(houses, j + 1, i));
                    }
                }
            }
        }
        return dp[houses.length - 1][k];
    }

    public int getDistance(int[] houses, int begin, int end){
        int number = end - begin + 1;
        int mid = 0;
        mid = houses[(end + begin) / 2];

        int dsum = 0;
        for (int i = begin; i <= end; i++) {
            dsum += Math.abs(houses[i] - mid);
        }
        return dsum;
    }

    public static void main(String[] args) {
        Solutionm6d13 s = new Solutionm6d13();
        int[] houses = new int[]{10,11,24,7,20,29};
        System.out.println(s.minDistance(houses, 4));
        System.out.println(s.getDistance(houses, 0, 2));
    }

}
