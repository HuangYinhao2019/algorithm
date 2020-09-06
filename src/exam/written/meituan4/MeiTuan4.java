package exam.written.meituan4;

import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-29 16:36
 */

public class MeiTuan4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = -1;
        int[] maxConflict = new int[M + 1];
        for (int i = 0; i < N; i++) {
            max = Math.max(arr[i], max);
            if (arr[i] < max) {
                maxConflict[arr[i]] = max;
            }
        }
        int min = 100001;
        int[] minConflict = new int[M + 1];
        for (int i = N - 1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            if (arr[i] > min) {
                minConflict[arr[i]] = min;
            }
        }
        int sum = 1;
        int left = 0;
        for (int i = 1; i <= M; i++) {
            if ((maxConflict[1] > i || maxConflict[1] == 0) && (minConflict[i] == 0)) {
                sum++;
            } else {
                left = i - 1;
                break;
            }
        }
        int right = 0;
        for (int i = M; i >= 1; i--) {
            if ((minConflict[M] < i || minConflict[M] == 0) && (maxConflict[i] == 0)) {
                sum++;
            } else {
                right = i + 1;
                break;
            }
        }
        for (int j = M; j >= right; j--) {
            for (int i = 1; i <= left; i++) {
                if (maxConflict[i] >= j) {
                    left = i - 1;
                    break;
                }
            }
            if (left == 0) {
                break;
            } else {
                sum += left;
            }
        }
        System.out.println(sum);
    }

}
