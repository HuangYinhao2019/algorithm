package exam.written.alibaba;

import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba7
 *              训练时间为n秒，m个木头人，每个木头人血量为a
 *              小强的攻击范围为b，小强每次攻击能对最多b个存活
 *              的木头人照成一点伤害，每次攻击需要1秒，当经过
 *              一次攻击后，木头人的血量为0，木头人死亡
 *
 *              问，特训结束，问最多能消灭几个木头人
 *
 *              总伤害 = n * b
 *              总血量 = m * a
 *
 *              a a a a a a a
 *
 *
 *
 * @date 2020-4-8 15:57
 */
public class Alibaba7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        long[]n = new long[T];
        long[]m = new long[T];
        long[]a = new long[T];
        long[]b = new long[T];
        long[]ans = new long[T];

        for (int i = 0; i < T; i++) {
            n[i] = sc.nextLong();
            m[i] = sc.nextLong();
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
            b[i] = Math.min(b[i],m[i]);
        }

        for (int i = 0; i < T; i++) {
            if (n[i] < a[i]) {
                ans[i] = 0;
            } else {
                long sumDamage = n[i] * b[i];
                ans[i] = sumDamage / a[i];
                ans[i] = Math.min(ans[i], m[i]);
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(ans[i]);
        }
    }
}
