package jian;

public class minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        if(array.length == 2) return array[0] < array[1] ? array[0] : array[1];
        int l = 0,r = array.length - 1;
        int mid = (l + r) / 2;
        while(mid != 0 && mid != array.length - 1){
            if(array[mid] < array[mid-1] && array[mid] <= array[mid+1]) return array[mid];
            else{
                if(array[mid] >= array[0] && array[mid] <= array[array.length-1]) return array[0];
                if(array[mid] <= array[0] && array[mid] <= array[array.length-1]){
                    r = mid;
                    mid = (l + r) / 2;
                    continue;
                }
                if(array[mid] >= array[0] && array[mid] >= array[array.length-1]){
                    l = mid;
                    mid = (l + r) / 2;
                    if(mid == l) return array[array.length-1];
                    continue;
                }
            }
        }
        return array[mid];
    }

    public static void main(String[] args){
        minNumberInRotateArray m = new minNumberInRotateArray();
        int []array = new int[]{1,1,1,1,1,5,5};
        System.out.println(m.minNumberInRotateArray(array));
    }
}
