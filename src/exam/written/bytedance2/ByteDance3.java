package exam.written.bytedance2;/**
 * @description ByteDance3
 * @author liusandao
 * @date 2020-5-11 9:50
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-11 09:50
 */

public class ByteDance3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0, M = 0;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] color = new int[N];
        int[] bset = new int[N];
        for (int i = 0; i < N; i++) {
            color[i] = sc.nextInt();
            bset[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int ai = sc.nextInt() - 1;
            int bi = sc.nextInt() - 1;
            if (bset[ai] != bset[bi]){
                int t = bset[ai];
                for (int j = 0; j < N; j++) {
                    if (bset[j] == t){
                        bset[j] = bset[bi];
                    }
                }
            }
        }
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < bset.length; i++) {
            set.add(bset[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int s = iterator.next();
            int count = 0;
            int maxColor = -1;
            for (int i = 0; i < N; i++) {
                if (bset[i] == s){
                    if (count == 0){
                        count++;
                        maxColor = color[i];
                    } else if (count != 0 && color[i] == maxColor){
                        count++;
                    } else {
                        count--;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (bset[i] == s && color[i] != maxColor){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

}
