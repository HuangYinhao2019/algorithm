package leetcode.weeklym1d26;

import java.util.ArrayList;
import java.util.List;

public class Solutionm1d26 {
    public int removePalindromeSub(String s) {
        if (s.equals("")) return 0;
        else{
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length()-1-i))
                    return 2;
            }
            return 1;
        }
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        boolean isVegan = veganFriendly == 1 ? true : false;
        int[][] filtered = new int[restaurants.length][2];
        int k = 0; // k变量是筛选后的数据数量
        // 先将数据按要求存储进int[][] filtered
        for (int i=0; i<restaurants.length; i++) {
            if (isVegan) {
                if (restaurants[i][2] == 1 && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                    filtered[k][0] = restaurants[i][0];
                    filtered[k][1] = restaurants[i][1];
                    k ++;
                }
            } else {
                if (restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                    filtered[k][0] = restaurants[i][0];
                    filtered[k][1] = restaurants[i][1];
                    k ++;
                }
            }
        }
        // 再用简单的排序，用两个临时变量就够了
        for (int i=0; i<k-1; i++) {
            int max = filtered[i][1];
            int maxIndex = i;
            for (int j=i+1; j<k; j++) {
                if (filtered[j][1] > max) { // 优先选择rating高
                    max = filtered[j][1];
                    maxIndex = j;
                } else if (filtered[j][1] == max && filtered[j][0] > filtered[maxIndex][0]) { // 次优先选择id高
                    max = filtered[j][1];
                    maxIndex = j;
                }
            }
            int temp0 = filtered[i][0];
            int temp1 = filtered[i][1];
            filtered[i][0] = filtered[maxIndex][0];
            filtered[i][1] = filtered[maxIndex][1];
            filtered[maxIndex][0] = temp0;
            filtered[maxIndex][1] = temp1;
        }
        // 得到结果
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<k; i++) {
            result.add(filtered[i][0]);
        }
        return result;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) return -1;
        else{
            int[][] m = new int[jobDifficulty.length][jobDifficulty.length];
            for (int i = 0; i < jobDifficulty.length; i++) {
                int max = -1;
                for (int j = i; j < jobDifficulty.length; j++) {
                    max = jobDifficulty[j] > max ? jobDifficulty[j] : max;
                    m[i][j] = max;
                }
            }
            int[][] dp = new int[d+1][jobDifficulty.length];
            for (int i = 0; i < d + 1; i++) {
                for (int j = 0; j < jobDifficulty.length; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            int max = -1;
            for (int i = jobDifficulty.length - 1; i >= 0; i--) {
                max = jobDifficulty[i] > max ? jobDifficulty[i] : max;
                dp[1][i] = max;
            }
            for (int i = 2; i <= d; i++) {
                for (int j = jobDifficulty.length - i; j >= 0; j--) {
                    for (int k = j; k <= jobDifficulty.length - i; k++)
                        dp[i][j] = Math.min(dp[i][j], m[j][k] + dp[i-1][k+1]);
                }
            }
            return dp[d][0];
        }
    }

    public static void main(String[] args) {
        Solutionm1d26 s = new Solutionm1d26();
        int[] arr = new int[]{7,1,7,1,7,1};
        System.out.println(s.minDifficulty(arr,3));

    }
}
