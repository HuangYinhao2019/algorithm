package leetcode.special.leetcode2020springteam;/**
 * @description T2
 * @author liusandao
 * @date 2020-4-25 14:53
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-25 14:53
 */

public class T2 {

    public int minTime(int[] time, int m) {
        int min = -1;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < time.length; i++){
            min = Math.max(min, time[i]);
        }
        while(max - min > 10){
            int mid = min + ((max - min) / 2);
            if (canSplit(time, m, mid)){
                max = mid;
            }
            else{
                min = mid;
            }
        }

        for(int i = max; i >= min; i--){
            if(!canSplit(time, m, i)){
                return i + 1;
            }
        }
        return min;
    }

    public boolean canSplit(int[] num, int m, int max){
        int count = 1;
        int sum = 0;
        int maxx = 0;
        for(int i = 0; i < num.length; i++){
            if(num[i] > max){
                return false;
            }
            maxx = Math.max(maxx, num[i]);
            sum += num[i];
            if (sum - maxx > max){
                sum = num[i];
                maxx = num[i];
                count++;
            }
            if (count > m){
                return false;
            }
        }
        if (count <= m){
            return true;
        } else {
            return false;
        }
    }

}
