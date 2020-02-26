import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorTest {
    // T 56
    private class IntComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b){
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, new IntComparator());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end){
                end = end > intervals[i][1] ? end : intervals[i][1];
                continue;
            }
            else {
                map.put(start,end);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        map.put(start,end);
        int[][] ans = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans[i][0] = entry.getKey();
            ans[i++][1] = entry.getValue();
        }
        return ans;
    }

}
