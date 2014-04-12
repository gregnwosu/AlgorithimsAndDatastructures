package producerconsumeralgos;

import java.util.ArrayDeque;
import java.util.concurrent.locks.ReentrantLock;

class OldSkoolProducer<T> implements Runnable{

    private static final int MAXSIZE = 2;
    private static final int LOWEND = 1;
    private static final int RANGE=10;
    private final ArrayDeque<T> q;
    private final ReentrantLock lock;

    @Override
    public void run() {
        while(true){
            try {
                put();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    OldSkoolProducer(ArrayDeque<T> q , ReentrantLock lock) {
        this.q = q;
        this.lock = lock;
    }

    private  void put() throws InterruptedException {
        lock.lock();
        try{
            if (q.size() >= MAXSIZE){
                System.out.println("Q is full");

                    //q.wait();
            }         else{
            final T val = getData();
            System.out.println("produce:"+val+" size:"+q.size());
            if (q.offer(val)){

             //   q.notifyAll();
            }
            }
        }finally{
            lock.unlock();
        }

    }

    private <T> T getData() {
        return (T)Double.valueOf(RANGE * Math.random() + LOWEND);
    }


}


class OldSkoolConsumer<T> implements  Runnable{


    private final ArrayDeque<T> q;
    private final ReentrantLock lock;

    OldSkoolConsumer(ArrayDeque<T> q, ReentrantLock lock) {
        this.q = q;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            try {
                get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();;
            }
        }
    }


    private  void get() throws InterruptedException{
     lock.lock();
        try{
            while (q.size() == 0){
                q.wait();
            }
            final T val = q.poll();
            System.out.println("consume:"+val);

            q.notifyAll();
        }  finally{
            lock.unlock();
        }
    }

};


public class            OldSkoolProducerConsumer{

    public static void main(String [] args){
        ReentrantLock lock = new ReentrantLock();
        OldSkoolProducerConsumer x  = new OldSkoolProducerConsumer();
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        Thread p = new Thread(new OldSkoolProducer<Integer>(q,lock));
        Thread p2 = new Thread(new OldSkoolProducer<Integer>(q,lock));
        Thread c = new Thread(new OldSkoolConsumer<Integer>(q,lock));
        p.start();
        p2.start();
        c.start();
    }
}