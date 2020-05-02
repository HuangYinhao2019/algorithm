package leetcode.special.leetcode2020springteam;/**
 * @description T4
 * @author liusandao
 * @date 2020-4-25 14:53
 */

import java.util.HashSet;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-25 14:53
 */

public class T4 {

    public int splitArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        HashSet<Long> set = new HashSet<>();
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= nums.length; i++){
            dp[i] = dp[i-1] + 1;
            for (int j = 1; j < i; j++) {
                if (set.contains(Long.valueOf(nums[i-1] * 100000 + nums[j-1])) || set.contains(Long.valueOf(nums[j-1] * 100000 + nums[i-1])) || gcd(nums[i-1],nums[j-1]) != 1){
                    set.add(Long.valueOf(nums[i-1] * 100000 + nums[j-1]));
                    set.add(Long.valueOf(nums[j-1] * 100000 + nums[i-1]));
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                    if (dp[i] == 1){
                        break;
                    }
                }
            }
        }
        return dp[nums.length];
    }

    private static int gcd(int a, int b){
        return a == 0 ? b : gcd(b % a,a);
    }

}
