package leetcode.weekly.weeklym5d31;/**
 * @description Solutionm5d31
 * @author liusandao
 * @date 2020-5-31 9:55
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-31 09:55
 */

public class Solutionm5d31 {

    public int maxProduct(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j){
                    max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
                }
            }
        }
        return max;
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hmax = horizontalCuts[0];
        int vmax = verticalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            hmax = Math.max(horizontalCuts[i] - horizontalCuts[i-1], hmax);
        }
        for (int i = 1; i < verticalCuts.length; i++) {
            vmax = Math.max(verticalCuts[i] - verticalCuts[i-1], vmax);
        }
        hmax = Math.max(h - horizontalCuts[horizontalCuts.length - 1], hmax);
        vmax = Math.max(w - verticalCuts[verticalCuts.length - 1], vmax);
        return (int)(((long)hmax * (long)vmax) % 1000000007);
    }

    public int minReorder(int n, int[][] connections) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        set.add(0);
        visited.add(0);
        while (visited.size() < n){
            Set<Integer> middle = new HashSet<>();
            for (int i = 0; i < connections.length; i++) {
                 if (set.contains(connections[i][0])){
                     if (!visited.contains(connections[i][1])){
                         ans++;
                         middle.add(connections[i][1]);
                         visited.add(connections[i][1]);
                     }
                 } else if (set.contains(connections[i][1])){
                     if (!visited.contains(connections[i][0])){
                         middle.add(connections[i][0]);
                         visited.add(connections[i][0]);
                     }
                 }
            }
            set = middle;
        }
        return ans;
    }

}
