package exam.written.gbit;

import java.util.Scanner;

/**
 * @author liusandao
 * @description Gbit1
 *              输入一个数N，求离N最近的素数，如果有两个，输出小的那个
 *
 * @date 2020-4-1 19:40
 */
public class Gbit1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            if (iss(N - i)){
                System.out.println(N - i);
                break;
            }
            if (iss(N + i)){
                System.out.println(N + i);
                break;
            }

        }
    }

    public static boolean iss(int p){
        if (p == 1 || p == 2){
            return true;
        }

        int sq = (int)Math.sqrt(p);
        for (int i = 2; i <= sq; i++) {
            if (p % i == 0){
                return false;
            }
        }

        return true;
    }

}
