package sorts;import java.util.Arrays;

import static java.util.Collections.shuffle;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 06/03/13
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort<T extends Comparable> {


    private int partition(T[] a, int lo, int hi){
        int i = lo, j=hi+1;
        while(true){
            while(less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            while(less(a[lo], a[--j])){
                if (j==lo) break;
            }
            if (i>=j) break;
            exch(a,i,j);
        }
            exch(a,lo,j);
            return j;


    }

    public void sort(T[] a){
         shuffle(Arrays.asList(a));
        sort(a,0, a.length -1);
    }

    private void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private void exch(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] =a[j];
        a[j] = tmp;
    }

    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
}


