package exam.written.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan1
 * @date 2020-4-2 18:43
 */
public class MeiTuan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,x;
        N = sc.nextInt();
        x = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        int i = 0, j = 0, sum = 0;
        while(j < N - 1){
            j++;
            while (i < j && arr[j] - arr[i] > x){
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        System.out.println(N - ans);
    }
}
