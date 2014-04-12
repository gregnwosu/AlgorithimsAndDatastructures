package producerconsumeralgos;

import BufferException.BufferException;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 22/02/13
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer(final int size) {
        super(size);
    }


    public  synchronized  void put(V v) throws BufferException {
        if (isFull()){
            throw new BufferException("Buffer Full");
        }
        doPut(v);
    }


    public synchronized  V get() throws BufferException {
        if (isEmpty()){
            throw new BufferException("Buffer Empty");
        }
        return doTake();

    }
}
