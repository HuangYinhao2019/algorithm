package exam.written.meituan4;

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-29 16:16
 */

public class MeiTuan3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int mei = sc.nextInt();
        int tuan = sc.nextInt();
        int[] distanceMei = new int[N + 1];
        int[] distanceTuan = new int[N + 1];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(mei);
        set.add(mei);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> integers = tree.get(poll);
            for (Integer integer : integers) {
                if (!set.contains(integer)) {
                    set.add(integer);
                    queue.offer(integer);
                    distanceMei[integer] = distanceMei[poll] + 1;
                }
            }
        }
        queue = new LinkedList<>();
        set = new HashSet<>();
        queue.offer(tuan);
        set.add(tuan);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> integers = tree.get(poll);
            for (Integer integer : integers) {
                if (!set.contains(integer)) {
                    set.add(integer);
                    queue.offer(integer);
                    distanceTuan[integer] = distanceTuan[poll] + 1;
                }
            }
        }
        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (distanceTuan[i] < distanceMei[i]) {
                max = Math.max(max, distanceMei[i]);
            }
        }
        System.out.println(max);
    }
}
