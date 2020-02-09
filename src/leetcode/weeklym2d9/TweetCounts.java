package leetcode.weeklym2d9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TweetCounts {
    public HashMap<String,List<Integer>> map = new HashMap<String, List<Integer>>();
    public TweetCounts() {
        map = new HashMap<String, List<Integer>>();
    }

    public void recordTweet(String tweetName, int time) {
        if (!map.containsKey(tweetName)){
            List<Integer> l = new ArrayList<Integer>();
            l.add(time);
            map.put(tweetName,l);
        }
        else{
            List<Integer> l = map.get(tweetName);
            l.add(time);
            map.put(tweetName,l);
        }
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = 0;
        if (freq.equals("minute")) delta = 60;
        else if(freq.equals("hour")) delta = 3600;
        else if(freq.equals("day")) delta = 86400;
        if (!map.containsKey(tweetName)) return null;
        else{
            List<Integer> l = map.get(tweetName);
            int[] arr = new int[l.size()];
            int k = 0;
            for (Integer integer : l) {
                arr[k++] = integer;
            }
            List<Integer> ans = new ArrayList<Integer>();
            int length = ((endTime - startTime) / delta) + 1;
            Arrays.sort(arr);
            for (int i = 0; i < length; i++) {
                int s = startTime + i * delta;
                int e = i == length - 1 ? endTime + 1 : startTime + (i + 1) * delta;
                int a = BinarySearch(arr,s,"left");
                int b = BinarySearch(arr,e - 1,"right");
                ans.add(b - a + 1);
            }
            return ans;
        }
    }

    private int BinarySearch(int[] arr,int num,String m){
        int pos = - 1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (arr[mid] > num)
                r = mid - 1;
            else if (arr[mid] < num)
                l = mid + 1;
            else{
                pos = mid;
                if (m.equals("left")){
                    while (pos > 0 && arr[pos-1] == num)
                        pos--;
                }
                if (m.equals("right")){
                    while (pos < arr.length - 1 && arr[pos+1] == num)
                        pos++;
                }
                return pos;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);                             // "tweet3" 发布推文的时间分别是 0, 10 和 60 。
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // 返回 [2]。统计频率是每分钟（60 秒），因此只有一个有效时间间隔 [0,60> - > 2 条推文。
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。
        tweetCounts.recordTweet("tweet3", 120);                            // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
        tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // 返回 [4]。统计频率是每小时（3600 秒），因此只有一个有效时间间隔 [0,211> - > 4 条推文。
    }
}
