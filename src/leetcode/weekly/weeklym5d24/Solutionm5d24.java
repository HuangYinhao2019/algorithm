package leetcode.weekly.weeklym5d24;/**
 * @description Solutionm5d24
 * @author liusandao
 * @date 2020-5-24 10:23
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-24 10:23
 */

public class Solutionm5d24 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].startsWith(searchWord)){
                return i + 1;
            }
        }
        return -1;
    }

    public int maxVowels(String s, int k) {
        String y = "auioe";
        int max = 0;
        int count = 0;
        for (int i = 0; i < k; i++){
            if (y.indexOf(s.charAt(i)) != -1){
                count++;
            }
        }
        max = count;
        for (int i = k; i < s.length(); i++){
            if (y.indexOf(s.charAt(i)) != -1){
                count++;
            }
            if (y.indexOf(s.charAt(i - k)) != -1){
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] t = new int[10];
        return dfs(root, t);
    }

    public int dfs(TreeNode node, int[] t){
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null){
            t[node.val]++;
            int odd = 0;
            for (int i = 1; i < t.length; i++) {
                if (t[i] % 2 == 1){
                    odd++;
                }
            }
            if (odd > 1){
                return 0;
            } else {
                return 1;
            }
        } else {
            t[node.val]++;
            int[] ti = Arrays.copyOf(t, 10);
            return dfs(node.left, t) + dfs(node.right, ti);
        }
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return maxDotProduct(nums2, nums1);
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            max1 = Math.max(max1, nums1[i]);
            min1 = Math.min(min1, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            max2 = Math.max(max2, nums2[i]);
            min2 = Math.min(min2, nums2[i]);
        }
        if (min1 > 0 && max2 < 0){
            return min1 * max2;
        } else if (min2 > 0 && max1 < 0){
            return min2 * max1;
        } else {
            int[][] dp = new int[nums1.length][nums2.length];
            dp[0][0] = Math.max(0, nums1[0] * nums2[0]);
            for (int i = 1; i < nums2.length; i++) {
                dp[0][i] = Math.max(dp[0][i-1], nums1[0] * nums2[i]);
            }
            for (int i = 1; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    dp[i][j] = Math.max(0, dp[i-1][j]);
                    for (int k = 0; k <= j; k++) {
                        if (k != 0) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k - 1] + nums1[i] * nums2[k]);
                        } else {
                            dp[i][j] = Math.max(dp[i][j], nums1[i] * nums2[k]);
                        }
                    }
                }
            }
            return dp[nums1.length-1][nums2.length-1];
        }
    }

    public static void main(String[] args) {
        Solutionm5d24 s = new Solutionm5d24();
        int[] nums1 = new int[]{-3,-8,3,-10,1,3,9};
        int[] nums2 = new int[]{9,2,3,7,-9,1,-8,5,-1,-1};
        System.out.println(s.maxDotProduct(nums1, nums2));
    }

}
