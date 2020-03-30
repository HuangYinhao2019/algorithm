package exam.written.baidu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Baidu2
 * @date 2020-3-29 18:58
 */
public class Baidu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N;
        N = sc.nextLong();
        long[] arr = new long[(int)N];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] >= N){
                q.offer(i);
            }
        }
        /*
        方法一：模拟  肯定不行
        方法二：每次操作总数-1   a[i]/n次操作，a[i] %= n  其他数+= a[i]/n   总和-=a[i]/n

         */
        long k = 0;
        while(!q.isEmpty()){
            int index = q.poll();
            long number = arr[index];
            k += number / N;
            arr[index] %= N;
            for (int i = 0; i < N; i++) {
                if (i != index){
                    arr[i] += number / N;
                    if (arr[i] >= N && !q.contains(i)){
                        q.offer(i);
                    }
                }
            }
        }

        System.out.println(k);
    }

}
