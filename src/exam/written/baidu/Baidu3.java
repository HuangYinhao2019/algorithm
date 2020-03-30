package exam.written.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Baidu3
 * @date 2020-3-29 18:58
 */
public class Baidu3 {

    public static int ans = 0;

    public static class TreeNode{
        int val = 0;
        boolean visited = false;
        boolean isroot = true;
        ArrayList<TreeNode> son = new ArrayList<>(2);

        public TreeNode(){};
        public TreeNode(int val){
            this.val = val;
            this.visited = false;
            this.isroot = true;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        List<TreeNode> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            list.add(new TreeNode(val));
        }
        for (int i = 0; i < N - 1; i++) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            list.get(f-1).son.add(list.get(s-1));
            list.get(s-1).isroot = false;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isroot) {
                list.get(i).visited = true;
                deepTree(list.get(i), 1);
            }
        }

        System.out.println(ans);
    }

    public static void deepTree(TreeNode t, int d){
        ans = Math.max(ans,d);
        for (int i = 0; i < t.son.size(); i++) {
            if (t.son.get(i).val > t.val) {
                deepTree(t.son.get(i), d + 1);
            }
            else {
                if (!t.son.get(i).visited) {
                    t.son.get(i).visited = true;
                    deepTree(t.son.get(i), 1);
                }
            }
        }
    }

}
