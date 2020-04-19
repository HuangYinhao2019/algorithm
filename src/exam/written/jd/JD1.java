package exam.written.jd;/**
 * @description JD1
 * @author liusandao
 * @date 2020-4-18 19:36
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-18 19:36
 */

public class JD1 {

    public static String[] ans;

    public static boolean isBox(int[][] area, Map<Integer,Integer> map){
        if (map.size() == 3){
            int[]arr = new int[3];
            int i = 0;
            for(Map.Entry<Integer,Integer> m : map.entrySet()){
                if (m.getValue() != 4){
                    return false;
                }
                arr[i++] = m.getKey();
            }
            int LW = 2;
            int WH = 2;
            int HL = 2;
            for (i = 0; i < area.length; i++) {
                if ((area[i][0] == arr[0] && area[i][1] == arr[1]) || (area[i][0] == arr[1] && area[i][1] == arr[0])){
                    LW--;
                }
                else if ((area[i][0] == arr[1] && area[i][1] == arr[2]) || (area[i][0] == arr[2] && area[i][1] == arr[1])){
                    WH--;
                }
                else if ((area[i][0] == arr[0] && area[i][1] == arr[2]) || (area[i][0] == arr[2] && area[i][1] == arr[0])){
                    HL--;
                }
                else {
                    return false;
                }
            }
            if (LW == 0 && WH == 0 && HL == 0){
                return true;
            }
            return false;
        }
        else {
            int A8 = 0, B4 = 0;
            int i = 0;
            for(Map.Entry<Integer,Integer> m : map.entrySet()){
                if (m.getValue() != 4 && m.getValue() != 8){
                    return false;
                }
                if (m.getValue() == 4){
                    B4 = m.getKey();
                }
                if (m.getValue() == 8){
                    A8 = m.getKey();
                }
            }
            int AA = 2;
            int AB = 4;
            for (i = 0; i < area.length; i++) {
                if (area[i][0] == A8 && area[i][1] == A8){
                    AA--;
                }
                else if((area[i][0] == A8 && area[i][1] == B4) || (area[i][0] == B4 && area[i][1] == A8)){
                    AB--;
                }
                else {
                    return false;
                }
            }
            if (AA == 0 && AB == 0){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        ans = new String[T];
        for(int i = 0; i < T; i++){
            int[][] area = new int[6][2];
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = 0; j < 6; j++){
                for(int k = 0; k < 2; k++){
                    area[j][k] = sc.nextInt();
                    if (!map.containsKey(area[j][k])) {
                        map.put(area[j][k], 1);
                    }else {
                        map.put(area[j][k],map.get(area[j][k]) + 1);
                    }
                }
            }
            if(map.size() > 3 || map.size() == 0){
                ans[i] = "IMPOSSIBLE";
            }
            else if(map.size() == 1){
                ans[i] = "POSSIBLE";
            }
            else{
                if (isBox(area,map)){
                    ans[i] = "POSSIBLE";
                }
                else {
                    ans[i] = "IMPOSSIBLE";
                }
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(ans[i]);
        }


    }

}
