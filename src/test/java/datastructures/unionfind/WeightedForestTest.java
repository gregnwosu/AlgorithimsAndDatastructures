package datastructures.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 09/02/13
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class WeightedForestTest {


    private WeightedForest instance;

    @Test
    public void shouldMakeSmallerTreeTheChild(){
        this.instance = new WeightedForest(10);
        assertEquals(Integer.valueOf(9),instance.find(9));
        assertEquals(Integer.valueOf(0),instance.find(0));


        this.instance.union(6,1);
        assertTrue(instance.connected(6,1));
        assertTrue(instance.connected(1,6));
        assertEquals(Integer.valueOf( 1), instance.find(6));
        assertEquals(Integer.valueOf(1), instance.find(1));
        assertEquals(Integer.valueOf(2), instance.sz[instance.find(6)] );
        assertEquals(Integer.valueOf(2), instance.sz[instance.find(1)] );
        this.instance.union(1,0);
        assertTrue(instance.connected(6,0));
        assertEquals(Integer.valueOf(3), instance.sz[instance.find(6)] );
        assertEquals(Integer.valueOf(1), instance.find(0));
    }
}
