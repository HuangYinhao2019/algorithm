package leetcode.weekly.weeklym3d22;

import java.util.*;

/**
 * @author liusandao
 * @description Solutionm3d22
 * @date 2020-3-22 10:37
 */
public class Solutionm3d22 {

    private boolean [][]visited;
    private Map<Integer,int[]> m = new HashMap<>();
    private int[] dr = new int[]{0,-1,0,1};
    private int[] dc = new int[]{-1,0,1,0};

    {
        m.put(1,new int[]{1,3});
        m.put(2,new int[]{0,2});
        m.put(3,new int[]{1,2});
        m.put(4,new int[]{2,3});
        m.put(5,new int[]{0,1});
        m.put(6,new int[]{0,3});
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i],nums[i]);
        }

        int[] arr = new int[nums.length];
        Integer[] a = new Integer[0];
        list.toArray(a);
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    public int sumFourDivisors(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 5 || nums[i] == (int)Math.sqrt(nums[i]) * (int)Math.sqrt(nums[i])){
                continue;
            }
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            l.add(1);
            int sq = (int)Math.sqrt(nums[i]);
            for (int j = 2; j <= sq; j++) {
                if (nums[i] % j == 0){
                    l.add(nums[i] / j);
                    l.add(j);
                }
                if (l.size() > 4){
                    break;
                }
            }
            if (l.size() == 4) {
                for (int k = 0; k < l.size(); k++) {
                    ans += l.get(k);
                }
            }
        }
        return ans;
    }

    public boolean hasValidPath(int[][] grid) {

        visited = new boolean[grid.length][grid[0].length];

        if (grid[0][0] == 4 || grid[0][0] == 5){
            boolean b1 = findPath(grid,0,0,m.get(grid[0][0])[0]);
            visited = new boolean[grid.length][grid[0].length];
            boolean b2 = findPath(grid,0,0,m.get(grid[0][0])[1]);
            return b1 || b2;
        }
        else {
            return findPath(grid,0,0,m.get(grid[0][0])[0]);
        }
    }

    private boolean findPath(int[][] grid, int i, int j, int dcome){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]){
            return false;
        }
        else {
            visited[i][j] = true;
            int[] arr = m.get(grid[i][j]);
            if (dcome == arr[0]){
                if (i == grid.length - 1 && j == grid[0].length - 1){
                    return true;
                }
                return findPath(grid,i + dc[arr[1]], j + dr[arr[1]], (arr[1] + 2) % 4);
            }
            else if(dcome == arr[1]){
                if (i == grid.length - 1 && j == grid[0].length - 1){
                    return true;
                }
                return findPath(grid,i + dc[arr[0]], j + dr[arr[0]], (arr[0] + 2) % 4);
            }
            else {
                return false;
            }
        }

    }

    public String longestPrefix(String s) {
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (s.substring(i).equals(s.substring(0,len-i))){
                return s.substring(i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{2,4,3},{6,5,2}};
//        int[][] grid = new int[][]{{1,1,2}};
//        int[][] grid = new int[][]{{4,1},{6,1}};
//        System.out.println(new Solutionm3d22().hasValidPath(grid));

    }

}
