package model;

public class Edge {
    private final Long connectingVertexIndex;
    private final Long weight;

    public Edge(Long connectingVertexIndex) {
        this(connectingVertexIndex, 0L);
    }

    public Edge(Long connectingVertexIndex, Long weight) {
        this.connectingVertexIndex = connectingVertexIndex;
        this.weight = weight;
    }

    public Long getConnectingVertex() {
        return this.connectingVertexIndex;
    }

    public Long getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "connectingVertex='" + connectingVertexIndex + '\'' +
                ", weight=" + weight +
                '}';
    }
}
