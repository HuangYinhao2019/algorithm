package leetcode.weekly.weeklym7d26;/**
 * @description weeklym7d26
 * @author liusandao
 * @date 2020-7-26 10:29
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-07-26 10:29
 */

public class weeklym7d26 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = chars[i];
        }
        return String.valueOf(res);
    }

    public int minFlips(String target) {
        boolean zero = true;
        int res = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '0' && !zero) {
                res++;
                zero = !zero;
            } else if (target.charAt(i) == '1' && zero) {
                res++;
                zero = !zero;
            }
        }
        return res;
    }

    public int countPairs(TreeNode root, int distance) {
        HashMap<Integer, Integer> rootMap = countPair(root, distance);
        Integer res = rootMap.getOrDefault(-1, 0);
        return res;
    }

    public HashMap<Integer, Integer> countPair(TreeNode root, int distance) {
        if (root == null) {
            return null;
        } else {
            HashMap<Integer, Integer> left = countPair(root.left, distance);
            HashMap<Integer, Integer> right = countPair(root.right, distance);
            HashMap<Integer, Integer> map = new HashMap<>();
            if (left == null && right == null) {
                map.put(1,1);
                return map;
            } else if (left == null) {
                Set<Map.Entry<Integer, Integer>> set = right.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry me = (Map.Entry)iterator.next();
                    if ((int)me.getKey() == -1) {
                        map.put((int) me.getKey(), (int) me.getValue());
                    } else {
                        map.put((int) me.getKey() + 1, (int) me.getValue());
                    }
                }
                return map;
            } else if (right == null) {
                Set<Map.Entry<Integer, Integer>> set = left.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry me = (Map.Entry)iterator.next();
                    if ((int)me.getKey() == -1) {
                        map.put((int) me.getKey(), (int) me.getValue());
                    } else {
                        map.put((int) me.getKey() + 1, (int) me.getValue());
                    }
                }
                return map;
            } else {
                int count = 0;
                Set<Map.Entry<Integer, Integer>> setRight = right.entrySet();
                Set<Map.Entry<Integer, Integer>> setLeft = left.entrySet();
                for (Map.Entry sl : setLeft) {
                    for (Map.Entry sr : setRight) {
                        int l = (int)sl.getKey();
                        int r = (int)sr.getKey();
                        if (l > 0 && r > 0 && l + r <= distance) {
                            count += (int)sl.getValue() * (int)sr.getValue();
                        }
                    }
                    if ((int)sl.getKey() != -1) {
                        map.put((int)sl.getKey() + 1, (int)sl.getValue() + map.getOrDefault((int)sl.getKey() + 1, 0));
                    }
                }
                for (Map.Entry sr : setRight) {
                    if ((int)sr.getKey() != -1) {
                        map.put((int)sr.getKey() + 1, (int)sr.getValue() + map.getOrDefault((int)sr.getKey() + 1, 0));
                    }
                }
                map.put(-1, count + left.getOrDefault(-1, 0) + right.getOrDefault(-1, 0));
                return map;
            }
        }
    }

    public static void main(String[] args) {
        weeklym7d26 w = new weeklym7d26();
//        TreeNode root = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        root.left = t2;
//        root.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
        TreeNode[] t = new TreeNode[42];
        for (int i = 0; i < t.length; i++) {
            t[i] = new TreeNode(i);
        }
        for (int i = 0; i < t.length; i++) {
            if (i * 2 + 1 < t.length) {
                t[i].left = t[i * 2 + 1];
            }
            if (i * 2 + 2 < t.length) {
                t[i].right = t[i * 2 + 2];
            }
        }
        System.out.println(w.countPairs(t[0], 8));
    }

}
