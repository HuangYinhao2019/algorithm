package leetcode;

public class T299 {
    public String getHint(String secret, String guess) {
        int[]s = new int[10];
        int[]g = new int[10];
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            s[secret.charAt(i)-'0']++;
            g[guess.charAt(i)-'0']++;
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(s[i],g[i]);
        }
        cows -= bulls;
        String ans = "";
        ans = String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
        return ans;
    }

    public static void main(String[] args) {

    }
}
