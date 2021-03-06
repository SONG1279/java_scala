package com.song.algorithms.search;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: 单词Trie树
 * </p>
 *
 * @createDate：2013-10-17
 * @author
 * @version 1.0
 */
public class WordTrie {
    class TrieNode {
        /**
         * trie tree word count
         */
        int count = 0;

        /**
         * trie tree prefix count
         */
        int prefixCount = 0;

        /**
         * 指向各个子树的指针,存储26个字母[a-z]
         */
        TrieNode[] next = new TrieNode[26];

        /**
         * 当前TrieNode状态 ,默认 0 , 1表示从根节点到当前节点的路径表示一个词,即叶子节点
         */
        int nodeState = 0;

        TrieNode() {
            count = 0;
            prefixCount = 0;
            next = new TrieNode[26];
            nodeState = 0;
        }
    }

    /** trie树根 */
    private TrieNode root = new TrieNode();

    /** 英文字符串正则匹配 */
    static String englishPattern = "^[A-Za-z]+$";
    /** 中文正则匹配 */
    static String chinesePattern = "[\u4e00-\u9fa5]";

    static int ARRAY_LENGTH = 26;

    static String zeroString = "";

    /**
     * 插入字串，用循环代替迭代实现
     *
     * @param words
     */
    public void insert(String word) {
        insert(this.root, word);
    }

    /**
     * 插入字串，用循环代替迭代实现
     *
     * @param root
     * @param words
     */
    private void insert(TrieNode root, String word) {
        word = word.toLowerCase();// //转化为小写
        char[] chrs = word.toCharArray();

        for (int i = 0, length = chrs.length; i < length; i++) {
            // /用相对于a字母的值作为下标索引，也隐式地记录了该字母的值
            int index = chrs[i] - 'a';
            if (index >= 0 && index < ARRAY_LENGTH) {//过滤特殊字符，例如`等
                if (root.next[index] != null) {
                    // //已经存在了，该子节点prefixCount++
                    root.next[index].prefixCount++;
                } else {
                    // /如果不存在
                    root.next[index] = new TrieNode();
                    root.next[index].prefixCount++;
                }

                // /如果到了字串结尾，则做标记
                if (i == length - 1) {
                    root.next[index].nodeState = 1;
                    root.next[index].count++;
                }
                // /root指向子节点，继续处理
                root = root.next[index];
            }
        }

    }

    /**
     *
     * @Title: addWord
     * @Description: add word
     * @param @param word
     * @return void
     * @throws
     */
    public void addWord(String word) {
        if (word == null || "".equals(word.trim())) {
            throw new IllegalArgumentException("word can not be null!");
        }
        // if(!word.matches(englishPattern)){
        // System.out.println(word);
        // throw new IllegalArgumentException("word must be english!");
        // }
        addWord(root, word);
    }

    /**
     *
     * @Title: addWord
     * @Description:add word to node
     * @param @param node
     * @param @param word
     * @return void
     * @throws
     */
    private void addWord(TrieNode node, String word) {
        if (word.length() == 0) { // if all characters of the word has been
            // added
            node.count++;
            node.nodeState = 1;
        } else {
            node.prefixCount++;
            char c = word.charAt(0);
            c = Character.toLowerCase(c);
            int index = c - 'a';
            if (index >= 0 && index < ARRAY_LENGTH) {
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                // go the the next character
                addWord(node.next[index], word.substring(1));
            }

        }
    }

    /**
     *
     * @Title: prefixSearchWord
     * @Description: 前缀搜索
     * @param @param word
     * @param @return
     * @return List<String>
     * @throws
     */
    public List<String> prefixSearchWord(String word) {
        if (word == null || "".equals(word.trim())) {
            return new ArrayList<String>();
        }
        if (!word.matches(englishPattern)) {
            return new ArrayList<String>();
        }
        char c = word.charAt(0);
        c = Character.toLowerCase(c);
        int index = c - 'a';
        if (root.next != null && root.next[index] != null) {
            return depthSearch(root.next[index], new ArrayList<String>(),
                    word.substring(1), "" + c, word);
        } else {
            return new ArrayList<String>();
        }
    }

