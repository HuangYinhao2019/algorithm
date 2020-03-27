package exam.written.safe360;

import java.util.Scanner;

/**
 * @author liusandao
 * @description T2
 * 在某个仓库中，堆积了很多的货物。每个货物是一个正方体的，边长为1。
 * 所有货物恰好堆积成一个长方体，边长为R*C*L。
 *
 * 目前，在某次确认货物的时候，管理员意识到这一堆货物被小偷偷走了一些。
 * 这个小偷将原来的R*C*L的货物组成的长方体偷成了恰好(R-2)*(C-1)*(L-2)的长方体。
 *
 * 但是管理员记不得的R,C,L具体数值了，他只能计算现在的货物总数。
 * 他希望算出来最坏情况下被偷了多少的货物，输出这个最坏的值。
 *
 *
 *
 * @date 2020-3-27 20:16
 */
public class T2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();

        /*
        减少的体积=被偷的
        考虑N=a*b*c  如果有x种情况
        总的有 3x种情况
        假设N因式分解为 a1*a2*...*an    则x大概=3^n
        */

        /*
        贪心，尽可能组成正方体
        N = a*b*c 若 a<=b<=c，则原面积为(a+2)(b+2)(c+1)

        */
        int up = N;
        int Max = -1;
        // i = C, j = R, k = L
        for(int i = 1; i <= N; i++){
            if (N % i != 0){
                continue;
            }
            int area = N / i;
            int b = (int)Math.sqrt(area);
            for(int j = i; j <= b; j++){
                if(area % j == 0){
                    int k = area / j;
                    up = Math.min(up,k);
                    Max = Math.max(Max,(i+2)*(j+2)*(k+1));
                }
            }
        }
        System.out.println(Max-N);
    }

}


