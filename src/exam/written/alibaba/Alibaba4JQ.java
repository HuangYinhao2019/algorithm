package exam.written.alibaba;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author JQ
 * @description Alibaba4JQ
 * @date 2020-3-30 20:37
 */
public class Alibaba4JQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        });
        for(int j: a){
            heap.offer(j+m*k);
        }
        for(int i=m;i>0;i--){
            int curMax=heap.poll();
//            int shallRemain=(curMax-i*k)/2+k/2;
            int shallRemain=(curMax-(i-1)*k)/2;
            int butRemain=(curMax-(i-1)*k);
//            curMax=curMax-(butRemain-shallRemain);
            curMax=curMax-((curMax-(i-1)*k)/2);
            heap.offer(curMax);
        }
        int count=0;
        for(int i=0;i<n;i++){
            count+=heap.poll();
        }
        System.out.println(count);
    }

}
