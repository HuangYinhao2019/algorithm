package exam.written.meituan2;

import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan4
 * @date 2020-4-9 18:49
 */
public class MeiTuan4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        long[] dp1 = new long[N+1];
        long[] dp2 = new long[N+1];
        dp1[0] = 1;
        dp2[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp1[i] = dp2[i-1] % 1000000007;
            dp2[i] = (3 * dp1[i-1] + 2 * dp2[i-1]) % 1000000007;
        }

        System.out.println(dp1[N]);

    }

}
