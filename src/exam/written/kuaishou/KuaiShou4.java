package exam.written.kuaishou;

/**
 * @author liusandao
 * @description KuaiShou4
 * @date 2020-4-12 15:49
 */
public class KuaiShou4 {

    public int GetMaxStaffs (char[][] pos) {
        // write code here
        boolean[][] seat = new boolean[pos.length][pos[0].length];
        return traceBack(pos,seat,0,0,0);
    }

    public static int traceBack(char[][] pos , boolean[][] seat ,int i, int j, int num){
        if (j >= pos[i].length){
            if (i == pos.length - 1){
                if (valid(seat)) {
                    return num;
                }
                else {return 0;}
            }
            else {
                return traceBack(pos, seat,i + 1, 0, num);
            }
        }
        else if (pos[i][j] == '*'){
            return traceBack(pos, seat, i, j + 1, num);
        }
        else {
            seat[i][j] = true;
            int plana = traceBack(pos ,seat, i ,j + 1, num + 1);
            seat[i][j] = false;
            int planb = traceBack(pos ,seat, i, j + 1, num);
            return Math.max(plana, planb);
        }
    }

    public static boolean valid(boolean[][] pos){
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (!pos[i][j]){
                    continue;
                }
                else {
                    if (i - 1 >= 0 && pos[i-1][j]){
                        return false;
                    }
                    if (i + 1 < pos.length && pos[i+1][j]){
                        return false;
                    }
                    if (j - 1 >= 0 && pos[i][j-1]){
                        return false;
                    }
                    if (j + 1 < pos[0].length && pos[i][j+1]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] pos = new char[][]{{'*','.','*','*','.'},{'*','.','*','*','*'},{'*','.','*','*','.'}};
        char[][] pos = new char[][]{{'*','*'},{'*','*'}};
        System.out.println(new KuaiShou4().GetMaxStaffs(pos));
    }

}
