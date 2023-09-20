package Algorithm.LeetCode;

import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-21 0:00
 * @description: leetCode
 */
public class LeetCode819 {
    /**
     * 1.截取为一个个单词
     * 2.把单词加入map集合，避免禁用词汇加入
     * 3.在map集合中找到value最大的
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set=Set.of(banned);
        HashMap<String, Integer> map=new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)){
                Integer value = map.get(key);
                if (value==null){
                    value=0;
                }
                map.put(key,value+1);
            }
        }
        int max=0;
        String s=null;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue()>max){
                max=m.getValue();
                s=m.getKey();
            }
        }
        return s;
    }
}
