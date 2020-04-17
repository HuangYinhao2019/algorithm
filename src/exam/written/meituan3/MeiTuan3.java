package exam.written.meituan3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan3
 * @date 2020-4-16 19:00
 */
public class MeiTuan3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        long K;
        N = sc.nextInt();
        K = sc.nextLong();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int x = arr[(int)((K-1) / N)];
        int y = arr[(int)((K-1) % N)];

        System.out.println("(" + x + "," + y + ")");

    }

}
