package exam.written.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba2
 *              3-25 16:00-17:00场第一题
 * @date 2020-3-25 15:42
 */
public class Alibaba2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M, P;
        N = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        int[][] num = new int[N][M];
        int[][] q = new int[P][2];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < P; i++) {
            q[i][0] = sc.nextInt();
            q[i][1] = sc.nextInt();
        }
    }

}
