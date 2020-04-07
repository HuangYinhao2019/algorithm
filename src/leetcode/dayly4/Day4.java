package leetcode.dayly4;

import java.util.Stack;

/**
 * @author liusandao
 * @description day4
 * @date 2020-4-4 11:32
 */
public class Day4 {

    public int trap(int[] height) {
        Stack<Integer> st = new Stack<Integer>();

        int ans = 0;

        for (int i = 0; i < height.length; i++) {

            while (!st.isEmpty() && height[st.peek()] <= height[i]){
                int d = st.pop();
                if (st.isEmpty()){
                    break;
                }
                int left = st.peek();
                ans += (Math.min(height[i],height[left]) - height[d]) * (i - left - 1);
            }

            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]){
                int k = st.pop();
                int left = st.isEmpty() ? 0 : st.peek();

                ans = Math.max(heights[k] * (i - left - 1),ans);
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            int k = st.pop();
            int left = st.isEmpty() ? 0 : st.peek();
            ans = Math.max(ans,heights[k] * (heights.length - left - 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Day4().trap(arr));
    }

}
