package Design.LeetCode;

import java.util.HashMap;

public class _359LoggerRateLimiter {

    HashMap<String, Integer> map;
    public _359LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
