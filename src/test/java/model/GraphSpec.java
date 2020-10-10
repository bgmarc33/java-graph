package model;

import exception.GraphException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GraphSpec {
    @Test
    public void testAddVertex() throws GraphException {
        Graph graph = new Graph();

        Vertex v1 = new Vertex("newyork");
        graph.addVertex(v1);

        Assert.assertEquals(1, graph.getVertices().size());
        Assert.assertTrue(graph.getVertices().contains(v1.getVertexId()));

        Vertex v2 = new Vertex("sanfran");
        graph.addVertex(v2);

        Assert.assertEquals(2, graph.getVertices().size());
        Assert.assertTrue(graph.getVertices().contains(v2.getVertexId()));
    }

    @Test
    public void testRemoveVertex() throws GraphException {
        Graph graph = new Graph();

        Vertex v1 = new Vertex("newyork");
        graph.addVertex(v1);

        Vertex v2 = new Vertex("sanfran");
        graph.addVertex(v2);

        Assert.assertEquals(2, graph.getVertices().size());
        graph.removeVertex(v1);

        Assert.assertEquals(1, graph.getVertices().size());
        Assert.assertTrue(graph.getVertices().contains(v2.getVertexId()));
    }

    @Test
    public void testAddEdge() throws GraphException {
        Graph graph = new Graph();
        Vertex v1 = new Vertex("newyork");
        Vertex v2 = new Vertex("sanfran");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addEdge(v1, v2, 100L);

        List<Edge> v1Edges = graph.getEdges(v1);
        Assert.assertEquals(1, v1Edges.size());
        Assert.assertEquals(v2.getVertexId(), v1Edges.get(0).getConnectingVertex());

        List<Edge> v2Edges = graph.getEdges(v2);
        Assert.assertEquals(0, v2Edges.size());
    }

    @Test
    public void testAddEdgeBidirection() throws GraphException {
        Graph graph = new Graph(true);
        Vertex v1 = new Vertex("newyork");
        Vertex v2 = new Vertex("sanfran");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addEdge(v1, v2, 100L);

        List<Edge> v2Edges = graph.getEdges(v2);
        Assert.assertEquals(1, v2Edges.size());
        Assert.assertEquals(v1.getVertexId(), v2Edges.get(0).getConnectingVertex());
    }
}
