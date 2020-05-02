package leetcode.common;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class T45T55T1306 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            s.add(i);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        while(!q.isEmpty()){
            int p = q.poll();
            if (p == nums.length - 1)
                return true;
            for (int i = 0; i < nums[p]; i++) {
                if (p + i + 1 == nums.length - 1)
                    return true;
                if (s.contains(p + i + 1)) {
                    q.offer(p + i + 1);
                    s.remove(p + i + 1);
                }
            }
        }
        return false;
    }

    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int p = nums.length - 1;
        int ans = 0;
        while (true){
            ans += 1;
            int newp = p;
            for (int i = p - 1; i >= 0; i--) {
                if (nums[i] + i >= p)
                    newp = i;
            }
            p = newp;
            if (p == 0)
                break;
        }
        return ans;
    }

    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(start);
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        while (!q.isEmpty()){
            int p = q.poll();
            if (arr[p] == 0)
                return true;
            if (p + arr[p] < arr.length && !s.contains(p + arr[p])){
                s.add(p + arr[p]);
                q.offer(p + arr[p]);
            }
            if (p - arr[p] >= 0 && !s.contains(p - arr[p])){
                s.add(p - arr[p]);
                q.offer(p - arr[p]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T45T55T1306 t = new T45T55T1306();
        int[] test = new int[]{2,3,1,1,4};
        System.out.println(t.jump(test));
    }
}
