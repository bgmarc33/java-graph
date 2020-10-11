package model;

import org.junit.Assert;
import org.junit.Test;

public class EdgeSpec {
    @Test
    public void testEdge() {
        Edge edge1 = new Edge(1L);
        Edge edge2 = new Edge(2L, 1L);

        Assert.assertEquals(1L, (long) edge1.getConnectingVertex());
        Assert.assertEquals(0L, (long) edge1.getWeight());

        Assert.assertEquals(2L, (long) edge2.getConnectingVertex());
        Assert.assertEquals(1L, (long) edge2.getWeight());
    }
}
