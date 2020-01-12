package leetcode.biweeklym1d11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solutionm1d11 {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            for (int j = 0; j < nums[i * 2]; j++) {
                ans.add(nums[i * 2 + 1]);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int [][]t = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            t[i][0] = mat[i][0];
            for (int j = 1; j < mat[0].length; j++)
                t[i][j] = t[i][j-1] + mat[i][j];
        }
        int [][]pre = new int[mat.length][mat[0].length];
        for (int j = 0; j < mat[0].length; j++) {
            pre[0][j] = t[0][j];
            for (int i = 1; i < mat.length; i++) {
                pre[i][j] = pre[i-1][j] + t[i][j];
            }
        }
        int [][]ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int d = i + K >= mat.length ? mat.length - 1:i + K;
                int r = j + K >= mat[0].length ? mat[0].length - 1 : j + K;
                int ld = j - K - 1 < 0 ? 0 : pre[d][j-K-1];
                int ru = i - K - 1< 0 ? 0 : pre[i-K-1][r];
                int lu = (i - K - 1 < 0 || j - K - 1 < 0) ? 0 : pre[i-K-1][j-K-1];
                ans[i][j] = pre[d][r] - ld - ru + lu;
            }
        }
        return ans;
    }

    public int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        if (root == null) return 0;
        if (root.left != null) ans += calculateson(root.left, root.val % 2 == 0);
        if (root.right != null) ans += calculateson(root.right, root.val % 2 == 0);
        return ans;
    }

    public int calculateson(TreeNode root, boolean odd){
        int res = 0;
        if (root.left == null && root.right == null){
            return 0;
        }
        else if (root.right == null && root.left != null){
            res += calculateson(root.left, root.val % 2 == 0);
            if (odd) res += root.left.val;
        }
        else if (root.left == null && root.right != null){
            res += calculateson(root.right, root.val % 2 == 0);
            if (odd) res += root.right.val;
        }
        else{
            res += calculateson(root.left, root.val % 2 == 0);
            res += calculateson(root.right, root.val % 2 == 0);
            if (odd) {
                res += root.left.val;
                res += root.right.val;
            }
        }
        return res;
    }

    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= text.length() / 2; i++) {   //i is length
            for (int j = i; j <= text.length() - i; j++) {  // j is mid
                if (text.substring(j, j + i).equals(text.substring(j - i, j))) {
                    set.add(text.substring(j, j + i));
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args){
        Solutionm1d11 m1d11 = new Solutionm1d11();
        int [][]mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int K = 1;
        System.out.println(m1d11.matrixBlockSum(mat,K));

        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(9);
        TreeNode t9 = new TreeNode(1);
        TreeNode t10 = new TreeNode(4);
        TreeNode t11 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t5.left = t9;
        t5.right = t10;
        t7.right = t11;

        System.out.println(m1d11.sumEvenGrandparent(t1));


    }
}
