package leetcode.weekly.weeklym3d1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solutionm3d1 {

    private int[][] dp;
    private int c;
    private int r;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Team{
        char name;
        int[] rank;
        Team(char name, int[] rank){
            this.name = name;
            this.rank = rank;
        }
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0;i < ans.length;i++){
            for(int j = 0; j < ans.length;j++)
                if(nums[j] < nums[i])
                    ans[i]++;
        }
        return ans;
    }

    public String rankTeams(String[] votes) {
        Team[] team = new Team[26];
        for (int i = 0; i < team.length; i++) {
            team[i] = new Team((char)('A' + i),new int[26]);
        }
        for (int i = 0; i < votes.length; i++)
            for (int j = 0; j < votes[i].length(); j++)
                team[votes[i].charAt(j) -  'A'].rank[j]++;
        Arrays.sort(team, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                for (int i = 0; i < 26; i++) {
                    if (o1.rank[i] == o2.rank[i])
                        continue;
                    else if (o1.rank[i] < o2.rank[i])
                        return 1;
                    else
                        return -1;
                }
                return 0;
            }
        });
        String ans = new String("");
        for (int i = 0; i < votes[0].length(); i++)
            ans += team[i].name;
        return ans;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        else if (root == null) return false;
        else if (head.val != root.val)
            return isSubPath(head,root.left) || isSubPath(head,root.right);
        else {
            if (isSub(head.next,root.left) || isSub(head.next,root.right))
                return true;
            else
                return isSubPath(head,root.left) || isSubPath(head,root.right);
        }
    }

    private boolean isSub(ListNode head, TreeNode root){
        if (head == null) return true;
        else if (root == null || head.val != root.val)
            return false;
        else {
            return isSub(head.next,root.left) || isSub(head.next,root.right);
        }
    }

    public int minCost(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        c = grid.length;
        r = grid[0].length;
        for (int i = 0; i < dp.length; i++) 
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[c-1][r-1] = 0;
        dpCost(grid,c-1,r-1);
        return dp[0][0];
    }

    private void dpCost(int[][] grid, int i, int j){
        if (j + 1 < r && dp[i][j+1] > dp[i][j] + (grid[i][j+1] == 2 ? 0 : 1)){
            dp[i][j+1] = dp[i][j] + (grid[i][j+1] == 2 ? 0 : 1);
            dpCost(grid, i, j + 1);
        }
        if (j - 1 >= 0 && dp[i][j-1] > dp[i][j] + (grid[i][j-1] == 1 ? 0 : 1)){
            dp[i][j-1] = dp[i][j] + (grid[i][j-1] == 1 ? 0 : 1);
            dpCost(grid, i, j - 1);
        }
        if (i + 1 < c && dp[i+1][j] > dp[i][j] + (grid[i+1][j] == 4 ? 0 : 1)){
            dp[i+1][j] = dp[i][j] + (grid[i+1][j] == 4 ? 0 : 1);
            dpCost(grid, i + 1, j);
        }
        if (i - 1 >= 0 && dp[i-1][j] > dp[i][j] + (grid[i-1][j] == 3 ? 0 : 1)){
            dp[i-1][j] = dp[i][j] + (grid[i-1][j] == 3 ? 0 : 1);
            dpCost(grid, i - 1, j);
        }
    }
    
    public static void main(String[] args) {
        Solutionm3d1 s = new Solutionm3d1();
        String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB"};
        int[][] grid = new int[][]{{1,1,3},{3,2,2},{1,1,4}};
        System.out.println(s.minCost(grid));
    }

}
