package offer;

import java.lang.reflect.Array;
import java.util.*;

public class Problem31to40 {
    private List<List<Integer>> ans34 = new ArrayList<List<Integer>>();
    private Map<Node, Node> map35 = new HashMap<Node, Node>();
    private Set<String> set38 = new HashSet<String>();

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

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node p = crl(head);
        return p;
    }

    private Node crl(Node head){
        if (head == null) return null;
        Node node;
        if (map35.containsKey(head))
            node = map35.get(head);
        else {
            node = new Node(head.val);
            map35.put(head,node);
            node.next = crl(head.next);
            node.random = crl(head.random);
        }
        return node;
    }

    public String serialize(TreeNode root) {
        if (root == null) return "null";
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String ans = new String("");
        q.offer(root);
        boolean flag = true;
        int count = 0;
        while (!q.isEmpty()){
            TreeNode t = q.poll();
            if (t == null){
                ans += " null";
            }
            else {
                ans += " " + String.valueOf(t.val);
                q.offer(t.left);
                q.offer(t.right);
            }
        }
        return ans.substring(1);

    }

    public TreeNode deserialize(String data) {
        if (data.equals("null") || data.equals("")) return null;
        String[] str = data.split(" ");
        int count = 1;
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (count < str.length){
            TreeNode t = q.poll();
            if (t != null) {
                if (!str[count].equals("null")) {
                    t.left = new TreeNode(Integer.valueOf(str[count++]));
                    q.offer(t.left);
                }
                else{
                    count++;
                    q.offer(null);
                }
                if (!str[count].equals("null")) {
                    t.right = new TreeNode(Integer.valueOf(str[count++]));
                    q.offer(t.right);
                }
                else{
                    count++;
                    q.offer(null);
                }
            }
        }

        return root;
    }

    public String[] permutation(String s) {
        List<Character> c = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            c.add(s.charAt(i));
        }
        p38("",c);
        String[] ans = new String[set38.size()];
        int count = 0;
        for (String str : set38) {
            ans[count++] = str;
        }
        return ans;
    }

    private void p38(String s, List<Character> c){
        if (c.size() == 1)
            set38.add(s + c.get(0));
        else{
            for (int i = 0; i < c.size(); i++) {
                char tmp = c.get(i);
                c.remove(i);
                p38(s + tmp, c);
                c.add(i,tmp);
            }
        }
    }

    public int majorityElement(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
                count++;
            }
            else {
                if (nums[i] == ans)
                    count++;
                else count--;
            }
        }
        return ans;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem31to40 p = new Problem31to40();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t4.left = t5;
        System.out.println(p.serialize(t1));
        p.deserialize(p.serialize(t1));
        p.permutation("aacd");
    }



}
