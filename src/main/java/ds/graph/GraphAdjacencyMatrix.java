package ds.graph;

import java.util.*;

public class GraphAdjacencyMatrix {
    ArrayList<GraphNode> graphNodes;
    int[][] adjacencyMatrix;

    GraphAdjacencyMatrix(ArrayList<GraphNode> graphNodes){
        this.graphNodes = graphNodes;
        this.adjacencyMatrix = new int[graphNodes.size()][graphNodes.size()];
    }

    public void addUndirectedEdge(int i, int j){
        adjacencyMatrix[i][j]=1;
        adjacencyMatrix[j][i]=1;
    }

    public List<GraphNode> getNeighbours(GraphNode node){
        ArrayList<GraphNode> neighbours = new ArrayList<>();
        for (int i=0; i< graphNodes.size(); i++){
           if (adjacencyMatrix[node.index][i] == 1){
               neighbours.add(graphNodes.get(i));
           }
        }
        return neighbours;
    }

    public void visitDfs(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        node.isVisited=true;
        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            System.out.print(" "+currentNode.name+" ");
            for (GraphNode neighbour: getNeighbours(currentNode)){
                if (!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }

    public void dfs(){
        System.out.println("DFS Traversal: ");
        for (GraphNode node : graphNodes){
            if (!node.isVisited){
                visitDfs(node);
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
            for (GraphNode neighbour: getNeighbours(currentNode)){
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



    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < graphNodes.size(); i++) {
            s.append(graphNodes.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < graphNodes.size(); i++) {
            s.append(graphNodes.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
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

        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(nodeList);
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
