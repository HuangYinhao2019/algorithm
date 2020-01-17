import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String s = "()";
        Stack<Character> t = new Stack<Character>();
        for(int i = 0;i < s.length();i++){
            if(t.empty())
                t.push(s.charAt(i));
            else if(s.charAt(i) == ')' && t.peek() == '(')
                t.pop();
            else if(s.charAt(i) == ']' && t.peek() == '[')
                t.pop();
            else if(s.charAt(i) == '}' && t.peek() == '{')
                t.pop();
            else
                t.push(s.charAt(i));
        }
        System.out.println("a" + 'b');

    }
}
