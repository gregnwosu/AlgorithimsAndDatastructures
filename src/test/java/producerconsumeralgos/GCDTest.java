package producerconsumeralgos;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GCDTest {

    private GCD instance;

    @Test
    public void shouldGetGCD(){
       this.instance = new GCD();
       assertEquals(8, instance.gcd(24,3));

    }

}