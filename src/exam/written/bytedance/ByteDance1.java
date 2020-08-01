package exam.written.bytedance;/**
 * @description ByteDance1
 * @author liusandao
 * @date 2020-5-3 19:22
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-03 19:22
 */

public class ByteDance1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        boolean[][] root = new boolean[N + 1][N + 1];
        PriorityQueue<List<Integer>> p = new PriorityQueue<>(((o1, o2) -> o1.size() - o2.size()));
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> layers = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int x, y, z;
        for (int i = 0; i < (N * (N - 1)) / 2; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            root[x][z] = true;
            root[y][z] = true;
        }
        int[] ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            root[i][i] = true;
            for (int j = 1; j <= N; j++) {
                if (root[i][j]){
                    list.add(j);
                }
            }
            p.add(list);
        }
        while (!p.isEmpty()){
            List<Integer> list = p.poll();
            int layer = list.size();
            if (layer == 1){
                ans[list.get(0)] = 0;
                List<Integer> l = new ArrayList<>();
                l.add(list.get(0));
                layers.add(l);
                set.add(list.get(0));
            } else {
                int self = 0, fa = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (!set.contains(list.get(i))){
                        self = list.get(i);
                    }
                    if (layers.get(layer - 2).contains(list.get(i))){
                        fa = list.get(i);
                    }
                }
                ans[self - 1] = fa;
                if (layers.size() < layer){
                    List<Integer> l = new ArrayList<>();
                    l.add(self);
                    layers.add(l);
                } else {
                    layers.get(layer - 1).add(self);
                }
                set.add(self);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ans[i]);
            if (i < N - 1){
                System.out.print(" ");
            }
        }
    }
}
