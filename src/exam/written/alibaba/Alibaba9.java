package exam.written.alibaba;/**
 * @description Alibaba9
 * @author liusandao
 * @date 2020-4-30 20:16
 */

import java.util.Scanner;

/**
 * @program: algorithm
 * @description: Magic Tower
 * @author: liusandao
 * @date 2020-04-30 20:16
 */

public class Alibaba9 {

    //不考虑英雄血量，杀死怪物要掉多少血
    public static long fight(long[] hero, long[] monster){
        //怪物每回合掉血量
        long monsterPerTurn = Math.max(1, hero[1] - monster[2]);
        //英雄每回合掉血量
        long heroPerTurn = Math.max(1, monster[1] - hero[2]);
        //怪物死亡需要攻击次数，怪物攻击次数 = 怪物死亡需要次数 - 1,需要向上取整
        long monsterDieTurn = (monster[0] / monsterPerTurn) + monster[0] % monsterPerTurn == 0 ? 0 : 1;
        //怪物可对英雄造成的伤害, 该伤害可能非常高，因为有可能英雄每次攻击刮痧，只造成一点伤害，而怪物每次造成成吨伤害
        //所以在特殊情况下要考虑long数据类型不足以存放，造成数据大小上溢，本题数据范围暂时不用考虑
        long monsterDamage = (monsterDieTurn - 1) * heroPerTurn;
        return monsterDamage;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        long[] hero = new long[3];
        hero[0] = sc.nextLong();
        hero[1] = sc.nextLong();
        hero[2] = sc.nextLong();
        N = sc.nextInt();
        long[][] monsters = new long[N][3];
        for (int i = 0; i < N; i++) {
            monsters[i][0] = sc.nextLong();
            monsters[i][1] = sc.nextLong();
            monsters[i][2] = sc.nextLong();
        }
        //dp[i][j][k]表示在攻击+i次，防御+j次，血量+k次情况下，攻击完第i+j+k个怪物(怪物编号从0开始)时，初始所需的最低血量
        long[][][] dp = new long[N][N][N];
        dp[0][0][0] = fight(hero, monsters[0]);
        if (dp[0][0][0] >= hero[0]){
            System.out.println(0);
        } else {
            //打N只怪兽
            // full用来记录是否能全通关
            boolean full = false;
            for (int t = 1; t < N; t++) {
                //打第t只，i + j + k = t
                //flag用来判断有没有可能打的过第t-1只,如果打得过，那么这轮总有一个dp[i][j][k]!=MAX_VALUE
                boolean flag = false;
                for (int i = 0; i <= t; i++) {
                    for (int j = 0; j <= t - i; j++) {
                        int k = t - i - j;
                        //dp[i][j][k]可能由三种状态得来，先将dp[i][j][k]赋最大值
                        dp[i][j][k] = Long.MAX_VALUE;
                        //英雄状态(其实血量不用记，改成0也不影响)
                        long[] hero1 = new long[]{hero[0]+10*i,hero[1]+10*j,hero[2]+1000*k};
                        //记录攻击本只怪物需要消耗多少血量
                        long fightThisTurn = fight(hero1,monsters[t]);
                        //1.dp[i-1][j][k]  打完t-1只后，加攻击
                        if (i - 1 >= 0 && dp[i-1][j][k] - k * 1000 < hero[0]){
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j][k] + fightThisTurn);
                        }
                        //2.dp[i][j-1][k]  打完t-1只后，加防御
                        if (j - 1 >= 0 && dp[i][j-1][k] - k * 1000 < hero[0]){
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i][j-1][k] + fightThisTurn);
                        }
                        //3.dp[i][j][k-1]  打完t-1只后，加血
                        if (k - 1 >= 0 && dp[i][j][k-1] - (k - 1) * 1000 < hero[0]){
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i][j][k-1] + fightThisTurn);
                        }
                        // 说明上面三个情况，有一种是成立，可以求出dp[i][j][k]
                        if (dp[i][j][k] != Long.MAX_VALUE){
                            if (t == N - 1 && dp[i][j][k] < hero[0] + k * 1000){
                                full = true;
                            }
                            flag = true;
                        }
                    }
                }
                // flag = false说明t-1时，所有dp[i][j][k]需要的血量都超出了初始血量，失败
                if (!flag){
                    System.out.println(t - 1);
                    break;
                }
                // 全通关
                if (t == N - 1 && full){
                    System.out.println(N);
                    break;
                }
                // 功亏一篑
                if (t == N - 1 && !full){
                    System.out.println(N - 1);
                    break;
                }
            }
        }


    }

}
