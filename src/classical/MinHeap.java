package classical;

import java.util.Arrays;
import java.util.Random;

public class MinHeap {
    private int size;
    private int count = 0;
    private int[] arr;

    MinHeap(int size){
        this.size = size;
        this.arr = new int[size];
        Arrays.fill(arr,Integer.MAX_VALUE);
        this.count = 0;
    }

    public void insert(int num){
        if (count > size - 1)
            return;
        int k = count++;
        while (k > 0 && num < arr[(k-1)/2]){
            arr[k] = arr[(k-1)/2];
            k = (k - 1) / 2;
        }
        arr[k] = num;
    }

    public int pop(){
        if (isEmpty())
            return Integer.MIN_VALUE;
        int res = arr[0];
        int temp = arr[--count];
        int k = 0;
        while (true){
            int p = k * 2 + 1 <= count ? arr[k * 2 + 1] : Integer.MAX_VALUE;
            int q = k * 2 + 2 <= count ? arr[k * 2 + 2] : Integer.MAX_VALUE;
            int m = Math.min(p,Math.min(q,temp));
            if (m == temp)
                break;
            else if (m == p){
                arr[k] = arr[k * 2 + 1];
                k = k * 2 + 1;
            }
            else {
                arr[k] = arr[k * 2 + 2];
                k = k * 2 + 2;
            }
        }
        arr[k] = temp;
        return res;
    }

    public int peek(){
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[0];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public static void main(String[] args) {
        MinHeap minheap = new MinHeap(51);
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            minheap.insert(random.nextInt(99));
        }
        for (int i = 0; i < 50; i++) {
            System.out.print(minheap.pop() + " ");
        }
    }

}
