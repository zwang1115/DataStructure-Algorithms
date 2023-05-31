package ArrayList.LeetCode;

public class _299BullsAndCows {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0) cows++;
                if (count[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
