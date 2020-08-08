package exam.written.netease3;

import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-08 15:26
 */

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] value = new int[N];
            int[] d = new int[N];
            for (int i = 0; i < N; i++) {
                value[i] = sc.nextInt();
            }
            System.out.println(dep(d, value, 0));
        }
    }

    private static int dep(int[] d, int[] value, int index) {
        if (index == d.length) {
            return cal(d, value);
        } else {
            int min = 2000000;
            for (int i = 1; i <= 3; i++) {
                d[index] = i;
                min = Math.min(min, dep(d, value, index + 1));
            }
            return min;
        }
    }

    private static int cal(int[] d, int[] value) {
        int sum1 = 0, sum2 = 0, rest = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] == 1) {
                sum1 += value[i];
            } else if (d[i] == 3) {
                sum2 += value[i];
            } else {
                rest += value[i];
            }
        }
        if (sum1 == sum2) {
            return rest;
        } else {
            return 2000000;
        }
    }
    
}
