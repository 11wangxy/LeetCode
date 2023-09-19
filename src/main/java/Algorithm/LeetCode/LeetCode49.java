package Algorithm.LeetCode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-19 23:48
 * @description: leetCode
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if (list==null){
                list=new ArrayList<>();
                map.put(key,list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
