package leetcode;

/**
 * @author liusandao
 * @description T69
 * @date 2020-3-6 19:10
 */
public class T69 {
    static public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int l = 1, r = x / 2;
        while(l <= r){
            int mid = (l + r) / 2;
            long y1 = (long)mid * (long)mid;
            long y2 = (long)(mid-1) * (long)(mid-1);
            long y3 = (long)(mid+1) * (long)(mid+1);
            if (y1 <= x && y3 > x)
                return mid;
            if ((y1 > x && y2 <= x))
                return mid - 1;
            else if(y1 < x)
                l = mid + 1;
            else
                r = mid;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }
}
