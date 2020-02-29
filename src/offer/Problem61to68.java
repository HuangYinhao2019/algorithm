package offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem61to68 {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private boolean flag68II = false;

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int max = -1, min = 14;
        int zero = 0;
        while (nums[zero] == 0)
            zero++;
        for (int i = zero; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                return false;
        }
        if (nums[nums.length-1] - nums[zero] >= 4 - zero && nums[nums.length-1] - nums[zero] < 5)
            return true;
        return false;
    }

    public int lastRemaining(int n, int m) {
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i;
            //动态规划的思想，将f(n,m)替换成flag存储
        }
        return flag;
    }

    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < prices.length; i++) {
            low = low < prices[i] ? low : prices[i];
            max = max > prices[i] - low ? max : prices[i] - low;
        }
        return max;
    }

    public int sumNums(int n) {
        int k = n;
        boolean b = n > 0 && (k += sumNums(n-1)) > 0;
        return k;
    }

    public int add(int a, int b) {
        if (b == 0) return a;
        while (a != 0){
            int t = a ^ b;  //亦或是不进位加法
            int q = a & b;  //与是进位情况
            a = q << 1;
            b = t;
        }
        return b;
    }

    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        int left = 1, right = 1;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = left;
            left *= a[i];
        }
        for (int j = ans.length - 1; j >= 0; j--) {
            ans[j] *= right;
            right *= a[j];
        }
        return ans;
    }

    //T135
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1])
                left[i] = left[i - 1] + 1;
        }
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j+1])
                right[j] = right[j + 1] + 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i],right[i]);
        }
        return sum;
    }

    public int candyII(int[] ratings) {
        int[] arr= new int[ratings.length];
        Arrays.fill(arr,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1])
                arr[i] = arr[i - 1] + 1;
        }
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j+1])
                arr[j] = Math.max(arr[j+1] + 1,arr[j]);
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int strToInt(String str) {
        str = str.trim();
        int ans = 0;
        if (str.length() == 0 || (str.charAt(0) > '9' || str.charAt(0) < '0') && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        else if (str.charAt(0) == '-') {
            int i = 1;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if ((long)ans * (-10L) - (long)(str.charAt(i) - '0') < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                else {
                    ans *= 10;
                    ans += str.charAt(i) - '0';
                    i++;
                }
            }
            return -ans;
        }
        else{
            int i = str.charAt(0) == '+' ? 1 : 0;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if ((long)ans * 10L + (long)(str.charAt(i) - '0') > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else {
                    ans *= 10;
                    ans += str.charAt(i) - '0';
                    i++;
                }
            }
            return ans;
        }
    }

    //二叉搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val))
            return root;
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return lowestCommonAncestor(root.left,p,q);
    }

    //二叉树
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p);
        TreeNode[] ansp = new TreeNode[stack.size()];
        for (int j = ansp.length - 1; j >= 0; j--)
            ansp[j] = stack.pop();
        flag68II = false;
        dfs(root,q);
        TreeNode[] ansq = new TreeNode[stack.size()];
        for (int i = ansq.length - 1; i >= 0; i--)
            ansq[i] = stack.pop();
        int count = 0;
        while (count < ansp.length && count < ansq.length && ansp[count] == ansq[count])
            count++;
        return ansp[count - 1];
    }

    public TreeNode lowestCommonAncestorIII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode leftNode = lowestCommonAncestorIII(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestorIII(root.right, p, q);

        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;

        return root;
//    作者：yuanninesuns
//    链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/jian-dan-yi-dong-xiang-jie-ru-xia-by-yuanninesuns/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    private void dfs(TreeNode root, TreeNode p){
        stack.push(root);
        if (root == p){
            flag68II = true;
            return;
        }
        if (root.left != null && !flag68II)
            dfs(root.left, p);
        if (root.right != null && !flag68II)
            dfs(root.right, p);
        if (!flag68II)
            stack.pop();
    }

    public static void main(String[] args) {
        Problem61to68 p = new Problem61to68();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;
        System.out.println(p.lowestCommonAncestorII(t1,t2,t9).val);
    }

}
