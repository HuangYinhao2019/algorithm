package offer;

import java.util.*;

public class Problem51to60 {
    private int count = 0;
    private int ans = 0;
    private boolean ans55 = true;

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

    public int kthLargest(TreeNode root, int k) {
        midTree(root,k);
        return ans;
    }

    private void midTree(TreeNode root, int k){
        if (root.right != null)
            midTree(root.right,k);
        count++;
        if (count == k)
            ans = root.val;
        if (root.left != null)
            midTree(root.left,k);
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(root.left == null ? 0 : maxDepth(root.left),(root.right == null ? 0 : maxDepth(root.right))) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        isb(root);
        return ans55;
    }

    private int isb(TreeNode root){
        int left = root.left == null ? 0 : isb(root.left);
        int right = root.right == null ? 0 : isb(root.right);
        if (Math.abs(left - right) > 1)
            ans55 = false;
        return Math.max(left,right) + 1;
    }

    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++)
            xor ^= nums[i];
        int k = xor & (-xor);
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & k) == 0)
                a ^= nums[i];
            else
                b ^= nums[i];
        }
        return new int[]{a,b};
    }

    public int singleNumberIII(int[] nums) {
        int k = 1, c = 0, res = 0;
        for (int i = 0; i < 32; i++) {
            c = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & k) == k)
                    c++;
            }
            if (c % 3 != 0)
                res |= k;
            k <<= 1;
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i]))
                return new int[]{nums[i],target-nums[i]};
        }
        return new int[]{0,0};
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 1;
        int low = 1, high = 1;
        while (high <= (target / 2) + 1) {
           if (sum < target)
               sum += ++high;
           else if (sum > target)
               sum -= low++;
           else{
               int[] a = new int[high - low + 1];
               for (int j = low; j <= high; j++)
                   a[j-low] = j;
               list.add(a);
               sum -= low++;
           }
        }
        return list.toArray(new int[list.size()][]);
    }

    public String reverseWords(String s) {
        while (s.startsWith(" "))
            s = s.substring(1);
        while (s.endsWith(" "))
            s = s.substring(0,s.length()-1);
        while (s.contains("  "))
            s.replaceAll("  ", " ");
        String[] str = s.split(" ");
        String ans = "";
        for (int i = str.length - 1; i >= 0; i--) {
            ans = ans.concat(str[i]);
            ans = ans.concat(" ");
        }
        return ans.substring(0,ans.length()-1);
    }

    public String reverseWordsII(String s) {
        s = s.trim(); //trim去除头尾空格
        if(s.equals("")) {
            return "";
        }
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder(); //节省空间？
        for(int i = sp.length - 1; i >= 0; i--) {
            sp[i].trim();
            if(sp[i].equals("")) {
                continue;
            }
            sb.append(sp[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        int maxindex = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            if (maxindex >= i && maxindex < i + k){
                if (nums[i + k - 1] >= max){
                    max = nums[i + k - 1];
                    maxindex = i + k - 1;
                }
            }
            else {
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxindex = j;
                    }
                }
            }
            ans[i] = max;
        }
        return ans;
    }

    static class MaxQueue {

        private Deque<Integer> queue;
        private Deque<Integer> help;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public int max_value() {
            return queue.isEmpty() ? -1 : help.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while(!help.isEmpty() && value > help.peekLast()) {
                help.pollLast();
            }
            help.offer(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) {
                return -1;
            }
//          错误写法:   .peek()返回Interger，两个对象用==比较的是地址
//            if(queue.peek() == help.peek())
//                help.pollFirst();
//            return queue.pollFirst();
            int val = queue.pop();
            if(help.peek() == val) {
                help.pop();
            }
            return val;
        }
    }

    public double[] twoSum(int n) {
        int [][]dp = new int[n+1][6*n+1];
        for(int s=1;s<=6;s++)dp[1][s]=1;
        for(int i=2;i<=n;i++){
            for(int s=i;s<=6*i;s++){
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)break;
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem51to60 p = new Problem51to60();
        System.out.println(p.search(new int[]{2, 2}, 2));
    }


}
