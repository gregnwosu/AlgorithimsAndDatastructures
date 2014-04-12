package datastructures.unionfind;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 07/02/13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class ForestUFTest {

    public ForestUF instance;
    @Test
    public void  testUnion(){
       instance = new ForestUF(10) ;
       assertEquals(Integer.valueOf(9),instance.find(9));
       assertEquals(Integer.valueOf(0),instance.find(0));
       instance.union(6,1);
       assertTrue(instance.connected(6,1));
       assertTrue(instance.connected(1,6));
       assertEquals(Integer.valueOf( 1), instance.find(6));
       assertEquals(Integer.valueOf(1), instance.find(1));
       instance.union(4,6);
       assertEquals(Integer.valueOf( 1), instance.find(4));
       assertTrue(instance.connected(4,1));
       instance.union(5, 2);
       instance.union(3,2);
       assertTrue(instance.connected(3,5));
       assertFalse(instance.connected(3,4));
       instance.union(2,1);
        assertTrue(instance.connected(3,4));


    }

}
