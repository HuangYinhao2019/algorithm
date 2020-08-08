package exam.written.netease3;

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-08 15:46
 */

public class Solution4 {

    public static class Edge {
        int u;
        int v;
        int wi;

        public Edge(int u, int v, int wi) {
            this.u = u;
            this.v = v;
            this.wi = wi;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Edge edge = (Edge) o;

            if (u != edge.u) {
                return false;
            }
            if (v != edge.v) {
                return false;
            }
            return wi == edge.wi;
        }

        @Override
        public int hashCode() {
            int result = u;
            result = 31 * result + v;
            result = 31 * result + wi;
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Edge[] edges = new  Edge[M];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wi = sc.nextInt();
            edges[i] = new Edge(u, v, wi);
        }
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            int[] parent = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                parent[j] = j;
            }
            int max = edges[i].wi;
            int min = edges[i].wi;
            parent[edges[i].u] = edges[i].v;
            for (int j = 0; j < N - 2; j++) {
                int min_abs = Integer.MAX_VALUE;
                Edge add = edges[i];
                for (int k = 0; k < M; k++) {
                    Edge e = edges[k];
                    if (parent[e.u] != parent[e.v]) {
                        if (Math.abs(e.wi - max) < min_abs && Math.abs(e.wi - min) < min_abs) {
                            min_abs = Math.max(Math.abs(e.wi - max), Math.abs(e.wi - min));
                            add = e;
                        }
                    }
                }
                int p = parent[add.u];
                for (int k = 1; k <= N; k++) {
                    if (parent[k] == p) {
                        parent[k] = parent[add.v];
                    }
                }
                max = Math.max(max, add.wi);
                min = Math.min(min, add.wi);
            }
            res = Math.min(res, max - min);
        }
        System.out.println(res);
    }
}
