package Algorithm.LeetCode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-27 10:14
 * @description: leetCode
 */
public class LeetCode07 {

    /**
     * method：parse to string
     * @param x
     * @return
     */
    public int reverse0(int x) {
        String s = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();

        if (s.charAt(0) == '-') {
            stringBuilder.append('-');
        }

        for (int i = s.length() - 1; i >= (s.charAt(0) == '-' ? 1 : 0); i--) {
            char c = s.charAt(i);
            stringBuilder.append(c);
        }

        try {
            // 使用 Long.parseLong 来转换为 long 类型以避免溢出
            long reversedLong = Long.parseLong(stringBuilder.toString());
            if (reversedLong > Integer.MAX_VALUE || reversedLong < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) reversedLong;
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    /**
     * method2:math
     * @param x
     * @return
     */

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long reversed = 0;  // 使用 long 类型来防止溢出

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;

            if (reversed > Integer.MAX_VALUE) {
                return 0;
            }

            x /= 10;
        }

        return (int) (reversed * sign);
    }
}
