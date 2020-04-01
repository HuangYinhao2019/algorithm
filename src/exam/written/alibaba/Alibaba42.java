package exam.written.alibaba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba42
 *              有N只怪兽，每只怪兽有血量a[i]，你有M支箭，每支箭可以造成b[i]点伤害，
 *              会消耗c[i]点能量。你要用箭杀死某只怪兽，该箭的伤害必须大于等于怪兽的
 *              血量，打一只怪兽只能用一支箭，每支箭也只能用一次。求，杀死所有怪兽的
 *              最小能量。如果无法杀死所有怪兽，则输出“NO”
 *
 *              第一行T，表示有T组样例
 *              每组样例第一行N，M
 *              每组样例第二行N个数，表示N个怪兽的血量
 *              每组样例第三行M个数，表示每支箭的伤害
 *              每组样例第四行M个数，表示每支箭的消耗
 *
 *              例子
 *              1
 *              3 3
 *              1 2 3
 *              2 3 4
 *              1 2 3
 *
 *              输出：6
 *
 *
 *
 * @date 2020-4-1 18:20
 */

public class Alibaba42 {

    public static class Arrow{
        public int damage = 0;
        public int cost = 0;

        public Arrow() {
        }

        public Arrow(int damage, int cost) {
            this.damage = damage;
            this.cost = cost;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {

            int N,M;
            N = sc.nextInt();
            M = sc.nextInt();

            int[] a = new int[N];
            Arrow[] arrows = new Arrow[M];
            for (int i = 0; i < M; i++) {
                arrows[i] = new Arrow();
            }

            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();   //HP
            }
            for (int i = 0; i < M; i++) {
                arrows[i].damage = sc.nextInt();  //damage
            }
            for (int i = 0; i < M; i++) {
                arrows[i].cost = sc.nextInt();  //cost
            }

            /*
            血量从高到低杀，每次取伤害高于血量的箭矢中，耗费最低的
             */

            PriorityQueue<Arrow> p = new PriorityQueue<>(new Comparator<Arrow>() {
                @Override
                public int compare(Arrow o1, Arrow o2) {
                    return o1.cost - o2.cost;
                }
            });

            if (M < N){
                System.out.println("No");
            }
            else {
                int ans = 0;
                boolean can = true;
                Arrays.sort(a);
                Arrays.sort(arrows, new Comparator<Arrow>() {
                    @Override
                    public int compare(Arrow o1, Arrow o2) {
                        return o1.damage - o2.damage;
                    }
                });
                int j = M - 1;
                for (int i = N - 1; i >= 0; i--) {
                    while(j >= 0 && arrows[j].damage >= a[i]){
                        p.offer(arrows[j]);
                        j--;
                    }
                    //把伤害超过的弓箭加进去
                    if (p.size() == 0){
                        System.out.println("No");
                        can = false;
                        break;
                    }
                    else {
                        Arrow ar = p.poll();
                        ans += ar.cost;
                    }
                }
                if (can){
                    System.out.println(ans);
                }
            }
        }

    }

}

