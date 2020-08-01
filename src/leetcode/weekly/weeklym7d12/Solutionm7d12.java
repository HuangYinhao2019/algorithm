package leetcode.weekly.weeklym7d12;/**
 * @description Solutionm7d12
 * @author liusandao
 * @date 2020-7-12 10:26
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-07-12 10:26
 */

public class Solutionm7d12 {

    public class State{
        public int node;
        public double prob;

        public State(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += nums[i] == nums[j] ? 1 : 0;
            }
        }
        return ans;
    }

    public int numSub(String s) {
        int ans = 0;
        int now = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                now++;
                ans = (ans + now) % 1000000007;
            } else {
                now = 0;
            }
        }
        return ans;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob = new double[n];
        prob[start] = 1.0;
        Map<Integer, Set<double[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new HashSet<>());
            }
            map.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new HashSet<>());
            }
            map.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        Queue<State> q = new LinkedList<>();
        q.offer(new State(start, 1.0));
        while (!q.isEmpty()){
            State state = q.poll();
            Set<double[]> set = map.get(state.node);
            if (set != null && !set.isEmpty()) {
                for (double[] d : set) {
                    if (prob[(int) d[0]] < d[1] * state.prob) {
                        q.offer(new State((int) d[0], d[1] * state.prob));
                        prob[(int) d[0]] = d[1] * state.prob;
                    }
                }
            }
        }
        return prob[end];
    }

    public double getMinDistSum(int[][] positions) {
        int[][] direct = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        double curx = 50, cury = 50;
        double step = 1;
        double minDist = getDist(positions, 50, 50);
        while (step > 0.00001){
            boolean flag = true;
            for (int i = 0; i < direct.length; i++) {
                double tmp = getDist(positions, curx + direct[i][0] * step, cury + direct[i][1] * step);
                if (tmp < minDist){
                    minDist = tmp;
                    curx += direct[i][0] * step;
                    cury += direct[i][1] * step;
                    flag = false;
                }
            }
            if (flag) {
                step /= 10;
            }
        }
        return minDist;
    }

    private double getDist(int[][] positions, double x, double y){
        double res = 0;
        for (int i = 0; i < positions.length; i++) {
            res += Math.sqrt((x - (double)positions[i][0]) * (x - (double)positions[i][0]) + ((y - (double)positions[i][1]) * (y - (double)positions[i][1])));
        }
        return res;
    }

}
