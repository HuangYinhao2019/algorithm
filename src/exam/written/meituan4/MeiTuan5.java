package exam.written.meituan4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-29 17:24
 */

public class MeiTuan5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        Arrays.fill(B, -1);
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int j = 0; j < k; j++) {
                    B[y + j - 1] = A[x + j - 1];
                }
            } else if (op == 2) {
                int c = sc.nextInt();
                System.out.println(B[c - 1]);
            }
        }
    }
}
