package classical;

//合并排序
public class MergeSort {

    static public int[] mergeArr(int []arr){
        if (arr.length == 1) return arr;
        else {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];
            for (int i = 0; i < left.length; i++)
                left[i] = arr[i];
            for (int i = 0; i < right.length; i++)
                right[i] = arr[mid + i];
            left = mergeArr(left);
            right = mergeArr(right);
            arr = mergesort(left,right);
        }
        return arr;
    }

    static private int[] mergesort(int[] left,int[] right){
        int[] temp = new int[left.length + right.length];
        int l = 0, r = 0;
        for (int i = 0; i < temp.length; i++) {
            if (l >= left.length)
                temp[i] = right[r++];
            else if (r >= right.length)
                temp[i] = left[l++];
            else if (left[l] <= right[r])
                temp[i] = left[l++];
            else
                temp[i] = right[r++];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] Arr = new int[]{8,7,6,5,4,3,2,1,0};
        Arr = mergeArr(Arr);
        for (int i = 0; i < Arr.length; i++) {
            System.out.println(Arr[i]);
        }
    }

}
