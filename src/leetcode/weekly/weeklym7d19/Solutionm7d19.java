package leetcode.weekly.weeklym7d19;/**
 * @description Solutionm7d19
 * @author liusandao
 * @date 2020-7-19 10:29
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-07-19 10:29
 */

public class Solutionm7d19 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int leftbottles = 0;
        int ans = 0;
        while (numBottles > 0) {
            numBottles--;
            ans++;
            leftbottles++;
            if (leftbottles == numExchange) {
                numBottles++;
                leftbottles = 0;
            }
        }
        return ans;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new HashSet<>());
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new HashSet<>());
            }
            map.get(edges[i][1]).add(edges[i][0]);
            map.get(edges[i][0]).add(edges[i][1]);
        }
        countSub(ans, 0, map, labels, visited);
        return ans;
    }

    private int[] countSub(int[] ans, int now, Map<Integer, Set<Integer>> map, String labels, boolean[] visited) {
        visited[now] = true;
        if (!map.containsKey(now) || map.get(now) == null || map.get(now).isEmpty()) {
            ans[now] = 1;
            int[] res = new int[26];
            res[labels.charAt(now) - 'a'] = 1;
            return res;
        } else {
            Set set = map.get(now);
            Iterator iterator = set.iterator();
            int total = 0;
            int[] res = new int[26];
            res[labels.charAt(now) - 'a'] = 1;
            while (iterator.hasNext()) {
                Integer next = (Integer) iterator.next();
                if (!visited[next]) {
                    int[] tmp = countSub(ans, next, map, labels, visited);
                    for (int i = 0; i < 26; i++) {
                        res[i] += tmp[i];
                    }
                }
            }
            ans[now] = res[labels.charAt(now) - 'a'];
            return res;
        }
    }

    public List<String> maxNumOfSubstrings(String s) {
        int[][] be = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            if (be[s.charAt(i) - 'a'][0] == 0) {
                be[s.charAt(i) - 'a'][0] = i + 1;
            } else {
                be[s.charAt(i) - 'a'][1] = i + 1;
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (be[i][0] != 0 && be[i][1] == 0) {
                be[i][1] = be[i][0];
                list.add(be[i]);
            } else if (be[i][0] != 0 && be[i][1] != 0) {
                list.add(be[i]);
            }
        }
        Set<int[]> set = new HashSet<>();
        List<int[]> dfs = dfs(set, list, 0);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < dfs.size(); i++) {
            ans.add(s.substring(dfs.get(i)[0] - 1, dfs.get(i)[1]));
        }
        return ans;
    }

    private List<int[]> dfs(Set<int[]> set, List<int[]> list, int now) {
        if (now >= list.size()) {
            List<int[]> l = new ArrayList<>();
            for (int[] in : set){
                l.add(in);
            }
            return l;
        }
        if (isConflict(set, list.get(now))) {
            return dfs(set, list, now + 1);
        } else {
            List<int[]> a = dfs(set, list, now + 1);
            set.add(list.get(now));
            List<int[]> b = dfs(set, list, now + 1);
            set.remove(list.get(now));
            if (a.size() > b.size()) {
                return a;
            } else if (b.size() > a.size()) {
                return b;
            } else {
                int as = 0, bs = 0;
                for (int i = 0; i < a.size(); i++) {
                    as += a.get(i)[1] - a.get(i)[0];
                    bs += b.get(i)[1] - b.get(i)[0];
                }
                return as > bs ? b : a;
            }
        }
    }

    private boolean isConflict(Set<int[]> set, int[] di){
        for (int[] in : set){
            if (in[0] > di[1] || di[0] > in[1]) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

}
