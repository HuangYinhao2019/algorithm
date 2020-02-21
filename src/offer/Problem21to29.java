package offer;

import java.util.List;

public class Problem21to29 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int[] exchange(int[] nums) {
        int odd = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] % 2 == 1) odd++;
        int []b = nums.clone();
        int p = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 2 == 0) nums[odd++] = b[i];
            else nums[p++] = b[i];
        }
        return nums;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
            if (p == null && i < k - 1) return null;
        }
        if (p == null) return head;
        else{
            ListNode q = head;
            while(p != null){
                p = p.next;
                q = q.next;
            }
            return q;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        else if (head.next  == null) return head;
        else {
            ListNode p = head;
            ListNode ans = reverse(head,head.next);
            p.next = null;
            return ans;
        }
    }

    private ListNode reverse(ListNode node1, ListNode node2){
        if (node2.next != null){
            ListNode q = node2.next;
            node2.next = node1;
            return reverse(node2,q);
        }
        else{
            node2.next = node1;
            return node2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        int h = 0;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val){
            h = l2.val;
            l2 = l2.next;
        }
        else{
            h = l1.val;
            l1 = l1.next;
        }
        ListNode head = new ListNode(h);
        ListNode p = head;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                p.next = new ListNode(l2.val);
                l2 = l2.next;
                p = p.next;
            }
            else{
                p.next = new ListNode(l1.val);
                l1 = l1.next;
                p = p.next;
            }
        }
        while (l1 != null){
            p.next = new ListNode(l1.val);
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null){
            p.next = new ListNode(l2.val);
            l2 = l2.next;
            p = p.next;
        }
        return head;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        if (issub(A,B))
            return true;
        else return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean issub(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        else return issub(A.left,B.left) && issub(A.right,B.right);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode _root = mirrorTree(buildSameTree(root));
        return sameTree(root,_root);
    }

    public boolean sameTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        else if (root1 != null && root2 != null && root1.val == root2.val){
            return sameTree(root1.left,root2.left) && sameTree(root1.right,root2.right);
        }
        else  return false;
    }

    public TreeNode buildSameTree(TreeNode root){
        if (root == null)
            return null;
        TreeNode _root = new TreeNode(root.val);
        _root.left = buildSameTree(root.left);
        _root.right = buildSameTree(root.right);
        return _root;
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int R = matrix.length, C = matrix[0].length;
        int[] ans = new int[R*C];
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        int count = 0;
        for (int i = 0; i < R * C; i++) {
            ans[count++] = matrix[r][c];
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

}
