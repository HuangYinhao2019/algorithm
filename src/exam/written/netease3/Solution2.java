package exam.written.netease3;

import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-08 15:08
 */

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] m = new int[M];
        int[] nn = new int[N - M];
        int top = 0;
        boolean[] n = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            m[i] = sc.nextInt();
            n[m[i]] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (!n[i]) {
                nn[top++] = i;
            }
        }
        StringBuilder res = new StringBuilder("");
        int i, j;
        for (i = 0, j = 0; i < nn.length && j < M;) {
            if (m[j] < nn[i]) {
                res.append(m[j]);
                res.append(" ");
                j++;
            } else {
                res.append(nn[i]);
                res.append(" ");
                i++;
            }
        }
        while (i < nn.length) {
            res.append(nn[i]);
            res.append(" ");
            i++;
        }
        while (j < M) {
            res.append(m[j]);
            res.append(" ");
            j++;
        }
        System.out.println(res.toString().trim());
    }

}
