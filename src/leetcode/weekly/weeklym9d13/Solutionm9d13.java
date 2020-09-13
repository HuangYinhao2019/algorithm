package leetcode.weekly.weeklym9d13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-09-13 17:14
 */

public class Solutionm9d13 {

    public int numSpecial(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    boolean flag = true;
                    for (int p = 0; p < mat.length; p++) {
                        if (p != i && mat[p][j] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    for (int p = 0; p < mat[i].length; p++) {
                        if (p != j && mat[i][p] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int sum = 0;
        int[][] pre = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                pre[i][preferences[i][j]] = j;
            }
        }
        for (int i = 0; i < pairs.length; i++) {
            int x = pairs[i][0], y = pairs[i][1];
            boolean happyX = true, happyY = true;
            for (int j = 0; j < pairs.length; j++) {
                if (i == j) {
                    continue;
                }
                int u = pairs[j][0], v = pairs[j][1];
                if (!happyX && !happyY) {
                    break;
                }
                if (happyX) {
                    if (pre[x][u] < pre[x][y] && pre[u][x] < pre[u][v]) {
                        happyX = false;
                    }
                    if (pre[x][v] < pre[x][y] && pre[v][x] < pre[v][u]) {
                        happyX = false;
                    }
                }
                if (happyY) {
                    if (pre[y][u] < pre[y][x] && pre[u][y] < pre[u][v]) {
                        happyY = false;
                    }
                    if (pre[y][v] < pre[y][x] && pre[v][y] < pre[v][u]) {
                        happyY = false;
                    }
                }
            }
            sum += (happyX ? 0 : 1) + (happyY ? 0 : 1);
        }
        return sum;
    }

    public class Line {
        public int x;
        public int y;
        public int dis;

        public Line(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Line> priorityQueue = new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.dis - o2.dis;
            }
        });
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = i;
        }
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                priorityQueue.offer(new Line(i, j, dis));
            }
        }
        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            Line line = priorityQueue.poll();
            if (s[line.x] != s[line.y]) {
                sum += line.dis;
                int temp = s[line.x];
                for (int i = 0; i < s.length; i++) {
                    if (s[i] == temp) {
                        s[i] = s[line.y];
                    }
                }
            }
        }
        return sum;
    }

    public boolean isTransformable(String s, String t) {
        List<List<Integer>> list1 = new ArrayList<>(10);
        List<List<Integer>> list2 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }
        int[] h1 = new int[10];
        int[] h2 = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - '0';
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += h1[j];
            }
            h1[s.charAt(i) - '0']++;
            list1.get(k).add(sum);

            k = t.charAt(i) - '0';
            sum = 0;
            for (int j = 0; j < k; j++) {
                sum += h2[j];
            }
            h2[t.charAt(i) - '0']++;
            list2.get(k).add(sum);
        }
        for (int i = 0; i < 10; i++) {
            if (h1[i] != h2[i] || list1.get(i).size() != list2.get(i).size()) {
                return false;
            }
            for (int j = 0; j < list1.get(i).size(); j++) {
                int before = list1.get(i).get(j);
                int after = list2.get(i).get(j);
                if (after < before) {
                    return false;
                }
            }
        }
        return true;
    }

}
