package String.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _293FlipGame {

    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < currentState.length(); i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
                res.add(currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1, currentState.length()));
            }
        }
        return res;
    }
}
