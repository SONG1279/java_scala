package com.song.leetcode;

public class Solution0208 {
}

class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode ws = root;
        for (char c : chars){

            if (ws.trieNodes[c - 'a'] == null) {
                ws.trieNodes[c - 'a'] = new TrieNode();
            }
            ws = ws.trieNodes[c -'a'];

        }
        root.value = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode ws = root;
        for (char c : chars){

            if (ws.trieNodes[c - 'a'] != null){
                ws = ws.trieNodes[c - 'a'];
            }else {
                return false;
            }


        }
        return ws.value;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode ws = root;
        for (char c : chars){

            if (ws.trieNodes[c - 'a'] != null){
                ws = ws.trieNodes[c - 'a'];
            }else {
                return false;
            }


        }
        return true;
    }

    class TrieNode{
        public TrieNode() {
        }



        boolean value = false;
        TrieNode[] trieNodes = new TrieNode[26];

    }
}
