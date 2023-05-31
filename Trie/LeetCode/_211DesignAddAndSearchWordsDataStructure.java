package Trie.LeetCode;

public class _211DesignAddAndSearchWordsDataStructure {

    /**
     * Time: O(n)
     * Space: O(num of words * word.length() * 26
     */
    private TrieNode root;

    public _211DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return find(root, word, 0);
    }
    public boolean find(TrieNode cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        if (word.charAt(index) == '.') {
            for (TrieNode temp : cur.children) {
                if (temp != null && find(temp, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            char c = word.charAt(index);
            TrieNode temp = cur.children[c - 'a'];
            return temp != null && find(temp, word, index + 1);
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}
