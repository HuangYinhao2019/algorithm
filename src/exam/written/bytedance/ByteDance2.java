package exam.written.bytedance;/**
 * @description ByteDance2
 * @author liusandao
 * @date 2020-5-3 19:23
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-03 19:23
 */

public class ByteDance2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,R,r;
        N = sc.nextInt();
        R = sc.nextInt();
        r = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<long[] > p = new PriorityQueue<long[] >(((long[] o1, long[] o2) -> o1[1] < o2[1] ? -1 : 1));
        int x, y;
        for (int i = 1; i <= N; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            long dis = (long)x * (long)x + (long)y * (long)y;
            if (dis < R - r){
                ans.add(i);
            }
            else {
                p.add(new long[]{i, dis});
            }
        }
        while (!p.isEmpty()){
            ans.add((int)p.poll()[0]);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans.get(i));
            if(i < N - 1){
                System.out.println(" ");
            }
        }
    }

}
