package model;

public class Edge {
    private final String connectingVertex;
    private final Long weight;

    public Edge(String connectingVertex) {
        this(connectingVertex, 0L);
    }

    public Edge(String connectingVertex, Long weight) {
        this.connectingVertex = connectingVertex;
        this.weight = weight;
    }

    public String getConnectingVertex() {
        return this.connectingVertex;
    }

    public Long getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "connectingVertex='" + connectingVertex + '\'' +
                ", weight=" + weight +
                '}';
    }
}
