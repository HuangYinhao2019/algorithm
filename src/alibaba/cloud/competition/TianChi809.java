package alibaba.cloud.competition;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-09 10:00
 */

public class TianChi809 {

    public int maxNonNegativeSubArray(int[] A) {
        boolean f = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                f = false;
                break;
            }
        }
        if (f) {
            return -1;
        }

        int res = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                res = Math.max(res, sum);
                sum = 0;
            } else {
                sum += A[i];
            }
        }
        res = Math.max(res, sum);
        return res;
    }

    public long painttheCeiling(int s0, int n, int k, int b, int m, long a) {
        long res = 0;
        long[] s = new long[n];
        s[0] = (long)s0;
        k = k % m;
        b = b % m;
        for (int i = 1; i < n; i++) {
            long si = (((long)k * (s[i - 1]) + (long)b) % (long)m) + 1L + s[i - 1];
            s[i] = si;
        }
        int i = 0, j = n - 1;
        while (i < n && j >= 0) {
            if (s[i] * s[j] <= a) {
                res += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public long sortedArrangement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        long res = 1;
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = insert(list, nums[i]);
            int move = Math.min(index, list.size() - index);
            res += move * 2 + 1;
            list.add(index, nums[i]);
        }
        return res;
    }

    public long getSecondDiameter(int[][] edge) {
        int n = edge.length + 1;
        List<Map<Integer, Long>> distance = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            distance.add(new HashMap<>());
            distance.get(i).put(i, 0L);
        }
        long res1 = -1;
        long res2 = -1;
        for (int i = 0; i < edge.length; i++) {
            distance.get(edge[i][0]).put(edge[i][1], (long)edge[i][2]);
            distance.get(edge[i][1]).put(edge[i][0], (long)edge[i][2]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            Iterator<Map.Entry<Integer, Long>> iterator = distance.get(node).entrySet().iterator();
            //对所有该节点连接的节点进行遍历
            while (iterator.hasNext()) {
                Map.Entry<Integer, Long> next = iterator.next();
                Integer key = next.getKey();
                Long value = next.getValue();
                //对每个没有访问过的节点
                if (!visited.contains(key)) {
                    //对每个已访问过的节点
                    for (Integer integer : visited) {
                        //增加距离
                        long di = distance.get(node).get(integer) + value;
                        distance.get(integer).put(key, di);
                        distance.get(key).put(integer, di);
                        if (di > res2) {
                            res2 = di;
                        }
                        if (res2 > res1) {
                            res2 = res1;
                            res1 = di;
                        }
                    }
                    visited.add(key);
                    queue.offer(key);
                }
            }
        }
        return res2;
    }

    private int insert(List<Integer> list, int number) {
        int l = 0, r = list.size() - 1;
        int mid = (l + r) / 2;
        while (l <= r) {
            mid = (l + r) / 2;
            if (list.get(mid) < number) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (number >= list.get(mid)) {
            return mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        TianChi809 t = new TianChi809();
        System.out.println(t.getSecondDiameter(new int[][]{{0, 1, 4}, {0, 2, 7}}));
    }
}
