package exam.written.baidu;

import java.util.Scanner;

/**
 * @author liusandao
 * @description Baidu1
 * @date 2020-3-29 18:58
 */
public class Baidu1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        /*
        0(n^2)?  超时
        互质？  a * b - 1;  N和(N-1)一定互质？
         */
        System.out.println((long)N * (long)(N - 1) - (long)1);
    }

    private static int gcd(int a, int b){
        return a == 0 ? b : gcd(b % a,a);
    }

    private static int lcm(int a, int b){
        int g = gcd(a,b);
        a /= g;
        b /= g;
        return a * b;
    }

}
