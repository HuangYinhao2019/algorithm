package exam.written.duxiaoman;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description: 西西所在的国家有N座城市，每座城市有一道传送门，城市i的传送门通往城市a[i]
 *               当西西位于城市i时，每次他可以执行以下三种操作中的一种：
 *                   花费A的费用，从城市i前往城市a[i]；
 *                   如果a[i]>1，可以花费B的费用，将a[i]的值减少1；
 *                   如果a[i]<N，可以花费C的费用，将a[i]的值增加1。
 *               现在，西西想从城市1前往城市N，那么他至少花费多少费用？
 *
 *               输入：
 *               第一行输入四个整数 N、A、B、C(1<=N<=10000,1<=A,B,C<=100000)
 *               第二行输入N个整数，a[1]到a[N](1<=a[i]<=N)
 *
 *               输出：
 *               输出一个整数，表示从城市1前往城市N所花费的最少费用
 *
 *               样例输入
 *               7 1 1 1
 *               3 6 4 3 4 5 6
 *
 *               样例输出
 *               4
 *
 *               样例解释：
 *               将a[1]减少1，此时a[1]=2；
 *               从城市1前往城市2；
 *               将a[2]增加1，此时a[2]=7;
 *               从城市2前往城市7
 *
 *
 * @author: liusandao
 * @date 2020-04-20 17:17
 */

public class T2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        long A,B,C;
        N = sc.nextInt();
        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();
        int[] a = new int[N];

        HashSet<Integer> al = new HashSet<>();
        HashSet<Integer> no = new HashSet<>();
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
            no.add(i+1);
        }
        long[] shortest = new long[N];
        for(int i = 0; i < N; i++){
            shortest[i] = A + C * (N - a[i]);
        }
        no.remove(N);
        al.add(N);
        shortest[N-1] = 0;
        while(!al.contains(1)){
            long min = Long.MAX_VALUE;
            for(Integer tar : al){
                for(Integer st : no){
                    if(a[st-1] == tar){
                        shortest[st-1] = Math.min(shortest[tar-1] + A,shortest[st-1]);
                    }
                    else if(a[st-1] > tar){
                        shortest[st-1] = Math.min(shortest[tar-1] + (a[st-1] - tar) * B + A,shortest[st-1]);
                    }
                    else{
                        shortest[st-1] = Math.min(shortest[tar-1] + (tar - a[st-1]) * C + A,shortest[st-1]);
                    }
                    min = Math.min(min,shortest[st-1]);
                }
            }
            al.clear();
            Iterator<Integer> iterator = no.iterator();
            while (iterator.hasNext()){
                Integer in = iterator.next();
                if (shortest[in-1] == min){
                    al.add(in);
                    iterator.remove();
                }
            }
        }

        System.out.println(shortest[0]);

    }

}
