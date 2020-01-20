package leetcode.weeklym1d19;

import java.util.ArrayList;
import java.util.List;

public class Solutionm1d19 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maximum69Number (int num) {
        String a = String.valueOf(num);
        int l = String.valueOf(num).length();
        for (int i = 0; i < a.length(); i++) {
            if (a.indexOf('6') != -1) {
                a = a.replaceFirst("6","9");
                break;
            }
        }
        return Integer.valueOf(a);
    }

    public List<String> printVertically(String s) {
        String[] sp = s.split(" ");
        int maxlength = -1;
        for (int i = 0; i < sp.length; i++) {
            if (sp[i].length() > maxlength)
                maxlength = sp[i].length();
        }
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < maxlength; i++) {
            String ss = "";
            for (int j = 0; j < sp.length; j++) {
                if (i >= sp[j].length())
                    ss += " ";
                else
                    ss += sp[j].charAt(i);
            }
            while(ss.length() != 0){
                if (ss.endsWith(" "))
                    ss = ss.substring(0,ss.length() - 1);
                else
                    break;
            }
            ans.add(ss);
        }
        return ans;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        if (root.left != null && isremoved(root.left, target))
            root.left = null;
        if (root.right != null && isremoved(root.right, target))
            root.right = null;
        if (root.left == null && root.right == null && target == root.val)
            return null;
        return root;
    }

    public boolean isremoved(TreeNode root, int target){
        boolean left = true, right = true;
        if (root.left != null) {
            left = isremoved(root.left, target);
            if (left)
                root.left = null;
        }
        if (root.right != null){
            right = isremoved(root.right, target);
            if (right)
                root.right = null;
        }
        if (root.left == null && root.right == null && root.val == target)
            return true;
        else if(root.left == null && root.right == null && root.val != target)
            return false;
        else
            return false;
    }

    public static void main(String[] args) {
        Solutionm1d19 s = new Solutionm1d19();
        System.out.println(s.maximum69Number(9669));
        System.out.println(s.printVertically("CONTEST IS COMING"));
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        s.removeLeafNodes(t1,2);


    }
}
