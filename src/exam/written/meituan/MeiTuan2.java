package exam.written.meituan;

import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan2
 * @date 2020-4-2 18:44
 */
public class MeiTuan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        long M;
        N = sc.nextInt();
        M = sc.nextLong();
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(arr[i],min);
            sum += arr[i];
        }
        int ans = 0;
        while (M >= sum){
            long q = M / sum; //表示能全走的圈数
            M = M % sum;
            ans += q * N;
        }
        int i = 0;
        while(M >= min){
            if (M >= arr[i]){
                ans++;
                M -= arr[i];
            }
            i = (i + 1) % N;
        }
        System.out.println(ans);
    }
}
