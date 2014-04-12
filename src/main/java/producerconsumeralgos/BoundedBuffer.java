package producerconsumeralgos;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 22/02/13
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public BoundedBuffer(int size){
        super(size);
    }


    public synchronized void put(V v) throws InterruptedException {
        while(isFull())
            wait();
        doPut(v);
        notifyAll();
    }


    public synchronized V get() throws InterruptedException {
        while(isEmpty())
            wait();
        V v = doTake();
        notifyAll();
        return v;
    }
}
