package exam.written.kuaishou;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author liusandao
 * @description KuaiShou1
 * @date 2020-4-12 15:49
 */
public class KuaiShou1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int right = 0, ans = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push('(');
            }
            else if (s.charAt(i) == ')'){
                if (stack.isEmpty()){
                    right++;
                }
                else {
                    stack.pop();
                    ans++;
                }
            }
        }

        System.out.println(ans + " " + stack.size() + " " + right);


    }

}
