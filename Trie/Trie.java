package Trie;



public class Trie {

    TrieNode root;

    private void add(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    private boolean contains(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    private boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    private boolean search(String word) {
         return search(root, word, 0);
    }
    private boolean search(TrieNode cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        if (word.charAt(index) == '.') {
            for (TrieNode temp : cur.children) {
                if (temp != null && search(temp, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            char c = word.charAt(index);
            TrieNode temp = cur.children[c - 'a'];
            return temp != null && search(temp, word, index + 1);
        }
    }
}
