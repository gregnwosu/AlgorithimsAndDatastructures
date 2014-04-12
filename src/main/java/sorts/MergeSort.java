package sorts; /**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 25/02/13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public  class  MergeSort {

    private static  <T> void merge(Comparable<T> a[],Comparable<T> aux[], int lo, int mid , int hi ){
        System.arraycopy(a,0,aux,0, a.length);

        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi ; k++){
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            //val i is less than val j
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];

        }
    }

    private static<T>

   boolean less(Comparable<T> a, Comparable<T> b) {
        return a.compareTo((T)b) < 0;
    }

    public static <T> void sort(Comparable<T> a[]){
        Comparable<T> aux[] = new Comparable[a.length];
        sort(a, aux, 0, a.length -1);
    }

    private static <T> void sort(Comparable<T>[] a, Comparable<T>[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a , aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
}
