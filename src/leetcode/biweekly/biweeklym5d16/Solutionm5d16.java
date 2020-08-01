package leetcode.biweekly.biweeklym5d16;/**
 * @description Solutionm5d16
 * @author liusandao
 * @date 2020-5-16 22:07
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-16 22:07
 */

public class Solutionm5d16 {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 1){
            return ans;
        } else {
            for (int i = 2; i <= n; i++){
                for (int j = 1; j < i; j++){
                    if (gcd(i, j) == 1){
                        ans.add(j + "/" + i);
                    }
                }
            }
        }
        return ans;
    }

    public int gcd (int a, int b){
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target+1];
        for (int i = 0; i <= target; i++){
            dp[i] = "0";
        }
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] <= target) {
                dp[cost[i]] = String.valueOf(i + 1);
            }
        }
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < cost.length; j++) {
                if (i - cost[j] >= 0 && !dp[i - cost[j]].equals("0")){
                    String str = String.valueOf(j + 1).concat(dp[i - cost[j]]);
                    if (str.length() > dp[i].length()){
                        dp[i] = str;
                    } else if (str.length() < dp[i].length()){
                        continue;
                    } else {
                        if (str.compareTo(dp[i]) > 0){
                            dp[i] = str;
                        }
                    }
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solutionm5d16 s = new Solutionm5d16();
        int[] cost = new int[]{6,10,15,40,40,40,40,40,40};
        System.out.println(s.largestNumber(cost, 47));
    }

}
