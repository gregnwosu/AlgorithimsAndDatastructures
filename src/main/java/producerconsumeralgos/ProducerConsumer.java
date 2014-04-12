package producerconsumeralgos;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 18/02/13
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
 class Producer<T> implements Runnable{




    private final BlockingQueue<T> bq ;
    private final int lowend =1;
    private final double range=100;

    public Producer(BlockingQueue<T> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try{
            while(true){
            produce();
            }
        }catch(InterruptedException ie){Thread.currentThread().interrupt();}

    }

    private void produce() throws InterruptedException {

            final T val = (T) getData();
            System.out.println("producer:"+val);
            bq.put(val);


    }

    private T getData() {
        return (T) Double.valueOf(lowend +(Math.random()*range));
    }
}

class Consumer<T> implements Runnable {

    private final BlockingQueue<T> bq;

    Consumer(BlockingQueue<T> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while(true){
        consume();
        }
    }

    private void consume() {

            try {
                System.out.println("consumer:"+bq.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();;
            }
    }
}

public class ProducerConsumer {
    ExecutorService service = Executors.newFixedThreadPool(2);
    BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(3);
    public static void main(String [] args){

        ProducerConsumer pd = new ProducerConsumer();
        Runnable p = new Producer(pd.bq);
        Runnable c = new Consumer(pd.bq);
        pd.service.execute(p);
        pd.service.execute(c);
    }

}
