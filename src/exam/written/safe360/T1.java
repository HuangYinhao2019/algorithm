package exam.written.safe360;

import java.util.Scanner;

/**
 * @author liusandao
 * @description T1
 *              西西是某公司的一名员工，该公司目前正在做的项目还有N天截止。
 *              为鼓励员工加班，在这N天内该公司每天都会为当天加班的员工发放
 *              奖金。具体来说，对于当天加班的某位员工，若该员工已经连续加
 *              班了i天（1≤i≤N），则其当天能获得的奖金为i（例如 ，第一天
 *              加班，则此时记为连续加班1天，获得的奖金为1）。西西制定了这
 *              N天内的加班计划，他每天要么加班，要么不加班，要么不确定加
 *              不加班（有50%的概率加班，剩下50%的概率不加班），那么西西在
 *              这N天内能获得的总奖金的期望是多少？
 *
 *              第一行包含一个整数N，1≤N≤10^5。
 *
 *              第二行包含N个空格隔开的整数t1到tN，0≤ti≤2。若ti=0，则表示西西在第i天不加班；
 *               若ti=1，则表示西西在第i天会加班；若ti=2，则表示西西在第i天有50%的概率加班，
 *               剩下50%的概率不加班。
 *
 * @date 2020-3-27 20:15
 *
 * 91%
 *
 */
public class T1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int N;
        N = sc.nextInt();
        int[] plan = new int[N];
        for(int i = 0; i < N; i++){
            plan[i] = sc.nextInt();
        }
        double sum = 0;
        double now = 0;
        for(int i = 0; i < N; i++){
            if(plan[i] == 0){
                now = 0;
            }
            else if(plan[i] == 1){
                now += 1.0;
                sum += now;
            }
            else if(plan[i] == 2){
                now = (now + 1) * 0.5;
                sum += now;
            }
        }
        System.out.println((int)sum);
    }

}
