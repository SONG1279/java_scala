package com.song.algorithms.search;


import org.junit.Test;

/**
 * 字典树的Java实现。实现了插入、查询以及深度优先遍历.
 * Trie tree's java implementation.(Insert,Search,DFS)
 * @author jiutianhe
 * @time 2012.10.16
 */
public class TrieTree {
    final int MAX_SIZE=26;
    public class TrieTreeNode {
        int nCount;//记录该字符出现次数
        char ch; //记录该字符
        TrieTreeNode[] child;

        public TrieTreeNode() {
            nCount=1;
            child=new TrieTreeNode[MAX_SIZE];
        }


    }
    //字典树的插入和构建
    public void createTrie(TrieTreeNode node,String str){
        if (str==null||str.length()==0) {
            return;
        }
        char[] letters=str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.child[pos] == null) {
                node.child[pos] = new TrieTreeNode();
            }else {
                node.child[pos].nCount++;
            }
            node.ch=letters[i];
            node = node.child[pos];
        }
    }
    //字典树的查找
    public int findCount(TrieTreeNode node,String str){
        if (str==null||str.length()==0) {
            return -1;
        }
        char[] letters=str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.child[pos] == null) {
                return 0;
            }else {
                node=node.child[pos];
            }
        }
        return node.nCount;
    }
    @Test
    public void trieTreeTest2(){
        /**
         * Problem Description
         * 老师交给他很多单词(只有小写字母组成,不会有重复的单词出现),现在老师要他统计
         * 出以某个字符串为前缀的单词数量(单词本身也是自己的前缀).
         */
        String[] strs={
                "banana",
                "band",
                "bee",
                "absolute",
                "acm",
        };
        String[] prefix={
                "ba",
                "b",
                "band",
                "abc",
        };
        TrieTree tree = new TrieTree();
        TrieTreeNode root=tree.new TrieTreeNode();

        for (String s : strs) {
            tree.createTrie(root, s);
        }
//        tree.printAllWords();
        for(String pre:prefix){
            int num=tree.findCount(root,pre);
            System.out.println(pre+" "+num);
        }

    }

}

