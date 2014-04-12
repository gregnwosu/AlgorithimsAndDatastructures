package producerconsumeralgos;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 19/02/13
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 */
 class Preloader{
    public static final int lowend = 1;
    public static final int range =100;
    private final Callable<Integer> getNum = new Callable<Integer>(){

        @Override
        public Integer call() throws Exception {
            return getNum();//To change body of implemented methods use File | Settings | File Templates.
        }
    }   ;
    private final FutureTask<Integer> ft = new FutureTask<Integer>(getNum);
    public int getNum(){
        return (int)(lowend +(Math.random()*range));
    }

    private final Thread thread =new  Thread(ft);
    public void start(){
        thread.start();
    }


    public Integer get() throws InterruptedException{
        try{
            return ft.get();
        }                       catch (ExecutionException ee){
            Throwable cause = ee.getCause();
            if (cause instanceof NullPointerException){
                throw  (NullPointerException) cause;
            }    else
            if (cause instanceof RuntimeException){
                throw (RuntimeException) cause;
            }else if (cause instanceof  Error){
                throw (Error )  cause;
            }
            else throw new IllegalStateException("not unchecked",cause);


        }
    }



}
