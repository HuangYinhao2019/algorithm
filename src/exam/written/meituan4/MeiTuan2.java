package exam.written.meituan4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-29 16:10
 */

public class MeiTuan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int[][] want = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                want[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!set.contains(want[i][j])) {
                    System.out.print(want[i][j]);
                    set.add(want[i][j]);
                    break;
                }
            }
            if (i != N - 1) {
                System.out.print(" ");
            }
        }
    }
}
