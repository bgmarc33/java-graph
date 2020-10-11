package model;

import exception.VertexException;

import java.util.HashMap;

public class Vertex {
    private static Long id = 0L;

    private final Long vertexId;
    private final String vertexName;
    private final HashMap<String, Object> vertexMetadata;

    public Vertex() {
        this(id.toString());
    }

    public Vertex(String name) {
        this.vertexId = id++;
        this.vertexName = name;
        this.vertexMetadata = new HashMap<>();
    }

    public Long getVertexId() {
        return this.vertexId;
    }

    public String getVertexName() {
        return this.vertexName;
    }

    public String _getNormalizedVertexName() {
        return this.vertexName.toLowerCase().replace(' ', '_');
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
