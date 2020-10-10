package model;

import exception.VertexException;

import java.util.HashMap;

public class Vertex {
    private final String vertexId;
    private final String vertexName;
    private final HashMap<String, Object> vertexMetadata;

    public Vertex(String name) {
        this(String.format("id-%s", name.toLowerCase()), name);
    }

    public Vertex(String id, String name) {
        this.vertexId = id;
        this.vertexName = name;
        this.vertexMetadata = new HashMap<>();
    }

    public String getVertexId() {
        return this.vertexId;
    }

    public String getVertexName() {
        return this.vertexName;
    }

    public void addDataToVertex(String key, Object value) {
        this.vertexMetadata.put(key, value);
    }

    public void removeDataFromVertex(String key) {
        this.vertexMetadata.remove(key);
    }

    public Object getDataFromVertex(String key) throws VertexException {
        if (!this.vertexMetadata.containsKey(key)) {
            throw new VertexException("Key not found in vertex metadata");
        }

        return this.vertexMetadata.get(key);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertexId='" + vertexId + '\'' +
                ", vertexName='" + vertexName + '\'' +
                ", vertexMetadata=" + vertexMetadata +
                '}';
    }
}
