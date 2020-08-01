package exam.written.yuanfudao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-01 19:21
 */

public class Solution2 {

    public static final int MOD = 1000000003;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        long[][] award = new long[N][2];
        int begin = 0;
        for (int i = 0; i < N; i++) {
            award[i][0] = sc.nextLong();
            award[i][1] = sc.nextLong() - 2;
            if (award[i][1] >= 0) {
                list.get((int)award[i][1]).add(i);
            } else {
                begin = i;
            }
        }
        long[] res = new long[1];
        res[0] = Integer.MIN_VALUE;
        dfs(award, list, begin, res);
        System.out.println(res[0] % MOD);
    }

    private static long dfs(long[][] award, List<List<Integer>> list, int now, long[] res) {
        if (list.get(now).size() == 0) {
            res[0] = Math.max(res[0], award[now][0]);
            return Math.max(award[now][0], 0L);
        } else {
            long max = 0;
            for (int i = 0; i < list.get(now).size(); i++) {
                long q = dfs(award, list, list.get(now).get(i), res);
                max += q > 0 ? q : 0;
            }
            res[0] = Math.max(res[0], max + award[now][0]);
            return Math.max(max + award[now][0], 0);
        }
    }

}
