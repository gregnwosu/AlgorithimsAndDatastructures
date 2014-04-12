package producerconsumeralgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 21/02/13
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class FutureWorker {

    private final ExecutorService executor= Executors.newCachedThreadPool();


    private List<Integer> getWorkDetail(String infoLocation) {
        return Arrays.asList(new Integer[]{0,1,2,3});
    }

    void doWork(String infoLocation) throws MyCheckedException {
        final List<Integer> workInfo = getWorkDetail(infoLocation);
        Callable<List<String>>  task = getCallable(workInfo);
        Future<List<String>> future = executor.submit(task);
        startSomeOtherWork(infoLocation);
        try {
            final List<String> resultData = future.get();
            for(String datum : resultData) {
                process(datum);
            }
        } catch (InterruptedException e) {
            //Reassert the threads interrupted status
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            final Throwable cause = e.getCause();
            if (cause instanceof MyCheckedException){
                throw (MyCheckedException) cause;

            }                                          else
            {
                if (cause instanceof RuntimeException){
                    throw (RuntimeException)cause;

                }
                else if (cause instanceof Error){
                throw (Error) cause;

            }       else {
                    throw new IllegalStateException("not a runtime exception", cause);
                }
            }
        }
    }

    private void process(String datum) {
    }

    private void startSomeOtherWork(String infoLocation) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private Callable<List<String>> getCallable(final List<Integer> workInfo) {
        return new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                 List<String> result = new ArrayList<String>();
                for (int workItem : workInfo){
                    result.add(workItem + ": completed");
                }
                return result;
            }
        };
    }
}
