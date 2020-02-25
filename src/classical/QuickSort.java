package classical;

import java.util.Random;

public class QuickSort {
    public static int[] Q(int[] arr){
        if (arr.length <= 1) return arr;
        int l = 0, r = arr.length - 1;
        arr =  quicksortIII(arr,l,r);
        return arr;
    }

    //交换法
    static private int[] quicksortII(int[] arr, int l, int r){
        if (l >= r) return arr;
        int right = r, left = l;
        int stan = arr[r];
        while (l < r){
            while (l < r && arr[l] <= stan)
                l++;
            while (l < r && arr[r] >= stan)
                r--;
            if (l >= r)
                break;
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        arr[right] = arr[l];
        arr[l] = stan;
        arr = quicksortII(arr, left, l - 1);
        arr = quicksortII(arr, l + 1, right);
        return arr;
    }
    //挖坑法
    static private int[] quicksort(int arr[], int l, int r) {
        if (l < r)
        {
            //Swap(arr[l], arr[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = arr[l];
            while (i < j)
            {
                while(i < j && arr[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    arr[i++] = arr[j];

                while(i < j && arr[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            quicksort(arr, l, i - 1); // 递归调用
            quicksort(arr, i + 1, r);
        }
        return arr;
    }
    //前后指针法，可针对链表
    static private int[] quicksortIII(int arr[], int l, int r){
        if (l >= r) return arr;
        int stan = arr[r];
        int cur = l, pre = cur - 1;
        while (cur < r){
            while (arr[cur] < stan && ++pre != cur){
                int temp = arr[cur];
                arr[cur] = arr[pre];
                arr[pre] = temp;
            }
            cur++;
        }
        pre++;
        int temp = arr[pre];
        arr[pre] = arr[r];
        arr[r] = temp;
        quicksortIII(arr, l, pre - 1);
        quicksortIII(arr, pre + 1, r);
        return arr;
    }
    //非递归，使用一个栈Stack来存储每次排序的l和r


    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[]{5,4,3,2,1};
//        for (int i = 0; i < arr.length; i++)
//            arr[i] = r.nextInt(10);
        arr = Q(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
