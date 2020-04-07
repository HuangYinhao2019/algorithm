package exam.written.netease;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author liusandao
 * @description NeTease2
 * @date 2020-4-7 19:24
 */
public class NeTease2 {

    public static class Monster{
        public int damege;
        public int defendBroking;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,D;
        N = sc.nextInt();
        D = sc.nextInt();
        int ans = 0;

        Monster[] m = new Monster[N];

        for (int i = 0; i < N; i++) {
            m[i] = new Monster();
            m[i].defendBroking = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            m[i].damege = sc.nextInt();
            ans += m[i].damege;
        }

        Arrays.sort(m, new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                return o1.defendBroking - o2.defendBroking;
            }
        });

        PriorityQueue<Monster> pri = new PriorityQueue<>(new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                return o2.damege - o1.damege;
            }
        });

        int j = 0;
        for (int i = 0; i < N; i++) {
            int defend = D + i;
            while (j < N && m[j].defendBroking < defend){
                pri.offer(m[j]);
                j++;
            }
            //选一直当前能杀的，伤害最高的
            if (!pri.isEmpty()){
                Monster monster = pri.poll();
                ans -= monster.damege;
            }
        }

        System.out.println(ans);
    }

}
