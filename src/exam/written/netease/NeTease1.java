package exam.written.netease;

import java.util.Scanner;

/**
 * @author liusandao
 * @description NeTease1
 * @date 2020-4-7 18:38
 */
public class NeTease1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        long[] arr = new long[N];
        long[] div = new long[N-1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
            if (i > 0){
                div[i-1] = arr[i] - arr[i-1];
                if (div[i-1] <= 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        /*
        d > 0 ,k > 0，所以数组是上升的
        N 个数，N-1个差，最大公约数？
         */
        long ans = div[0];
        for (int i = 1; i < N - 1; i++) {
            ans = gcd(ans, div[i]);
        }

        System.out.println(ans);
    }

    private static long gcd(long a, long b){
        if (a < b){
            return gcd(b,a);
        }
        else {
            return b == 0 ? a : gcd(b, a % b);
        }
    }


}
