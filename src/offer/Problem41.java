package offer;

import java.util.ArrayList;
import java.util.List;

public class Problem41 {
    private List<Integer> list = new ArrayList<>();
    public void MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty())
            list.add(num);
        else
            list.add(bisearch(list,num),num);
    }

    public double findMedian() {
        if (list.size() % 2 == 0)
            return (double)(list.get(list.size()/2) + list.get(list.size()/2 - 1)) / 2;
        else
            return (double)list.get(list.size()/2);
    }

    private int bisearch(List<Integer> list, int num){
        int l = 0, r = list.size() - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (list.get(mid) == num)
                return mid;
            else if (list.get(mid) < num)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (num >= list.get(l))
            return l + 1;
        else
            return l;
    }

    public static void main(String[] args) {
        Problem41 p = new Problem41();
        p.MedianFinder();
        p.addNum(-1);
        p.addNum(-2);
        p.addNum(-3);
    }

}
