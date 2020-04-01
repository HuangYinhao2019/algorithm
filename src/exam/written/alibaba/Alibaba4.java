package exam.written.alibaba;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba4
 *              小强有n个养鸡场，第i个养鸡场初始有a[i]只小鸡，与其他养鸡场不同的是
 *              小强的每个养鸡场每天都会增加k只小鸡，为了维持养鸡场良好的生态环境，
 *              小强在每天结束的时候都会在数量最多的养鸡场里卖掉一半的小鸡，即若当前
 *              最多的养鸡场有x只消极，经过贩卖后，当前养鸡场剩下x/2只消极，问经过m
 *              天后，小强的n个养鸡场里面一共有多少只小鸡。
 *
 *              n = 养鸡场数量, m = 天数, k = 每天增加
 *
 * @date 2020-3-30 19:04
 */
public class Alibaba4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, K;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        int sum = 0;
        int ans = 0;
        PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        });
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            heap.offer(a);
        }

        for (int i = 0; i < M; i++) {
            int max = heap.poll();
            max = (max + ((i + 1) * K)) / 2;
            max -= (i + 1) * K;
            heap.offer(max);
        }
        for (int i = 0; i < N; i++) {
            sum += heap.poll();
        }

        System.out.println(sum + (N * M * K));

    }

}
