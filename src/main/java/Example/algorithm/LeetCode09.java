package Example.algorithm;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-27 10:48
 * @description: leetCode
 */
public class LeetCode09 {
    /**
     * method:math
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int s=x;
        if (x<0){
            return false;
        }
        long y=0;
        while (x>0){
            int i=x%10;
            y = (y * 10) + i;
            x /= 10;
        }
        return (int) y == s;
    }

    /**
     * method：parse to string
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
