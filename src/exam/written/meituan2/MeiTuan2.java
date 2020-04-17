package exam.written.meituan2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liusandao
 * @description MeiTuan2
 * @date 2020-4-9 18:49
 */
public class MeiTuan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] start = new int[N];
        int[] end = new int[N];
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < N; i++) {
            start[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            end[i] = sc.nextInt();
        }

        int ans = 0;
        int j = 0;
        for (int i = 0; i < N && j < N; i++) {
            int num = start[i];
            if (set.contains(num)){
                continue;
            }
            while(end[j] != num){
                set.add(end[j]);
                ans++;
                j++;
            }
            set.add(end[j]);
            j++;
        }
        System.out.println(ans);
    }

}
