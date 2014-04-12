package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 11/03/13
 * Time: 17:57
 * Proposition
 * Largest key is a[1], which is roott of binary tree
 * Can use array indicies to move through tree
 * Parent of node at k is k/2
 * Children of note at k are 2k and 2k+1
 */
/* in a binary tree we can get the first child by muliplying the current index
by 2 and the second child by k*2 +1
T best to keep keys immutable
Can make this q max or min orientated
simiralary the parent can be got by the rounded down division by 2 of any of the childrens index
 */
public class BinaryHeap<T extends Comparable> {

    int N = 0;

    public BinaryHeap() {

    }


    public  boolean isEmpty(){
        return N == 0;
    }
    private boolean less(int a, int b, T[] pq) {
        final int a0 = a-1;
        final int b0 = b -1;
        final T pqa = pq[a0];
        final T pqb = pq[b0];
        return  pqa.compareTo(pqb) < 0;
    }


    public void sort(T[] pq){
        N = pq.length;
        for  (int k=N/2; k>=1; k--) {
            System.out.println("k is "+k);
            sink(k,pq);
        }
        while(N > 1){
            exch(1, N,pq);
            sink(1,pq);
            N-=1;

        }
    }


    public void insert (T x, T[] pq){
        pq[++N] = x;
        swim(N,pq);
    }

    /**
     * exchange parent with larger child
     * repeat until heap order resotred
     *
     * @param k
     */
     void sink(int k, T[] pq){
         N=pq.length;
        while(2*k <= N){
            //j is the candidate child to swap
            int j = (2*k);
            //figure out which child is larger j or j++
            if (j < N && less(j, j+1, pq)){
                j++;
            }
            if (!less(k,j, pq)) break;
            exch(k,j, pq);
            k = j;
        }
    }


    //to delete the maximum from a heap we just remove the root (maximum)
    //and then restore heap order by sinking, generally we can exchange with the last element
    //reset the heap size to N-1, and set the last element to null in the array
    public T delMax(T[] pq){
        T max = pq[1];
        exch(1, N--, pq);
        sink(1, pq);
        pq[N+1]=null;
        return max;
    }

    private void exch(int a, int b, T[] pq) {
        int a0 = a - 1;
        int b0 = b-1;
        T tmp = pq[a0];
        pq[a0]= pq[b0];
        pq[b0] = tmp;
    }


    void swim(int k, T[] pq){
        while (k>1 && less(k/2,k ,pq) ){
           exch(k, k/2,pq);
            k=k/2;
        }

    }


}
