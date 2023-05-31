package Graph.LeetCode;

import java.util.*;

public class _127WordLadder {

    /**
     * Time: O(m^2 * n)
     * Space: O(m^2 * n)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

    //Creating a graph
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Graph graph = new Graph();
        for (String word : wordList) {
            graph.addNode(new Node(word));
        }

        if (!wordList.contains(beginWord)) {
            graph.addNode(new Node(beginWord));
            wordList.add(beginWord);
        }

        for (String word : wordList) {
            Node node = graph.getNode(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (graph.getNode(temp) != null && !node.neighbors.contains(temp) &&
                            !temp.equals(word)) {
                        node.neighbors.add(graph.getNode(temp));
                    }
                }
            }
        }

        //BFS
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        int res = 0;

        visited.add(graph.getNode(beginWord));
        queue.offer(graph.getNode(beginWord));

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.word.equals(endWord)) {
                    return res;
                }
                for (Node neighbors : node.neighbors) {
                    if (!visited.contains(neighbors)) {
                        queue.offer(neighbors);
                        visited.add(neighbors);
                    }
                }
            }
        }
        return 0;
    }

    //Define a graph
    class Graph {
        List<Node> nodes;
        HashMap<String, Integer> map;

        public Graph() {
            this.nodes = new ArrayList<>();
            map = new HashMap<>();
        }

        public void addNode(Node node) {
            map.put(node.word, nodes.size());
            nodes.add(node);
        }

        public Node getNode(String word) {
            if (map.containsKey(word)) {
                return nodes.get(map.get(word));
            }
            return null;
        }
    }

    class Node {
        String word;
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new ArrayList<>();
        }
    }


    /**
     * Time: O(m^2 * n)
     * Space: O(n)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                        nextNum++;
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }
}
