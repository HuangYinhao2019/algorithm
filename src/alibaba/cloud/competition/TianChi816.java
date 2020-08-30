package alibaba.cloud.competition;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-16 09:54
 */

public class TianChi816 {

    public class Circle {
        public double x;
        public double y;
        public double r;

        public Circle(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public String reformatString(String str, int[] sublen) {
        String[] s = new String[sublen.length];
        int n = 0;
        for (int i = 0; i < sublen.length; i++) {
            s[i] = str.substring(n, n + sublen[i]);
            n += sublen[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i += 2) {
            if (i + 1 < s.length) {
                sb.append(s[i + 1]);
                sb.append(s[i]);
            } else {
                sb.append(s[i]);
            }
        }
        return sb.toString();
    }

    public long doingHomework(int[] cost, int[] val) {
        Arrays.sort(val);
        long[] pre = new long[cost.length + 1];
        pre[0] = 0;
        for (int i = 0; i < cost.length; i++) {
            pre[i + 1] = pre[i] + cost[i];
        }
        int j = 0;
        long sum = 0;
        for (int i = 0; i < val.length; i++) {
            if (j + 1 < pre.length) {
                while (j + 1 < pre.length && val[i] >= pre[j + 1]) {
                    j++;
                }
                sum += pre[j];
            } else {
                sum += pre[j];
            }
        }
        return sum;
    }

    public int IfIntersect(double[] position) {
        double diff = 0.00001;
        double diff2 = 0.005;
        Circle A = new Circle(position[0], position[1], position[2]);
        Circle B = new Circle(position[3], position[4], position[5]);
        double x0 = position[6], y0 = position[7];
        double dis1 = Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
        double dis2 = Math.sqrt((x0 - B.x) * (x0 - B.x) + (y0 - B.y) * (y0 - B.y));
        if (Math.abs(dis1 - (A.r + B.r)) <= diff2 || Math.abs(dis2 - (A.r + B.r)) <= diff2) {
            return 1;
        }
        if (Math.abs(A.x - x0) <= diff) {
            if (A.y >= y0) {
                if (B.y >= y0 && B.y <= A.y) {
                    if (Math.abs((B.x - A.x) - (A.r + B.r)) <= diff2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            } else {
                if (B.y >= A.y && B.y <= y0) {
                    if (Math.abs((B.x - A.x) - (A.r + B.r)) <= diff2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else if (Math.abs(A.y - y0) <= diff) {
            if (A.x >= x0) {
                if (B.x >= x0 && B.x <= A.x) {
                    if (Math.abs((B.y - A.y) - (A.r + B.r)) <= diff2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            } else {
                if (B.x >= A.x && B.x <= x0) {
                    if (Math.abs((B.y - A.y) - (A.r + B.r)) <= diff2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            double k = (y0 - A.y) / (x0 - A.x);
            double b = y0 - (k * x0);
            double left = Math.min(A.x, x0), right = Math.max(A.x, x0);
            while (Math.abs(left - right) > diff) {
                double lefty = k * left + b;
                double righty = k * right + b;
                double disleft = Math.sqrt((left - B.x) * (left - B.x) + (lefty - B.y) * (lefty - B.y));
                double disright = Math.sqrt((right - B.x) * (right - B.x) + (righty - B.y) * (righty - B.y));
                if (Math.abs(disleft - (A.r + B.r)) <= diff2 || Math.abs(disright - (A.r + B.r)) <= diff2) {
                    return 1;
                }

                double midx = (left + right) / 2;
                double midy = k * midx + b;
                double dismid = Math.sqrt((midx - B.x) * (midx - B.x) + (midy - B.y) * (midy - B.y));
                if (Math.abs(dismid - (A.r + B.r)) <= diff2) {
                    return 1;
                }
                if (disleft > disright) {
                    left = midx;
                } else {
                    right = midx;
                }
            }
        }
        return -1;
    }

    public String kthString(int n, long k) {
        k--;
        short[] sh = new short[n];
        int j = sh.length - 1;
        while (k > 0 && j >= 1) {
            sh[j--] = (short)(k % 2);
            k /= 2;
        }
        if (k > 0) {
            sh[j--] = (short)(k % 3);
            k /= 3;
            if (k > 0) {
                return "";
            }
        }
        while (j >= 0) {
            sh[j--] = 0;
        }
        StringBuilder sb = new StringBuilder();
        if (sh[0] == 0) {
            sb.append("d");
        } else if (sh[0] == 1) {
            sb.append("e");
        } else {
            sb.append("f");
        }
        for (int i = 1; i < n; i++) {
            char c = sb.charAt(sb.length() - 1);
            if (c == 'd' && sh[i] == 0) {
                sb.append("e");
            } else if (c == 'd' && sh[i] == 1) {
                sb.append("f");
            } else if (c == 'e' && sh[i] == 0) {
                sb.append("d");
            } else if (c == 'e' && sh[i] == 1) {
                sb.append("f");
            } else if (c == 'f' && sh[i] == 0) {
                sb.append("d");
            } else if (c == 'f' && sh[i] == 1) {
                sb.append("e");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TianChi816 t = new TianChi816();
//        t.doingHomework(new int[]{1,2,3,5}, new int[]{6,10,4});
//        System.out.println(t.kthString(43215, 74151361351L));
        System.out.println(t.IfIntersect(new double[]{2,0.01,1,1,2,1,0,0}));
    }

}
