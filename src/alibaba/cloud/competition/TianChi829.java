package alibaba.cloud.competition;

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-29 09:50
 */

public class TianChi829 {

    public int treePlanning(int[] trees, int d) {
        int count = 0;
        int pre = 0;
        for (int i = 1; i < trees.length; i++) {
            if (trees[i] - trees[pre] < d) {
                count++;
            } else {
                pre = i;
            }
        }
        return count;
    }

    public int makeEquilateralTriangle(int[] lengths) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < lengths.length; i++) {
            max = Math.max(max, lengths[i]);
            map.put(lengths[i], map.getOrDefault(lengths[i], 0) + 1);
            if (map.get(lengths[i]) == 3) {
                return 0;
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> x : entries) {
            if (x.getValue() == 3) {
                return 0;
            } else if (x.getValue() == 2 && x.getKey() < max) {
                return 1;
            } else if (x.getValue() == 1 && map.containsKey(x.getKey() * 2)) {
                return 1;
            }
        }
        return 2;
    }

    public long suffixQuery(String s) {
        long[][] d = new long[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    long l = d[j + 1][i - 1];
                    if (l == i - j - 1) {
                        d[j][i] = l + 2;
                    } else {
                        d[j][i] = l + 1;
                    }
                }
            }
            d[i][i] = 1;
        }
        long res = 0;
        for (long[] longs : d) {
            for (long aLong : longs) {
                res += aLong;
            }
        }
        return res;
    }

    public long shuttleInBuildings(int[] heights, int k, int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, heights[0]});
        long[] dp = new long[heights.length];
        dp[0] = 0;

        for (int i = 1; i < heights.length; i++) {
            dp[i] = dp[i - 1] + (long) y;
            if (i - 2 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 2] + (long) y);
            }
            while (!stack.isEmpty() && stack.peek()[1] < heights[i] && i - stack.peek()[0] <= k) {
                int[] pre = stack.pop();
                dp[i] = Math.min(dp[i], dp[pre[0]] + (long) x);
            }
            while (!stack.isEmpty() && stack.peek()[1] < heights[i]) {
                stack.pop();
            }
            stack.push(new int[]{i, heights[i]});
        }
        return dp[heights.length - 1];
    }

    public static void main(String[] args) {
        TianChi829 t = new TianChi829();
        System.out.println(t.shuttleInBuildings(new int[]{1, 2, 3, 4, 5, 6}, 3, 10, 6));
//        System.out.println(t.suffixQuery("abba"));
    }

}
