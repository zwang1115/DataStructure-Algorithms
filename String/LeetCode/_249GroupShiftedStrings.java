package String.LeetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class _249GroupShiftedStrings {

    /**
     * Time: O(n * m)
     * Space: O(n)
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(s);
            map.put(key, list);

        }
        return new ArrayList<>(map.values());
    }
    private String getKey(String s) {
        char[] ch = s.toCharArray();
        String key = " ";
        for (int i = 1; i < ch.length; i++) {
            int diff = ch[i] - ch[i - 1];
            key += diff < 1 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
}
