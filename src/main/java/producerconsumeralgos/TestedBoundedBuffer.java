package producerconsumeralgos;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 01/06/13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@ThreadSafe
public class TestedBoundedBuffer<E> {

    @GuardedBy("this")
    private final Semaphore availableItems, availableSpaces;

    public TestedBoundedBuffer(final int capacity) {
        availableItems = null;
        availableSpaces = null;
    }



}
