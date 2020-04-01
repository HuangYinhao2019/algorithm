package exam.written.alibaba;

import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba5
 * @date 2020-3-30 19:45
 */
public class Alibaba5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] arr = new int[N];
        int num = N * (N + 1) / 2;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max){
                max = arr[i];
            }
            sum += max * (i + 1);
        }

        System.out.println((double)(sum) / (double)num);

    }
}
