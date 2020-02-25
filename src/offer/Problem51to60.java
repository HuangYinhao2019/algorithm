package offer;

public class Problem51to60 {
    private int count = 0;

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        this.count = 0;
        mergeArr(nums);
        return this.count;
    }

    private int[] mergeArr(int []arr){
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

    private int[] mergesort(int[] left,int[] right){
        int[] temp = new int[left.length + right.length];
        int l = 0, r = 0;
        for (int i = 0; i < temp.length; i++) {
            if (l >= left.length)
                temp[i] = right[r++];
            else if (r >= right.length) {
                temp[i] = left[l++];
                count += r;
            }
            else if (left[l] <= right[r]){
                temp[i] = left[l++];
                count += r;
            }
            else
                temp[i] = right[r++];
        }
        return temp;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int countA = 1, countB = 1;
        ListNode pa = headA, pb = headB;
        while (pa.next != null){
            pa = pa.next;
            countA++;
        }
        while (pb.next != null){
            pb = pb.next;
            countB++;
        }
        if (pa != pb) return null;
        pa = headA;
        pb = headB;
        if (countA >= countB)
            for (int i = 0; i < countA - countB; i++)
                pa = pa.next;
        else
            for (int i = 0; i < countB - countA; i++)
                pb = pb.next;
        while (pa != pb){
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }

    public int search(int[] nums, int target) {
        int first = bisearch(nums, target, true), last = bisearch(nums, target, false);
        if (first == -1) return 0;
        return last - first + 1;
    }

    private int bisearch(int[] arr, int target, boolean first){
        int l = 0, r = arr.length - 1;
        int mid = (l + r) / 2;
        int index = -1;
        while (l <= r){
            mid = (l + r) / 2;
            if (arr[mid] == target) {
                index = mid;
                break;
            }
            else if (arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
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

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (nums.length * (nums.length + 1) / 2) - sum;
    }

    public int missingNumberII(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + ((high - low) >> 1);
            if(nums[mid] != mid){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[low] == low ? nums[low]+1 : nums[low]-1;
    }


    public static void main(String[] args) {
        Problem51to60 p = new Problem51to60();
        System.out.println(p.search(new int[]{2, 2}, 2));
    }


}
