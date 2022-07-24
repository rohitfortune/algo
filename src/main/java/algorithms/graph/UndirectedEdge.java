package algorithms.graph;

public class UndirectedEdge {
    GraphNode first;
    GraphNode second;
    int weight;

    UndirectedEdge(GraphNode first, GraphNode second, int weight){
        this.first=first;
        this.second=second;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "first=" + first.name +
                ", second=" + second.name +
                ", weight=" + weight +
                '}';
    }
}
