package leetcode.weekly.weeklym6d07;/**
 * @description Solutionm6d07
 * @author liusandao
 * @date 2020-6-7 10:10
 */

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-06-07 10:10
 */

public class Solutionm6d07 {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[i + n];
        }
        return ans;
    }

    public int[] getStrongest(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) / 2];
        int i = 0, j = arr.length - 1;
        for (int t = 0; t < k; t++) {
            if (Math.abs(arr[j] - mid) >= Math.abs(arr[i] - mid)){
                ans[t] = arr[j--];
            } else {
                ans[t] = arr[i++];
            }
        }
        return ans;
    }

//    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//
//    }
//
//    public int dfs(int[] houses, int[][] cost, int target){
//
//    }

}
