package exam.written.huawei;/**
 * @description HuaWei3
 * @author liusandao
 * @date 2020-5-6 20:16
 */

import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-06 20:16
 */

public class HuaWei3 {

    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        TreeNode root = getRoot(str);
        System.out.println(root);
    }

    public static TreeNode getRoot(String str){
        if (!str.contains("(")){
            return new TreeNode(Integer.valueOf(str));
        } else {
            TreeNode res = new TreeNode(Integer.valueOf(str.substring(0, str.indexOf('('))));
            TreeNode[] leaves = getLeaves(str.substring((str.indexOf('(') + 1), str.lastIndexOf(')')));
            res.left = leaves[0];
            res.right = leaves[1];
            return res;
        }
    }

    public static TreeNode[] getLeaves(String str){
        TreeNode[] res = new TreeNode[2];
        res[0] = getRoot(str.substring(0, str.indexOf(',')));
        res[1] = getRoot(str.substring(str.indexOf(',') + 1));
        return res;
    }

}
