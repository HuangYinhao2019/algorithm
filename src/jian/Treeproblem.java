package jian;

public class Treeproblem {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) return null;
        if(pre.length == 1) return new TreeNode(pre[0]);
        else{
            TreeNode root = new TreeNode(pre[0]);
            for (int i = 0; i < pre.length; i++) {
                if (in[i] == pre[0]){
                    int []lpre = new int[i];
                    int []lin = new int[i];
                    int []rpre = new int[pre.length - i - 1];
                    int []rin = new int[pre.length - i - 1];
                    for (int i1 = 0; i1 < i; i1++) {
                        lpre[i1] = pre[i1 + 1];
                        lin[i1] = in[i1];
                    }
                    for (int i1 = i + 1; i1 < pre.length; i1++) {
                        rpre[i1 - i - 1] = pre[i1];
                        rin[i1 - i - 1] = in[i1];
                    }
                    root.right = reConstructBinaryTree(rpre,rin);
                    root.left = reConstructBinaryTree(lpre,lin);
                    break;
                }
            }
            return root;
        }
    }

    public static void main(String[] args){
        int []pre = new int[]{1,2,4,7,3,5,6,8};
        int []in = new int[]{4,7,2,1,5,3,8,6};
        Treeproblem t = new Treeproblem();
        System.out.println(t.reConstructBinaryTree(pre, in));
        TreeNode root = t.reConstructBinaryTree(pre, in);
        System.out.println("done");
    }

}