    /**
     *
     * @Title: searchWord
     * @Description: 搜索单词,以a-z为根,分别向下递归搜索
     * @param @param word
     * @param @return
     * @return List<String>
     * @throws
     */
    public List<String> searchWord(String word) {
        if (word == null || "".equals(word.trim())) {
            return new ArrayList<String>();
        }
        if (!word.matches(englishPattern)) {
            return new ArrayList<String>();
        }
        char c = word.charAt(0);
        c = Character.toLowerCase(c);
        int index = c - 'a';
        List<String> list = new ArrayList<String>();
        if (root.next == null) {
            return list;
        }
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            int j = 'a' + i;
            char temp = (char) j;
            if (root.next[i] != null) {
                if (index == i) {
                    fullSearch(root.next[i], list, word.substring(1),
                            "" + temp, word);
                } else {
                    fullSearch(root.next[i], list, word, "" + temp, word);
                }
            }
        }
        return list;
    }

    /**
     *
     * @Title: fullSearch
     * @Description: 匹配到对应的字母,则以该字母为字根,继续匹配完所有的单词。
     * @param @param node
     * @param @param list 保存搜索到的字符串
     * @param @param word 搜索的单词.匹配到第一个则减去一个第一个,连续匹配,直到word为空串.若没有连续匹配,则恢复到原串。
     * @param @param matchedWord 匹配到的单词
     * @param @return
     * @return List<String>
     * @throws
     */
    private List<String> fullSearch(TrieNode node, List<String> list,
                                    String word, String matchedWord, String inputWord) {
        if (node.nodeState == 1 && word.length() == 0) {
            list.add(matchedWord);
        }
        if (word.length() != 0) {
            char c = word.charAt(0);
            c = Character.toLowerCase(c);
            int index = c - 'a';
            for (int i = 0; i < ARRAY_LENGTH; i++) {
                if (node.next[i] != null) {
                    int j = 'a' + i;
                    char temp = (char) j;
                    if (index == i) {
                        // 连续匹配
                        fullSearch(node.next[i], list, word.substring(1),
                                matchedWord + temp, inputWord);
                    } else {
                        // 未连续匹配,则重新匹配
                        fullSearch(node.next[i], list, inputWord, matchedWord
                                + temp, inputWord);
                    }
                }
            }
        } else {
            if (node.prefixCount > 0) {
                for (int i = 0; i < ARRAY_LENGTH; i++) {
                    if (node.next[i] != null) {
                        int j = 'a' + i;
                        char temp = (char) j;
                        fullSearch(node.next[i], list, zeroString, matchedWord
                                + temp, inputWord);
                    }
                }
            }
        }
        return list;
    }

    /**
     *
     * @Title: depthSearch
     * @Description: 深度遍历子树
     * @param @param node
     * @param @param list 保存搜索到的字符串
     * @param @param word 搜索的单词.匹配到第一个则减去一个第一个,连续匹配,直到word为空串.若没有连续匹配,则恢复到原串。
     * @param @param matchedWord 匹配到的单词
     * @param @return
     * @return List<String>
     * @throws
     */
    private List<String> depthSearch(TrieNode node, List<String> list,
                                     String word, String matchedWord, String inputWord) {
        if (node.nodeState == 1 && word.length() == 0) {
            list.add(matchedWord);
        }
        if (word.length() != 0) {
            char c = word.charAt(0);
            c = Character.toLowerCase(c);
            int index = c - 'a';
            // 继续完全匹配,直到word为空串,否则未找到
            if (node.next[index] != null) {
                depthSearch(node.next[index], list, word.substring(1),
                        matchedWord + c, inputWord);
            }
        } else {
            if (node.prefixCount > 0) {// 若匹配单词结束,但是trie中的单词并没有完全找到,需继续找到trie中的单词结束.
                // node.prefixCount>0表示trie中的单词还未结束
                for (int i = 0; i < ARRAY_LENGTH; i++) {
                    if (node.next[i] != null) {
                        int j = 'a' + i;
                        char temp = (char) j;
                        depthSearch(node.next[i], list, zeroString, matchedWord
                                + temp, inputWord);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 遍历Trie树，查找所有的words以及出现次数
     *
     * @return HashMap<String, Integer> map
     */
    public Map<String, Integer> getAllWords() {
        return preTraversal(this.root, "");
    }

    /**
     * 前序遍历。。。
     *
     * @param root
     *            子树根节点
     * @param prefixs
     *            查询到该节点前所遍历过的前缀
     * @return
     */
    private Map<String, Integer> preTraversal(TrieNode root, String prefixs) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        if (root != null) {

            if (root.nodeState == 1) {
                // //当前即为一个单词
                map.put(prefixs, root.count);
            }

            for (int i = 0, length = root.next.length; i < length; i++) {
                if (root.next[i] != null) {
                    char ch = (char) (i + 'a');
                    // //递归调用前序遍历
                    String tempStr = prefixs + ch;
                    map.putAll(preTraversal(root.next[i], tempStr));
                }
            }
        }

        return map;
    }

    /**
     * 判断某字串是否在字典树中
     *
     * @param word
     * @return true if exists ,otherwise false
     */
    public boolean isExist(String word) {
        return search(this.root, word);
    }

    /**
     * 查询某字串是否在字典树中
     *
     * @param word
     * @return true if exists ,otherwise false
     */
    private boolean search(TrieNode root, String word) {
        char[] chs = word.toLowerCase().toCharArray();
        for (int i = 0, length = chs.length; i < length; i++) {
            int index = chs[i] - 'a';
            if (root.next[index] == null) {
                // /如果不存在，则查找失败
                return false;
            }
            root = root.next[index];
        }

        return true;
    }
}

