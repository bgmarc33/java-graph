package model;

import exception.GraphException;

import java.util.*;

public class Graph {
    private final boolean biDirectional;
    private final HashMap<String, Long> vertexToIndexMap;
    private final ArrayList<LinkedList<Edge>> adjacencyList;

    public Graph() {
        this(true);
    }

    public Graph(boolean biDirectional) {
        this.biDirectional = biDirectional;
        this.vertexToIndexMap = new HashMap<>();
        this.adjacencyList = new ArrayList<>();
    }

    public Set<String> getVertices() {
        return this.vertexToIndexMap.keySet();
    }

    public List<Edge> getEdges(Vertex vertex) throws GraphException {
        if (!this.vertexToIndexMap.containsKey(vertex.getVertexId())) {
            throw new GraphException("Vertex does not exist in graph");
        }

        return this.adjacencyList.get(this.vertexToIndexMap.get(vertex.getVertexId()).intValue());
    }

    public void addVertex(Vertex vertex) throws GraphException {
        if (vertexToIndexMap.containsKey(vertex.getVertexId())) {
            throw new GraphException("Duplicate vertex id");
        }

        this.vertexToIndexMap.put(vertex.getVertexId(), (long) this.adjacencyList.size());
        this.adjacencyList.add(new LinkedList<>());
    }

    public void removeVertex(Vertex vertex) {
        if (vertexToIndexMap.containsKey(vertex.getVertexId())) {
            long index = this.vertexToIndexMap.get(vertex.getVertexId());
            this.vertexToIndexMap.remove(vertex.getVertexId());

            this.adjacencyList.remove((int) index);
        }
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) throws GraphException {
        this.addEdge(vertex1, vertex2, 0L);
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Long weight) throws GraphException {
        if (!vertexToIndexMap.containsKey(vertex1.getVertexId()) ||
                !vertexToIndexMap.containsKey(vertex2.getVertexId())) {
            throw new GraphException("Unable to add edge on non-existing vertex");
        }

        LinkedList<Edge> edgesOnVertex1 =
                this.adjacencyList.get(this.vertexToIndexMap.get(vertex1.getVertexId()).intValue());
        Optional<Edge> existingVertexEdge = edgesOnVertex1
                .stream().filter(e -> (e.getConnectingVertex().equalsIgnoreCase(vertex2.getVertexId()))).findAny();
        if (existingVertexEdge.isEmpty()) {
            edgesOnVertex1.add(new Edge(vertex2.getVertexId(), weight));
            if (this.biDirectional) {
                LinkedList<Edge> edgesOnVertex2 =
                        this.adjacencyList.get(this.vertexToIndexMap.get(vertex2.getVertexId()).intValue());
                edgesOnVertex2.add(new Edge(vertex1.getVertexId(), weight));
            }
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) throws GraphException {
        if (!vertexToIndexMap.containsKey(vertex1.getVertexId()) ||
                !vertexToIndexMap.containsKey(vertex2.getVertexId())) {
            throw new GraphException("Unable to remove edge on non-existing vertex");
        }

        LinkedList<Edge> edgesOnVertex1 =
                this.adjacencyList.get(this.vertexToIndexMap.get(vertex1.getVertexId()).intValue());
        Optional<Edge> existingVertexEdge = edgesOnVertex1
                .stream().filter(e -> (e.getConnectingVertex().equalsIgnoreCase(vertex2.getVertexId()))).findAny();
        if (existingVertexEdge.isPresent()) {
            edgesOnVertex1.remove(existingVertexEdge.get());
            if (this.biDirectional) {
                LinkedList<Edge> edgesOnVertex2 =
                        this.adjacencyList.get(this.vertexToIndexMap.get(vertex2.getVertexId()).intValue());
                Optional<Edge> existingVertex2Edge = edgesOnVertex2
                        .stream().filter(e -> (e.getConnectingVertex().equalsIgnoreCase(vertex2.getVertexId()))).findAny();
                existingVertex2Edge.ifPresent(edgesOnVertex2::remove);
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "biDirectional=" + biDirectional +
                ", vertexToIndexMap=" + vertexToIndexMap +
                ", adjacencyList=" + adjacencyList +
                '}';
    }
}
