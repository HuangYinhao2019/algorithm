package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problem1to10 {
    private ArrayList<Integer> tmp = new ArrayList<Integer>();

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return nums[i];
        }
        return nums[0];
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int r = matrix.length;
        if(r==0)
            return false;
        int c = matrix[0].length;
        int i = 0,j = c - 1;
        while(i < r && j >= 0){
            if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
            else
                return true;
        }
        return false;
    }

    public String replaceSpace(String s) {
        StringBuffer res = new StringBuffer();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] ans = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++)
            ans[i] = tmp.get(i);
        return ans;
    }

    private void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        else{
            TreeNode root = new TreeNode(preorder[0]);
            for (int i = 0; i < preorder.length; i++) {
                if (inorder[i] == preorder[0]){
                    int []lpre = new int[i];
                    int []lin = new int[i];
                    int []rpre = new int[preorder.length - i - 1];
                    int []rin = new int[preorder.length - i - 1];
                    for (int i1 = 0; i1 < i; i1++) {
                        lpre[i1] = preorder[i1 + 1];
                        lin[i1] = inorder[i1];
                    }
                    for (int i1 = i + 1; i1 < preorder.length; i1++) {
                        rpre[i1 - i - 1] = preorder[i1];
                        rin[i1 - i - 1] = inorder[i1];
                    }
                    root.right = buildTree(rpre,rin);
                    root.left = buildTree(lpre,lin);
                    break;
                }
            }
            return root;
        }
    }

    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }
        return (int)(arr[n] % 1000000007);
    }

    public int numWays(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        long[] arr = new long[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }
        return (int)(arr[n] % 1000000007);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Problem1to10 p = new Problem1to10();
        System.out.println(p.fib(95));
    }
}
