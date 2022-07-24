package algorithms.graph;

import java.util.*;

public class MinimumSpanningTree {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    MinimumSpanningTree(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j, int weight){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        UndirectedEdge edge = new UndirectedEdge(first, second, weight);
        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    public void kruskal(){
        DisjointSet.makeSet(nodeList);
        Collections.sort(edgeList, Comparator.comparingInt(e -> e.weight));
        int cost =0;
        for (UndirectedEdge edge : edgeList){
            GraphNode first = edge.first;
            GraphNode second = edge.second;
            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
                DisjointSet.unionSet(first, second);
                cost+=edge.weight;
                System.out.println("Taken "+edge);
            }
        }
        System.out.println("Total cost: "+cost);
    }

    public void prism(){
        PriorityQueue<GraphNode> queue = new PriorityQueue<>();
        nodeList.get(0).distance=0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            for (GraphNode neighbour : currentNode.neighbours){
                if (queue.contains(neighbour)){
                    if (neighbour.distance > currentNode.weightMap.get(neighbour)){
                        neighbour.distance = currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }
        int cost =0;
        for (GraphNode node : nodeList){

            System.out.println("Distance of "+node.name+" :"+node.distance+" parent: ");
            cost+=node.distance;
        }
        System.out.println("\nTotal cost: "+cost);
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));

        MinimumSpanningTree graph = new MinimumSpanningTree(nodeList);
        graph.addUndirectedEdge(0,1,5);
        graph.addUndirectedEdge(0,2,13);
        graph.addUndirectedEdge(0,4,15);
        graph.addUndirectedEdge(1,2,10);
        graph.addUndirectedEdge(1,3,8);
        graph.addUndirectedEdge(2,3,6);
        graph.addUndirectedEdge(2,4,20);
        System.out.println("Print kruskal Algorithm....");
        graph.kruskal();

    }

}
