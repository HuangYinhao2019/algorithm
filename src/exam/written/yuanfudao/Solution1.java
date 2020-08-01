package exam.written.yuanfudao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-01 19:12
 */

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] clas = new int[N][2];
        for (int i = 0; i < N; i++) {
            clas[i][0] = sc.nextInt();
            clas[i][1] = sc.nextInt();
        }
        Arrays.sort(clas, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(clas[0][1]);
        for (int i = 1; i < N; i++) {
            if (queue.peek() <= clas[i][0]) {
                Integer e = queue.poll();
                queue.offer(clas[i][1]);
            } else {
                queue.offer(clas[i][1]);
            }
        }
        System.out.println(queue.size());
    }

}
