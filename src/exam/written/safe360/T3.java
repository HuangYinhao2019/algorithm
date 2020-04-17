package exam.written.safe360;

import java.util.Scanner;

/**
 * @author liusandao
 * @description T3
 * @date 2020-4-16 15:11
 */
public class T3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        int now = sc.nextInt();
        int count = 0;
        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            int c = sc.nextInt();
            if (c < now){
                count++;
            }
            else {
                count = 1;
                now = c;
            }
            ans++;
            if (count >= M){
                break;
            }
        }
        if (count < M){
            ans += M - count;
        }

        System.out.println(ans);

    }

}
