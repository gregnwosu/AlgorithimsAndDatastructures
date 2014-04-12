package producerconsumeralgos;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 22/02/13
 * Time: 09:35
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseBoundedBuffer<V> {
    private final V[] buf;
    private int tail;
    private int head;
    private int count;

    protected BaseBoundedBuffer(int size) {
        this.buf = (V[])new Object[size];
    }

    protected synchronized  final void  doPut(V v){
        buf[tail]=v;
        if (++tail==buf.length){
            tail = 0;
        }
        ++count;
    }

    protected  synchronized  final V  doTake() {
        V v = buf[head];
        buf[head] = null;
        if (++head == buf.length){
            head = 0;
        }
        --count;
        return v;
    }

    public synchronized final boolean isFull(){
        return count == buf.length;
    }

    public synchronized final boolean isEmpty(){
        return count == 0;
    }
}
