package algorithms.graph;

import java.util.ArrayList;

public class DisjointSet {
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public static void makeSet(ArrayList<GraphNode> nodeList){
        for (GraphNode currentNode: nodeList){
            DisjointSet set = new DisjointSet();
            set.nodeList.add(currentNode);
            currentNode.set=set;
        }
    }

    public static DisjointSet unionSet(GraphNode node1, GraphNode node2){
        DisjointSet set1 = node1.set;
        DisjointSet set2 = node2.set;

        if (!set1.equals(set2)){
            if (set1.nodeList.size()>set2.nodeList.size()){
                for (GraphNode currentNode : set2.nodeList){
                    currentNode.set=set1;
                    set1.nodeList.add(currentNode);
                }
            }
            else {
                for (GraphNode currentNode : set1.nodeList) {
                    currentNode.set = set2;
                    set2.nodeList.add(currentNode);
                }
            }
        }
        return null;
    }

    public static DisjointSet findSet(GraphNode node){
        return node.set;
    }
}
