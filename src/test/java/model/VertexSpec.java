package model;

import exception.VertexException;
import org.junit.Assert;
import org.junit.Test;

public class VertexSpec {
    @Test
    public void testVertex() throws VertexException {
        Vertex v1 = new Vertex("test");
        v1.addDataToVertex("name", "bryan");
        v1.addDataToVertex("age", 25);

        Assert.assertEquals(0L, (long) v1.getVertexId());
        Assert.assertEquals("test", v1.getVertexName());
        Assert.assertEquals("bryan", v1.getDataFromVertex("name"));
        Assert.assertEquals(25, (int) v1.getDataFromVertex("age"));

        v1.removeDataFromVertex("age");

        try {
            v1.getDataFromVertex("age");
            Assert.fail();
        } catch (VertexException ignore) {}

        Vertex v2 = new Vertex("test");
        Assert.assertEquals(1L, (long) v2.getVertexId());
        Assert.assertEquals("test", v2.getVertexName());

        Vertex v3 = new Vertex("test NAME");
        Assert.assertEquals("test_name", v3._getNormalizedVertexName());
    }
}
