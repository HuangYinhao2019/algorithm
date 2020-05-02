package leetcode.special.leetcode2020spring.personal;/**
 * @description T3
 * @author liusandao
 * @date 2020-4-18 14:58
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-18 14:58
 */

public class T3 {

    public class Requirements{

        int index;
        int[] requirements;

        public Requirements(int index, int[]requirements){
            this.index = index;
            this.requirements = requirements;
        }

    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] ans = new int[requirements.length];
        Arrays.fill(ans,-1);
        Requirements[] requirements1 = new Requirements[requirements.length];
        Requirements[] requirements2 = new Requirements[requirements.length];
        Requirements[] requirements3 = new Requirements[requirements.length];
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        int[] times = new int[requirements.length];

        for (int i = 0; i < requirements.length; i++) {
            if (requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] == 0){
                ans[i] = 0;
            }
            requirements1[i] = new Requirements(i,requirements[i]);
            requirements2[i] = new Requirements(i,requirements[i]);
            requirements3[i] = new Requirements(i,requirements[i]);
        }
        Arrays.sort(requirements1, new Comparator<Requirements>() {
            @Override
            public int compare(Requirements o1, Requirements o2) {
                return o1.requirements[0] - o2.requirements[0];
            }
        });
        Arrays.sort(requirements2, new Comparator<Requirements>() {
            @Override
            public int compare(Requirements o1, Requirements o2) {
                return o1.requirements[1] - o2.requirements[1];
            }
        });
        Arrays.sort(requirements3, new Comparator<Requirements>() {
            @Override
            public int compare(Requirements o1, Requirements o2) {
                return o1.requirements[2] - o2.requirements[2];
            }
        });

        int C = 0, R = 0, H = 0;
        int in1 = 0;
        int in2 = 0;
        int in3 = 0;
        for (int i = 0; i < increase.length; i++) {
            C += increase[i][0];
            R += increase[i][1];
            H += increase[i][2];
            while (in1 < requirements.length && C >= requirements1[in1].requirements[0]){
                times[requirements1[in1].index]++;
                hashmap.put(requirements1[in1].index,i+1);
                in1++;
            }
            while (in2 < requirements.length && R >= requirements2[in2].requirements[1]){
                times[requirements2[in2].index]++;
                hashmap.put(requirements2[in2].index,i+1);
                in2++;
            }
            while (in3 < requirements.length && H >= requirements3[in3].requirements[2]){
                times[requirements3[in3].index]++;
                hashmap.put(requirements3[in3].index,i+1);
                in3++;
            }
        }
        for (int i = 0; i < requirements.length; i++) {
            if (times[i] == 3 && ans[i] == -1){
                ans[i] = hashmap.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] increase = new int[][]{{2,8,4},{2,5,0},{10,9,8}};
        int[][] requirements = new int[][]{{2,11,3},{15,10,7},{9,17,12},{8,1,14},{0,0,0}};
        int[] ans = new T3().getTriggerTime(increase,requirements);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
