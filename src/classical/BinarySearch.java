package classical;

public class BinarySearch {
    static public int bisearch(int[] arr, int target, boolean first){
        int l = 0, r = arr.length - 1;
        int mid = l + ((r - l) / 2);
        int index = -1;
        while (l <= r){
            mid = l + ((r - l) / 2);
            if (arr[mid] == target) {
                index = mid;
                break;
            }
            else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (index == -1) return -1;
        if (first)
            while (index > 0 && arr[index - 1] == target)
                index--;
        else
            while (index < arr.length - 1 && arr[index + 1] == target)
                index++;
        return index;
    }

}
