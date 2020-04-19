package exam.written.jd;/**
 * @description JD2
 * @author liusandao
 * @date 2020-4-18 20:16
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-18 20:16
 */

public class JD2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] conflict = new int[N];
//        Arrays.fill(conflict,1);
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][0] >= arr[j][1] || arr[j][0] >= arr[i][1]){
                    continue;
                }
                else {
                    conflict[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max,conflict[i]);
        }

        System.out.println(max);
    }

}
