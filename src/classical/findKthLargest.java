package classical;

public class findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return (findKthNum(nums,0,nums.length-1,k-1));
    }

    private int findKthNum(int[] nums, int left, int right, int k){
        int stan = nums[right];
        int i = left, j = right;
        if (left == right && left == k) {
            return nums[left];
        }
        else {
            while (i < j) {
                while (i < j && nums[i] >= stan) {
                    i++;
                }
                while (i < j && nums[j] <= stan){
                    j--;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[right] = nums[i];
        nums[i] = stan;
        if (k < i) {
            return findKthNum(nums, left, i - 1, k);
        }
        else if (k > i) {
            return findKthNum(nums, i + 1, right, k);
        }
        else {
            return nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        findKthLargest f = new findKthLargest();
        System.out.println(f.findKthLargest(nums,5));
    }

}
