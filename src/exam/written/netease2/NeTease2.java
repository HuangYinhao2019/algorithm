package exam.written.netease2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Netease2
 *              工厂有N个员工，有N个任务  <=10^5
 *              每个员工技能等级为Wi   10^9
 *              每个任务难度为Ti       10^9
 *              员工只能处理任务难度小于等于技能等级的任务
 *              给定一个M, 结果要对M求模，没啥意义
 *
 *              输出一个整数，该整数为所有可能的分配方式的数量除以M后求模
 *
 * @date 2020-4-11 18:57
 */
public class NeTease2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        int[] W = new int[N];
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
        }
        M = sc.nextInt();

        Arrays.sort(W);
        Arrays.sort(T);

        int ans = 1;
        for (int i = 0, j = 0; i < N; i++) {
            while (j < N && T[j] <= W[i]){
                j++;
            }
            ans = (ans * (j - i)) % M;
        }
        System.out.println(ans);
    }

}
