package org.forrestlin.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 前缀树
 * @author: forrestlin
 * @create: 2019-10-30 18:04
 */
public class L208ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie test = new Trie();
        test.insert("apple");
        test.search("app");
    }

}

class TrieNode {

    public TrieNode() {
        val = null;
        childs = new ArrayList<>();
        isEnd = false;
    }

    Character val;
    //是否存在包含当前节点的单词
    boolean isEnd;
    private List<TrieNode> childs;

    public Character getVal() {
        return val;
    }

    public void setVal(Character val) {
        this.val = val;
    }

    public List<TrieNode> getChilds() {
        return childs;
    }

    public void setChilds(List<TrieNode> childs) {
        this.childs = childs;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}

class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        List<TrieNode> childs = root.getChilds();
        TrieNode matchNode = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            matchNode = null;
            for (TrieNode node : childs) {
                if (node.getVal() == c) {
                    matchNode = node;
                    break;
                }
            }
            if (matchNode == null) {
                matchNode = new TrieNode();
                matchNode.setVal(c);
                childs.add(matchNode);
            }
            childs = matchNode.getChilds();

        }
        matchNode.setEnd(true);

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        List<TrieNode> childs = root.getChilds();
        TrieNode matchNode = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            matchNode = null;
            for (TrieNode node : childs) {
                if (node.getVal() == c) {
                    matchNode = node;
                    break;
                }
            }
            if (matchNode == null) {
                return false;
            }
            childs = matchNode.getChilds();
        }
        if (matchNode.isEnd()) {
            return true;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        List<TrieNode> childs = root.getChilds();
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            TrieNode matchNode = null;
            for (TrieNode node : childs) {
                if (node.getVal() == c) {
                    matchNode = node;
                    break;
                }
            }
            if (matchNode == null) {
                return false;
            }
            childs = matchNode.getChilds();
        }
        return true;
    }
}
