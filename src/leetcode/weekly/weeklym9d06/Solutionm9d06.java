package leetcode.weekly.weeklym9d06;

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-09-06 10:30
 */

public class Solutionm9d06 {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '?') {
                for (char c = 'a'; c < 'z'; c++) {
                    if (i == 0 || c != chars[i - 1]) {
                        if (i == s.length() - 1 || c != chars[i + 1]) {
                            chars[i] = c;
                        }
                    }
                }
            }
        }
        return String.valueOf(chars);
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        int sum = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                sum += map1.get(nums1[i]);
            } else {
                int count = 0;
                for (int j = 0; j < nums2.length; j++) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if ((long) (nums1[i]) * (long) (nums1[i]) == (long) nums2[j] * (long) nums2[k]) {
                            count++;
                        }
                    }
                }
                sum += count;
                map1.put(nums1[i], count);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                sum += map2.get(nums2[i]);
            } else {
                int count = 0;
                for (int j = 0; j < nums1.length; j++) {
                    for (int k = j + 1; k < nums1.length; k++) {
                        if ((long) nums2[i] * (long) nums2[i] == (long) nums1[j] * (long) nums1[k]) {
                            count++;
                        }
                    }
                }
                sum += count;
                map2.put(nums2[i], count);
            }
        }
        return sum;
    }

    public int minCost(String s, int[] cost) {
        int sum = 0;
        int max = cost[0];
        int c = cost[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                c += cost[i];
                max = Math.max(max, cost[i]);
            } else {
                sum += c - max;
                max = cost[i];
                c = cost[i];
            }
        }
        sum += c - max;
        return sum;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int sum = 0;
        int edges1 = 0;
        int edges2 = 0;
        int edges3 = 0;
        List<Set<Integer>> alice = new ArrayList<>();
        List<Set<Integer>> bob = new ArrayList<>();
        List<Set<Integer>> both = new ArrayList<>();
        //利用并查集去掉type = 3的边形成的环
        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            alice.add(new HashSet<>());
            bob.add(new HashSet<>());
            both.add(new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 1) {
                alice.get(edges[i][1]).add(edges[i][2]);
                alice.get(edges[i][2]).add(edges[i][1]);
                edges1 += 2;
            } else if (edges[i][0] == 2) {
                bob.get(edges[i][1]).add(edges[i][2]);
                bob.get(edges[i][2]).add(edges[i][1]);
                edges2 += 2;
            } else {
                if (r[edges[i][1]] != r[edges[i][2]]) {
                    int t = r[edges[i][1]];
                    for (int j = 1; j <= n; j++) {
                        if (r[j] == t) {
                            r[j] = r[edges[i][2]];
                        }
                    }
                    both.get(edges[i][1]).add(edges[i][2]);
                    both.get(edges[i][2]).add(edges[i][1]);
                    edges3 += 2;
                } else {
                    sum += 2;
                }
            }
        }
        // 对于Alice和Bob的边，如果有公有边重合，则删除私有边
        for (int i = 1; i <= n; i++) {
            Set<Integer> a = alice.get(i);
            Set<Integer> b = bob.get(i);
            Set<Integer> c = both.get(i);
            for (Integer integer : c) {
                if (a.contains(integer)) {
                    a.remove(integer);
                    sum++;
                    edges1--;
                }
                if (b.contains(integer)) {
                    b.remove(integer);
                    sum++;
                    edges2--;
                }
            }
        }
        sum /= 2;
        // 判断Alice和Bob是否都能遍历完全
        boolean[] visitedAlice = new boolean[n + 1];
        boolean[] visitedBob = new boolean[n + 1];
        dfs(alice, both, visitedAlice, 1);
        dfs(bob, both, visitedBob, 1);
        for (int i = 1; i <= n; i++) {
            if (!visitedAlice[i] || !visitedBob[i]) {
                return -1;
            }
        }
        Set<Integer> nums = new HashSet<>();
        for (int i = 1; i < r.length; i++) {
            nums.add(r[i]);
        }
        // 根据并查集数量，得到遍历全部所需要加入的私有边
        int q = nums.size();
        edges1 /= 2;
        edges2 /= 2;
        edges1 -= q - 1;
        edges2 -= q - 1;
        // 剩余的私有边则都可以删除
        sum += edges1 + edges2;
        return sum;
    }

    private void dfs(List<Set<Integer>> single, List<Set<Integer>> both, boolean[] visited, int now) {
        if (visited[now]) {
            return;
        } else {
            visited[now] = true;
            Set<Integer> s = single.get(now);
            Set<Integer> b = both.get(now);
            for (Integer integer : s) {
                dfs(single, both, visited, integer);
            }
            for (Integer integer : b) {
                dfs(single, both, visited, integer);
            }
        }
    }

}
