package Trie.LeetCode;

public class _208ImplementTrie_PrefixTree {

    /**
     * Time: O(n)
     * Space: O(num of words * word.length() * 26
     */
    TrieNode root;
    public _208ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (cur.children[j] == null) {
                cur.children[j] = new TrieNode();
            }
            cur = cur.children[j];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (cur.children[j] == null) return false;
            cur = cur.children[j];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (cur.children[j] == null) return false;
            cur = cur.children[j];
        }
        return true;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
