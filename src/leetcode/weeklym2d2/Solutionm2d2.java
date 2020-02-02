package leetcode.weeklym2d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solutionm2d2 {

    static long res = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int[] b = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            b[i] = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    break;
                b[i]++;
            }
        }
        for (int i = 0; i < k; i++) {
            int min = 100000;
            for (int j = 0; j < b.length; j++) {
                if (b[j] < min){
                    ans[i] = j;
                    min = b[j];
                }
            }
            b[ans[i]] = 100000;
        }
        return ans;
    }

    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (m.containsKey(arr[i]))
                m.replace(arr[i],m.get(arr[i])+1);
            else
                m.put(arr[i],1);
        }
        int[] a = new int[m.size()];
        int t = 0;
        for (Integer i:m.values()){
            a[t++] = i;
        }
        Arrays.sort(a);
        int sum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            sum += a[i];
            if (sum >= arr.length/2)
                return a.length - i;
        }
        return sum;
    }

    public int maxProduct(TreeNode root) {
        int sum = sumT(root);
        cutResult(root,sum);
        res = (long)(res % (long)1000000007);
        int ans = (int)res;
        res = 0;
        return ans;
    }

    private int sumT(TreeNode root){
        int sum = 0;
        if (root.left != null)
            sum += sumT(root.left);
        if (root.right != null)
            sum += sumT(root.right);
        sum += root.val;
        return sum;
    }

    private int cutResult(TreeNode root, int sum){
        int subsum = 0;
        if (root.left != null)
            subsum += cutResult(root.left, sum);
        if (root.right != null)
            subsum += cutResult(root.right, sum);
        subsum += root.val;
        long a = ((long)(sum - subsum) * (long)subsum);
        if (a > res)
            res = a;
        return subsum;
    }

    public static void main(String[] args) {
        Solutionm2d2 s = new Solutionm2d2();
        int[] test = new int[]{3,3,3,3,5,5,5,2,2,7};
        System.out.println(s.minSetSize(test));
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        t4.left = t5;
        t4.right = t6;
        System.out.println(s.maxProduct(t1));


    }
}
