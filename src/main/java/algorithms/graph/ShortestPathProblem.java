package algorithms.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Single source shortest path problem
public class ShortestPathProblem {
    ArrayList<GraphNode> graphNodes;

    ShortestPathProblem(ArrayList<GraphNode> graphNodes){
        this.graphNodes=graphNodes;
    }

    public void addDirectedWeightedEgde(int i, int j, int distance){
        GraphNode first = graphNodes.get(i);
        GraphNode second = graphNodes.get(j);
        first.neighbours.add(second);
        first.weightMap.put(second, distance);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < graphNodes.size(); i++) {
            s.append(graphNodes.get(i).name + ": ");
            for (int j =0; j < graphNodes.get(i).neighbours.size(); j++) {
                if (j == graphNodes.get(i).neighbours.size()-1 ) {
                    s.append((graphNodes.get(i).neighbours.get(j).name) );
                } else {
                    s.append((graphNodes.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void dijkstra(GraphNode node){
        PriorityQueue<GraphNode> queue = new PriorityQueue<>();
        node.distance=0;
        queue.addAll(graphNodes);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            for (GraphNode neighbour : currentNode.neighbours){
                if (queue.contains(neighbour)){
                    if (neighbour.distance > currentNode.distance+ currentNode.weightMap.get(neighbour)){
                        neighbour.distance = currentNode.distance+ currentNode.weightMap.get(neighbour);
                        neighbour.parent=currentNode;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }
        printPath();
    }

    public void bellmanFord(GraphNode node){
        node.distance=0;
        for (int i=1; i< graphNodes.size(); i++){
            for (GraphNode currentNode : graphNodes){
                for (GraphNode neighbour : currentNode.neighbours){
                    if (neighbour.distance > currentNode.distance+currentNode.weightMap.get(neighbour)){
                        neighbour.distance=currentNode.distance+currentNode.weightMap.get(neighbour);
                        neighbour.parent=currentNode;
                    }
                }
            }
        }
        for (GraphNode currentNode : graphNodes){
            for (GraphNode neighbour : currentNode.neighbours){
                if (neighbour.distance > currentNode.distance+currentNode.weightMap.get(neighbour)){
                    int newDistance=currentNode.distance+currentNode.weightMap.get(neighbour);
                    System.out.println("Negative cycle found for vertex: "+neighbour.name);
                    System.out.println("New distance: "+newDistance);
                    System.out.println("Old distance: "+neighbour.distance);
                    return;
                }
            }
        }
        printPath();
    }

    private void printPath() {
        for (GraphNode graphNode : graphNodes) {
            System.out.print("Distance of " + graphNode.name + ": " + graphNode.distance + " path: ");
            printpath(graphNode);
            System.out.println("");
        }
    }

    private void printpath(GraphNode node) {
        if (node.parent != null){
            printpath(node.parent);
        }
        System.out.print(node.name+" ");
    }

    public void floydWarshall() {
        int size= graphNodes.size();
        int[][] v = new int[size][size];
        for (int i=0; i<size; i++){
            GraphNode first = graphNodes.get(i);
            for (int j=0; j<size; j++){
                GraphNode second = graphNodes.get(j);
                if (i==j){
                    v[i][j]=0;
                }
                else if (first.weightMap.containsKey(second)){
                    v[i][j] = first.weightMap.get(second);
                }
                else {
                    v[i][j] = Integer.MAX_VALUE/10;
                }
            }
        }

        for (int k=0; k<size; k++){
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if (v[i][j] > v[i][k]+v[k][j]){
                        v[i][j] = v[i][k]+v[k][j];
                    }
                }
            }
        }

        for (int i=0; i<size; i++){
            System.out.print("Printing distance from "+graphNodes.get(i).name+" ");
            for (int j=0; j<size; j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ShortestPathProblem directedGraph = createGraphAndPrint();
        System.out.println("\nDijkstra Algo: ");
        directedGraph.dijkstra(directedGraph.graphNodes.get(0));
        directedGraph = createGraphAndPrint();
        System.out.println("\nBellman Ford Algo: ");
        directedGraph.bellmanFord(directedGraph.graphNodes.get(0));

        //Creating diff graph for FloydWarshall
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        directedGraph = new ShortestPathProblem(nodeList);
        directedGraph.addDirectedWeightedEgde(0,3,1);
        directedGraph.addDirectedWeightedEgde(0,1,8);
        directedGraph.addDirectedWeightedEgde(1,2,1);
        directedGraph.addDirectedWeightedEgde(2,0,4);
        directedGraph.addDirectedWeightedEgde(3,1,2);
        directedGraph.addDirectedWeightedEgde(3,2,9);
        System.out.println("\nPrinting Floyd Warshall Algo result: ");
        directedGraph.floydWarshall();
    }


    //Helper methods for main method
    private static ShortestPathProblem createGraphAndPrint() {
        ArrayList<GraphNode> nodeList = createGraphNodes();
        ShortestPathProblem directedGraph = new ShortestPathProblem(nodeList);
        addEdgesToGraph(directedGraph);
        System.out.println("Printing graph: ");
        System.out.println(directedGraph);
        return directedGraph;
    }

    private static void addEdgesToGraph(ShortestPathProblem directedGraph) {
        directedGraph.addDirectedWeightedEgde(0,1,2);
        directedGraph.addDirectedWeightedEgde(0,2,5);
        directedGraph.addDirectedWeightedEgde(1,2,6);
        directedGraph.addDirectedWeightedEgde(1,3,1);
        directedGraph.addDirectedWeightedEgde(1,4,3);
        directedGraph.addDirectedWeightedEgde(3,4,4);
        directedGraph.addDirectedWeightedEgde(2,5,8);
        directedGraph.addDirectedWeightedEgde(5,6,7);
        directedGraph.addDirectedWeightedEgde(4,6,9);
    }

    private static ArrayList<GraphNode> createGraphNodes() {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));
        nodeList.add(new GraphNode("F",5));
        nodeList.add(new GraphNode("G",6));
        return nodeList;
    }
}
