package producerconsumeralgos;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 19/02/13
 * Time: 01:20
 * To change this template use File | Settings | File Templates.
 */
interface Computable<A,V> {
    V computeExpensiveFunction(A arg) throws InterruptedException;
}


class ExpensiveFunction<A,V>  implements Computable<A,V>{

    @Override
    public V computeExpensiveFunction(A arg) throws InterruptedException {
        return (V) new Object();
    }
}

public class MemoizingConsumer
        <A,V> implements Computable<A,V> {
    private final Computable<A, V> computation;

    ConcurrentHashMap<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final ExecutorService service;

    public MemoizingConsumer(Computable<A, V> computation, ExecutorService service) {
        this.computation = computation;
        this.service = service;
    }

    @Override
    public V computeExpensiveFunction(final A arg) throws InterruptedException {

         Future<V> f = cache.get(arg);


        if (f==null){
            f =addNewTaskToCache(arg);
        }
        return getResult(f);
    }

    private V getResult(Future<V> f) throws InterruptedException {
        try{
            return f.get();
        }catch (ExecutionException ee){
            if (ee.getCause() instanceof NullPointerException ){
                throw (NullPointerException) ee.getCause();
            } else if (ee.getCause() instanceof RuntimeException ){
                throw (RuntimeException) ee.getCause();
            }  else if (ee.getCause() instanceof Error){
                throw (Error) ee.getCause();
            }
            else throw new IllegalStateException("not a runtime error ", ee.getCause());

        }
    }

    private Future<V> addNewTaskToCache(final A arg) {
        //create callable that does computation
        Callable<V> callable = new Callable<V>() {
            @Override
            public V call() throws Exception {
                return computation.computeExpensiveFunction(arg);  //To change body of implemented methods use File | Settings | File Templates.
            }
        }      ;
        final FutureTask<V> ft = new FutureTask<V>(callable);
        Future<V> t = cache.putIfAbsent(arg, ft);
        if (null == t){

            return (Future<V>)
                    service.submit(ft);
        }else{
            return t;
        }

    }


}