package leetcode.weekly.weeklym5d03;/**
 * @description Solutionm5d03
 * @author liusandao
 * @date 2020-5-3 10:19
 */

import leetcode.biweekly.biweeklym5d02.Solutionm5d02;

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-03 10:19
 */

public class Solutionm5d03 {

    public static PriorityQueue<Integer> heap = new PriorityQueue<>();

    public String destCity(List<List<String>> paths) {
        Set<String> s = new HashSet<>();
        Set<String> e = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> p = paths.get(i);
            s.add(p.get(0));
            e.add(p.get(1));
        }
        for (String str : e) {
            if (!s.contains(str)){
                return str;
            }
        }
        return "";
    }

    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0){
            return true;
        } else {
            int index = -10000000;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1){
                    if (i - index <= k){
                        return false;
                    }
                    index = i;
                }
            }
            return true;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        for (int i = 0; i + ans - 1 < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                if (max - min > limit){
                    ans = Math.max(ans, j - i);
                    break;
                }
                if (j == nums.length - 1){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public int kthSmallest(int[][] mat, int k) {
        heap = new PriorityQueue<>();
        int n = mat.length;
        int m = mat[0].length;
        int[] t = new int[n];
        Arrays.fill(t, 1);
        int count = 1;
        while (count < k) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (t[i] < m && mat[i][t[i]] - mat[i][t[i] - 1] < min) {
                    min = mat[i][t[i]] - mat[i][t[i] - 1];
                    index = i;
                }
            }
            t[index]++;
            count = 1;
            for (int i = 0; i < n; i++) {
                count *= t[i];
            }
        }
        for (int i = 0; i < n; i++) {
            while (t[i] < m && mat[i][t[i]] == mat[i][t[i] - 1]){
                t[i]++;
            }
            if (t[i] < m){
                t[i]++;
            }
        }
        int ans = 0;
        heapAdd(mat, t, new ArrayList<Integer>(), 0);
        for (int i = 0; i < k; i++) {
            ans = heap.poll();
        }
        return ans;
    }

    public void heapAdd(int[][]mat, int[] t, List<Integer> list, int index){
        for (int i = 0; i < t[index]; i++) {
            list.add(mat[index][i]);
            if (index != mat.length - 1) {
                heapAdd(mat, t, list, index + 1);
                list.remove(list.size() - 1);
            }
            else {
                int sum = 0;
                for (int j = 0; j < list.size(); j++) {
                    sum += list.get(j);
                }
                heap.add(sum);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solutionm5d03 s = new Solutionm5d03();
        int[][] arr = new int[][]{{4,7,8,9,10},{2,8,8,9,9},{4,4,6,9,9},{1,1,1,3,9}};
        System.out.println(s.kthSmallest(arr, 12));
    }

}
