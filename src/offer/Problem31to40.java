package offer;

import java.util.*;

public class Problem31to40 {
    private List<List<Integer>> ans34 = new ArrayList<List<Integer>>();

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> sta = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            sta.push(pushed[i]);
            while (!sta.isEmpty()){
                if (sta.peek() == popped[j]){
                    sta.pop();
                    j++;
                }
                else
                    break;
            }
        }
        if (sta.isEmpty())
            return true;
        return false;
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> l = new ArrayList<Integer>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            l.add(t.val);
            if (t.left != null)
                q.offer(t.left);
            if (t.right != null)
                q.offer(t.right);
        }
        int[] ans = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        int number = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> l = new ArrayList<Integer>();
            int _num = 0;
            for (int i = 0; i < number; i++) {
                TreeNode t = q.poll();
                l.add(t.val);
                if (t.left != null) {
                    q.offer(t.left);
                    _num++;
                }
                if (t.right != null) {
                    q.offer(t.right);
                    _num++;
                }
            }
            number = _num;
            ans.add(l);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        int number = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> l = new ArrayList<Integer>();
            int _num = 0;
            for (int i = 0; i < number; i++) {
                TreeNode t = q.poll();
                l.add(t.val);
                if (t.left != null) {
                    q.offer(t.left);
                    _num++;
                }
                if (t.right != null) {
                    q.offer(t.right);
                    _num++;
                }
            }
            number = _num;
            ans.add(l);
        }
        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 == 1){
                List<Integer> l = new ArrayList<Integer>();
                for (int j = ans.get(i).size() - 1; j >= 0; j--) {
                    l.add(ans.get(i).get(j));
                }
                ans.remove(i);
                ans.add(i,l);
            }
        }
        return ans;
    }

    public boolean verifyPostorder(int [] postorder) {
        if (postorder.length <= 2) return true;
        return verifySeq(postorder, 0, postorder.length-1);
    }

    private boolean verifySeq(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int i;
        for (i = start; i < end; i++) {
            if (postorder[i] > postorder[end]) break;
        }
        // 验证后面的是否都大于sequence[end]
        for (int j = i; j < end; j++) {
            if (postorder[j] < postorder[end]) return false;
        }
        return verifySeq(postorder, start, i-1) && verifySeq(postorder, i, end-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans34;
        path(new ArrayList<Integer>(),root,sum);
        return ans34;
    }

    private void path(List<Integer> l, TreeNode root, int sum) {
        if (root.left == null && root.right == null && root.val == sum) {
            l.add(root.val);
            ans34.add(l);
        }
        List<Integer> l1 = new ArrayList<Integer>();
        for (int i = 0; i < l.size(); i++)
            l1.add(l.get(i));
        List<Integer> l2 = new ArrayList<Integer>();
        for (int i = 0; i < l.size(); i++)
            l2.add(l.get(i));
        l1.add(root.val);
        l2.add(root.val);
        if (root.left != null)
            path(l1,root.left,sum-root.val);
        if (root.right != null)
            path(l2,root.right,sum-root.val);
    }


}
