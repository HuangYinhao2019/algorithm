package leetcode.biweekly.biweeklym7d11;/**
 * @description Solutionm7d11
 * @author liusandao
 * @date 2020-7-11 22:43
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-07-11 22:43
 */

public class Solutionm7d11 {

    public String reformatDate(String date) {
        String[] str = date.split(" ");
        String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String a = str[0].substring(0, str[0].length() - 2);
        if (a.length() == 1){
            a = "0".concat(a);
        }
        String b = "";
        for (int i = 0; i < month.length; i++) {
            if (str[1].equals(month[i])){
                b = String.valueOf(i + 1);
            }
        }
        if (b.length() == 1){
            b = "0".concat(b);
        }
        String c = str[2];
        return c.concat("-").concat(b).concat("-").concat(a);
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        int res = 0;
        for (int i = left - 1; i < right; i++) {
            res = (res + list.get(i)) % 1000000007;
        }
        return res;
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4){
            return 0;
        } else {
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= 3; i++) {
                min = Math.min(min, nums[right - i] - nums[left + (3 - i)]);
            }
            return min;
        }
    }

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            int k = 1;
            dp[i] = false;
            while (i - (k * k) >= 0){
                if (!dp[i - (k * k)]){
                    dp[i] = true;
                    break;
                }
                k++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solutionm7d11 s = new Solutionm7d11();
        System.out.println(s.winnerSquareGame(17));
    }

}
