package exam.written.meituan3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan4
 * @date 2020-4-16 19:01
 */
public class MeiTuan4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();
        int bigger = 0, smaller = 0, num_k = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > K){
                bigger++;
            }
            else if (num < K){
                smaller++;
            }
            else {
                num_k++;
            }
        }
        int add = smaller > bigger ? smaller - bigger : bigger - smaller - 1;
        add = Math.max(0,add);
        int div = num_k - 1;
        System.out.println(Math.max(0,add - div));

    }

}
