package algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphNode implements Comparable<GraphNode>{
  public String name;
  public int index;
  int distance=Integer.MAX_VALUE;
  public boolean isVisited = false;
  public GraphNode parent;
  public DisjointSet set;

  HashMap<GraphNode, Integer> weightMap = new HashMap<>();
  public ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();

  public GraphNode(String name, int index) {
    this.name = name;
    this.index = index;
  }

  @Override
  public int compareTo(GraphNode o) {
    return this.distance - o.distance;
  }
}
