package ArrayList.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _68TextJustification {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last - index - 1;
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int rest = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        sb.append(" ");
                    }
                    if (rest > 0) {
                        sb.append(" ");
                        rest--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}
