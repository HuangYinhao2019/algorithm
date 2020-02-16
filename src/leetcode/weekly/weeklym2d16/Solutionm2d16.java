package leetcode.weekly.weeklym2d16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solutionm2d16 {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0)
                    ans++;
            }
        }
        return ans;
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(); //学
        int day = 0, id = 0, n = events.length, res = 0;
        while(id < n || !queue.isEmpty()){
            if(queue.isEmpty()){
                queue.add(events[id][1]);
                day = events[id++][0];
            }
            while(id < n && events[id][0] <= day){
                queue.add(events[id++][1]);
            }
            if(queue.peek() >= day){
                day++;
                res++;
            }
            queue.poll();
        }
        return res;
    }


    public boolean isPossible(int[] target) {
        long sum = 0;
        int l = target.length;
        if(l == 1 && sum == 1)
            return true;
        else if(l == 1 && sum != 1)
            return false;
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            if ((target[i] - 1) % (l - 1) != 0)
                return false;
        }
        Arrays.sort(target);
        long ssum = l - 1;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == 1)
                continue;
            else{
                if (target[i] < ssum)
                    return false;
                ssum += target[i] - 1;
            }
        }
        if((sum - 1) % (l - 1) == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solutionm2d16 s = new Solutionm2d16();
        int[] test = new int[]{9,3,5};
        System.out.println(s.isPossible(test));
    }
}
