package Algorithm.LeetCode;

import java.util.HashMap;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-19 1:13
 * @description: leetCode
 */
public class LeetCode03 {
    //具有错误
    public int lengthOfLongestSubstring0(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int begin =0;
        int maxLength=0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                begin = map.get(ch) + 1;
                map.put(ch,end);
            }else {
                map.put(ch,end);
            }
            int i = end - begin + 1;
            if (i>maxLength){
                maxLength=i;
            }
        }
        return maxLength;
    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                begin = Math.max(begin, map.get(ch) + 1);
            }
            map.put(ch, end);
            int currentLength = end - begin + 1;
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
