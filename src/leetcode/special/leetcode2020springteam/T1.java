package leetcode.special.leetcode2020springteam;/**
 * @description T1
 * @author liusandao
 * @date 2020-4-25 14:53
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-25 14:53
 */

public class T1 {

    public int expectNumber(int[] scores) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < scores.length; i++) {
            set.add(scores[i]);
        }
        return set.size();
    }

}
