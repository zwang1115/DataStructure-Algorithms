package String.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _271EncodeAndDecodeStrings {
    /**
     * Time: O(n)
     * Space: O(n)
     * @param strs
     * @return
     */

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf("/", i);
            int size = Integer.valueOf(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + 1 + size));
            i = slash + 1 + size;
        }
        return res;
    }
}
