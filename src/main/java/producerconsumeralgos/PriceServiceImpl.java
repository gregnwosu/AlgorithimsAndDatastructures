package producerconsumeralgos;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 11/03/13
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
public class PriceServiceImpl implements PriceService {
    private ConcurrentHashMap<String, Future<List<Listener>>> cache = new ConcurrentHashMap<String, Future<List<Listener>>>();
    private ExecutorService service = Executors.newCachedThreadPool();

    @Override
    public void addListener(final String name, final Listener listener) {


        Future<List<Listener>>  registerTask = cache.get(name);

        if (registerTask ==null){
            registerTask = addTaskToCache(name, listener);
        }

        try {
            registerTask.get().add(listener);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            final Throwable cause = e.getCause();
            if (cause instanceof  SomeApplicationException){
                throw (SomeApplicationException) cause;
            }                                         else if (cause instanceof Error){
                throw (Error) cause;
            }
            else if (cause instanceof RuntimeException){
                throw (RuntimeException) cause;
            }
            throw new IllegalStateException("not a runtime excpetion",cause);
        }


    }

    private Future<List<Listener>> addTaskToCache(final String name, final Listener listener) {

        Callable<List<Listener>> refisterListenerTask = new Callable<List<Listener>>(){


            @Override
            public List<Listener> call() throws Exception {
                    PriceServiceImpl.this.registerListner(listener);
                    return addToList(listener);
                }

            private List<Listener> addToList(Listener listener) {
                final List<Listener> newListeners = new CopyOnWriteArrayList<Listener>();

                return newListeners;

            }

        } ;

        final FutureTask<List<Listener>> ft = new FutureTask<List<Listener>>(refisterListenerTask);
        final Future<List<Listener>> t = cache.putIfAbsent(name, ft);

        final Future<List<Listener>> ret = t==null?(Future<List<Listener>>)service.submit(ft):t;
         return ret;
    }

    private void registerListner(Listener listener) throws InterruptedException {
        Thread.sleep(1000);
    }

    @Override
    public void removeListener(String name, Listener listner) throws ExecutionException, InterruptedException {
        //cache.remove(name); was like this before
        try {
            cache.get(name).get().remove(listner);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void notifyListeners(String name, Event event) {
        try {
            for(Listener l : cache.get(name).get()){
            l.onEvent(event);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
          final Throwable cause = e.getCause();
           if (cause instanceof SomeApplicationException){
           throw (SomeApplicationException) cause;//To change body of catch statement use File | Settings | File Templates.
           }                                      else{
               if (cause instanceof Error){
                   throw (Error) cause;
               }                       else if (cause instanceof RuntimeException){
                   throw (RuntimeException) cause;
               }
               else throw new IllegalStateException("not a runtime excption",cause);

           }
        }
    }
}
