package leetcode.common;

/**
 * @author liusandao
 * @description T28
 * @date 2020-3-6 18:30
 */
public class T28 {
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        if (l == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - l + 1; i++) {
            for (int j = 0, s = i; j < needle.length(); j++, s++) {
                if (haystack.charAt(s) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
