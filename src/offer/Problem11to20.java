package offer;

import java.math.BigInteger;

public class Problem11to20 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int minArray(int[] numbers) {
        if(numbers.length == 0) return 0;
        if(numbers.length == 1) return numbers[0];
        if(numbers.length == 2) return numbers[0] < numbers[1] ? numbers[0] : numbers[1];
        int l = 0,r = numbers.length - 1;
        int mid = (l + r) / 2;
        //int mid = l + ((r - l) / 2)防溢出
        while (l < r){
            mid = (l + r) / 2;
            if (numbers[mid] > numbers[r]){
                l = mid + 1;
            }
            else if(numbers[mid] == numbers[r])
                r--;
            else
                r = mid;
        }
        return numbers[l];
    }

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        if (word.equals(""))
            return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (_exist(board,i,j,w,0,visited))
                    return true;
            }
        }
        return false;
    }

    private boolean _exist(char[][] board, int c,int r, char[]w, int pos, boolean[][] visited){
        if (pos == w.length)
            return true;
        if (c < 0 || c >= board.length || r < 0 || r >= board[0].length || visited[c][r])
            return false;
        if (board[c][r] != w[pos])
            return false;
        visited[c][r] = true;
        boolean b = _exist(board,c+1,r,w,pos+1,visited) ||
                _exist(board,c-1,r,w,pos+1,visited) ||
                _exist(board,c,r+1,w,pos+1,visited) ||
                _exist(board,c,r-1,w,pos+1,visited);
        visited[c][r] = false;
        return b;
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return _movingCount(m,n,0,0,k,visited);
    }

    private int _movingCount(int m, int n, int i, int j, int k, boolean[][] visited){
        int ans = 0;
        if (i >= m || j >= n || visited[i][j])
            return 0;
        if (i % 10 + i / 10 + j % 10 + j / 10 <= k){
            ans++;
            visited[i][j] = true;
            ans += _movingCount(m,n,i+1,j,k,visited);
            ans += _movingCount(m,n,i,j+1,k,visited);
        }
        return ans;
    }

    public int cuttingRope(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3;i <= n;i++){
            int max = -1;
            for(int j = 1;j < i;j++)
                max = max > (arr[j] * (i - j)) ? max : (arr[j] * (i - j));
            for(int j = 1;j < i;j++)
                max = max > j * (i-j) ? max : j * (i - j);
            arr[i] = max;
        }
        return arr[n];
    }

    public int cuttingRopel(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int mod = (int)1e9 + 7;
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }

    public int BigcuttingRope(int n) {
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        /*
        d[i]表示长度为i的绳子剪完后各段乘积的最大值, 最终目标是dp[n]
        dp[i]可以看成是长度为i-k的绳子的最大值和长度为k的绳子的最大值的乘积, 子问题最优, 所以dp[i]也是最优
        状态转移方程: dp[i] = max(dp[i], dp[i-k]*dp[k])
        */
        //下面的初始值不同于上面的特殊情况, 上面是必须剪一刀, 下面的三个初始值不用再减了
        BigInteger[] dp = new BigInteger[n+1];
        dp[1] = new BigInteger("1");//内循环中会用到这个值
        dp[2] = new BigInteger("2");
        dp[3] = new BigInteger("3");
        for(int i=4; i<=n; i++){
            //初始化dp[i]
            dp[i] = new BigInteger("0");
            //长度为i的绳子有i-1个剪切位置; 不论i是奇数还是偶数, 只考虑前i/2个剪切位置即可, 后面的剪切位置是重复的
            for(int j=1; j<=i/2; j++){
                //因为j和i-j都小于i, 所以这是自底向上的计算方式
                dp[i] = dp[i].max(dp[j].multiply(dp[i-j]));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }

    public int hammingWeight(int n) {
        if (n >= 0) {
            int ans = 0;
            while (n > 0) {
                ans += n % 2;
                n /= 2;
            }
            return ans;
        }
        else{
            int ans = 0;
            n += 1 + Integer.MAX_VALUE;
            while(n > 0){
                ans += n % 2;
                n /= 2;
            }
            return ans + 1;
        }
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        else if (n > 0){
            double ans = 1;
            while (n > 0){
                if (n % 2 == 1)
                    ans *= x;
                n /= 2;
                x = x * x;
            }
            return ans;
        }
        else{
            double ans = 1;
            long p = -(long)n;
            while (p > 0){
                if (p % 2 == 1)
                    ans *= x;
                p /= 2;
                x = x * x;
            }
            return 1/ans;
        }
    }

    public int[] printNumbers(int n) {
        int[] ans = new int[(int)Math.pow(10,n) - 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i+1;
        }
        return ans;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;
        else{
            ListNode p = head;
            while (true){
                if (p.next.val == val){
                    p.next = p.next.next;
                    return head;
                }
                p = p.next;
            }
        }
    }

    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0)
            return true;
        else {
            if (s.length() > 0 && p.length() == 0)
                return false;
            if (s.length() == 0 && p.length() > 0)
            {
                if (p.length() > 1 && p.charAt(1) == '*')
                    return isMatch(s,p.substring(2));
                if (p.length() == 1 || (p.length() > 1 && p.charAt(1) != '*'))
                    return false;
            }
            if (!equal(s.charAt(0),p.charAt(0)) && (p.length() < 2 || p.charAt(1) != '*'))
                return false;
            else if (equal(s.charAt(0),p.charAt(0)) && (p.length() < 2 || p.charAt(1) != '*'))
                return isMatch(s.substring(1),p.substring(1));
            else if (equal(s.charAt(0),p.charAt(0)) && p.length() > 1 && p.charAt(1) == '*')
                return isMatch(s.substring(1),p) || isMatch(s,p.substring(2));
            else if (!equal(s.charAt(0),p.charAt(0)) && p.length() > 1 && p.charAt(1) == '*')
                return isMatch(s,p.substring(2));
        }
        return false;
    }

    private boolean equal(char a, char b){
        if (a == b || b == '.')
            return true;
        else
            return false;
    }

    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }

    public static void main(String[] args) {
        Problem11to20 p = new Problem11to20();
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(p.exist(board, word));
        System.out.println(p.movingCount(16, 8, 4));

        String s = "a";
        String q = ".*..a";
        System.out.println(p.isMatch(s, q));

    }

}
