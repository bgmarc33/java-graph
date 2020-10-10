package model;

import org.junit.Assert;
import org.junit.Test;

public class EdgeSpec {
    @Test
    public void testEdge() {
        Edge edge1 = new Edge("vertex1");
        Edge edge2 = new Edge("vertex2", 1L);

        Assert.assertEquals("vertex1", edge1.getConnectingVertex());
        Assert.assertEquals(0L, (long) edge1.getWeight());

        Assert.assertEquals("vertex2", edge2.getConnectingVertex());
        Assert.assertEquals(1L, (long) edge2.getWeight());
    }
}
