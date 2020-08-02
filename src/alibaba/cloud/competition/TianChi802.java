package alibaba.cloud.competition;

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-02 09:51
 */

public class TianChi802 {

    public class Meeting {
        public int begin;
        public int end;
        public int value;

        public Meeting(int begin, int end, int value) {
            this.begin = begin;
            this.end = end;
            this.value = value;
        }
    }

    public List<Integer> ProductList(int offset, int n, int len1, int len2) {
        List<Integer> res = new ArrayList<>();
        if (offset < len1) {
            int begin = offset;
            res.add(begin);
            if (n >= len1 - offset) {
                n -= len1 - offset;
                res.add(len1);
                if (n >= len2) {
                    res.add(0);
                    res.add(len2);
                } else {
                    res.add(0);
                    res.add(n);
                }
            } else {
                res.add(offset + n);
                res.add(0);
                res.add(0);
            }
        } else if (offset >= len1 && offset <= len1 + len2) {
            res.add(len1);
            res.add(len1);
            res.add(offset - len1);
            if (n >= len1 + len2 - offset) {
                res.add(len2);
            } else {
                res.add(offset + n - len1);
            }
        } else {
            res.add(len1);
            res.add(len1);
            res.add(len2);
            res.add(len2);
        }
        return res;
    }

    public long MaximumProduct(int[] nums) {
        long min1 = 10001, min2 = 10001;
        long max1 = -10001, max2 = -10001, max3 = -10001;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public int maxValue(int[][] meeting, int[] value) {
        Meeting[] meetings = new Meeting[meeting.length];
        for (int i = 0; i < meeting.length; i++) {
            meetings[i] = new Meeting(meeting[i][0], meeting[i][1], value[i]);
        }
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.begin - o2.begin;
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{meetings[0].end, meetings[0].value});
        for (int i = 1; i < meetings.length; i++) {
            int max_value = meetings[i].value;
            for (int j = 0; j < list.size(); j++) {
                if (meetings[i].begin >= list.get(j)[0]) {
                    max_value = Math.max(max_value, meetings[i].value + list.get(j)[1]);
                }
            }
            boolean add = true;
            for (int j = 0; j < list.size(); j++) {
                if (meetings[i].end >= list.get(j)[0] && max_value <= list.get(j)[1]) {
                    add = false;
                    break;
                }
            }
            if (add) {
                list.add(new int[]{meetings[i].end, max_value});
            }
        }

        int ans = -1;
        for (int i = 0; i < list.size(); i++) {
            ans = Math.max(ans, list.get(i)[1]);
        }
        return ans;
    }

    public int theNumberofLuckyNumber(int l, int r) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        set.add("7");
        queue.offer("7");
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            String _poll = "0" + poll;
            Set<String> a = bfs(poll);
            Set<String> b = bfs(_poll);
            for (String x : a) {
                if (!set.contains(x) && Long.valueOf(x) <= r) {
                    set.add(x);
                    queue.offer(x);
                }
            }
            for (String x : b) {
                if (!set.contains(x) && Long.valueOf(x) <= r) {
                    set.add(x);
                    queue.offer(x);
                }
            }
        }
        int count = 0;
        for (String x : set) {
            if (Long.valueOf(x) >= l && Long.valueOf(x) <= r){
                count++;
            }
        }
        return count;
    }

    public Set<String> bfs(String str) {
        Set<String> res = new HashSet<>();
        char first = str.charAt(0);
        for (char i = '1'; i <= '9'; i++) {
            if (isNum((char)(i + first - '0'))) {
                String m = String.valueOf(i).concat(String.valueOf((char)(i + first - '0')));
                String r = str.substring(1);
                s(m, r, res);
            }
            if (isNum((char)(i - first + '0'))) {
                String m = String.valueOf(i).concat(String.valueOf((char)(i - first + '0')));
                String r = str.substring(1);
                s(m, r, res);
            }
        }
        return res;
    }

    public void s(String left, String right, Set<String> res) {
        if (right.length() == 0) {
            while(left.length() > 0) {
                if (left.charAt(0) == '0') {
                    left = left.substring(1);
                    continue;
                }
                break;
            }
            res.add(left);
        } else {
            char l = left.charAt(left.length() - 1);
            char r = right.charAt(0);
            if (isNum((char)(l + r - '0'))) {
                s(left + (char)(l + r - '0'), right.substring(1), res);
            }
            if (isNum((char)(l - r + '0'))) {
                s(left + (char)(l - r + '0'), right.substring(1), res);
            }
        }
    }

    public boolean isNum(char a) {
        return a >= '0' && a <= '9';
    }

    public static void main(String[] args) {
        TianChi802 t = new TianChi802();
        System.out.println(t.theNumberofLuckyNumber(10, 1000000000));
    }

}
