package leetcode;

/**
 * @author liusandao
 * @description T4
 *              求两个有序数组的中位数(可扩展到求第k个数)
 * @date 2020-3-26 9:55
 */
public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int k1 = (len1 + len2 - 1) / 2;
        int k2 = (len1 + len2) / 2;
        return 0.5 * (findkth(nums1,0,nums2,0,k1) + findkth(nums1,0,nums2,0,k2));
    }

    private int findkth(int[] nums1, int start1, int[] nums2, int start2, int k){
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if (len1 > len2){
            return findkth(nums2,start2,nums1,start1,k);
        }
        if (len1 == 0){
            return nums2[start2+k];
        }
        if (k == 0){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int k1 = Math.min((k+1)/2 - 1,len1-1);
        int k2 = Math.min((k+1)/2 - 1,len2-1);
        int kk = Math.min(k1,k2);
        if (nums1[start1+kk] < nums2[start2+kk]){
            return findkth(nums1,start1+kk+1,nums2,start2,k-kk-1);
        }
        else {
            return findkth(nums1,start1,nums2,start2+kk+1,k-kk-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new T4().findMedianSortedArrays(new int[]{1},new int[]{2,3,4,5,6}));
    }
}
