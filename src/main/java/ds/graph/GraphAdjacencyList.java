package ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyList {

    ArrayList<GraphNode> graphNodes = new ArrayList<>();

    GraphAdjacencyList(ArrayList<GraphNode> graphNodes){
        this.graphNodes = graphNodes;
    }

    public void addUndirectedEdge(int i, int j){
        GraphNode first = graphNodes.get(i);
        GraphNode second = graphNodes.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    // For printing Graph to the console

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < graphNodes.size(); i++) {
            s.append(graphNodes.get(i).name + ": ");
            for (int j =0; j < graphNodes.get(i).neighbors.size(); j++) {
                if (j == graphNodes.get(i).neighbors.size()-1 ) {
                    s.append((graphNodes.get(i).neighbors.get(j).name) );
                } else {
                    s.append((graphNodes.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void vistDfs(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        node.isVisited=true;
        while (!stack.isEmpty()){
            GraphNode currectNode = stack.pop();
            System.out.print(" "+currectNode.name+" ");
            for (GraphNode neighbour: currectNode.neighbors){
                if (!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }

    public void dfs(){
        System.out.println("DFS Traversal: ");
        for (GraphNode node: graphNodes){
            if (!node.isVisited){
                vistDfs(node);
            }
            node.isVisited=false;
        }
    }

    public void visitBfs(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        node.isVisited=true;
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            System.out.print(" "+currentNode.name+" ");
            for (GraphNode neighbour: currentNode.neighbors){
                if (!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }

    public void bfs(){
        System.out.println("\nBFS Traversal: ");
        for (GraphNode node: graphNodes){
            if (!node.isVisited){
                visitBfs(node);
            }
           node.isVisited=false;
        }
    }


    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));
        nodeList.add(new GraphNode("F",5));
        nodeList.add(new GraphNode("G",6));

        GraphAdjacencyList graph = new GraphAdjacencyList(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(1, 6);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 5);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(5, 6);
        System.out.println(graph.toString());

        graph.dfs();
        graph.bfs();
    }
}
