package exam.written.meituan2;

import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan3
 * @date 2020-4-9 18:49
 */
public class MeiTuan3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();
        int l = 1, r = N;
        int ans = 0;
        while (l < r){
            int mid = (l + r) / 2;
            if (fix(N,K,1,mid) != -1){
                r = mid;
                ans = mid;
            }
            else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static int fix(int left, int k, int day, int x){
        int div = (int)Math.pow(k, day-1);
        int num = x / div;
        left -= num;
        if (left <= 0){
            return x;
        }
        else if (num == 0){
            return -1;
        }
        else {
            return fix(left, k, day + 1, x);
        }
    }
}
