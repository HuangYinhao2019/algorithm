package exam.written.huawei;/**
 * @description HuaWei2
 * @author liusandao
 * @date 2020-5-6 19:06
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-06 19:06
 */

public class HuaWei2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M, N;
        int sum = 0, j = 0;
        M = sc.nextInt();
        N = sc.nextInt();
        int[] memory = new int[M];
        int[][] query = new int[N][2];
        for (int i = 0; i < M; i++) {
            memory[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
        }
        PriorityQueue<int[] > heap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Arrays.sort(memory);
        Arrays.sort(query, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < M; i++) {
            while (j < N && query[j][0] <= memory[i]){
                heap.add(query[j]);
                j++;
            }
            if (!heap.isEmpty()){
                sum += heap.poll()[1];
            }
        }
        System.out.println(sum);
    }
}
