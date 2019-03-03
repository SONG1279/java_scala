package com.song.leetcode;

import java.util.*;

public class Solution0133 {

    Map<Node, Node> map;

    public Node cloneGraph(Node node) {

        map = new HashMap<>();
        cloneIt(node);
        getIt();
        return map.get(node);


    }

    public void cloneIt(Node node){

        Node node1 = new Node();
        node1.val = node.val;
        map.put(node, node1);
        for (Node node2 : node.neighbors){
            if (!map.containsKey(node2)) cloneIt(node2);
        }
    }

    public void getIt(){

        for (Map.Entry<Node,Node> entry : map.entrySet()){

            Node node1 = entry.getKey();
            Node node2 = entry.getValue();
            List<Node> list = new ArrayList<>();
            for (Node node : node1.neighbors){
                list.add(map.get(node));
            }
            node2.neighbors = list;



        }

    }
}
