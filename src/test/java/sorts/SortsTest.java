package sorts;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 11/03/13
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class SortsTest {



    @Test
    public void shouldMergeSort(){
        System.out.println("Merge sort");
        Integer[] unsorted = new Integer[]{9,93,4,6,6};
       MergeSort.sort(unsorted);
        for(int i : unsorted){
            System.out.println(i);
        }
        assertEquals(Integer.valueOf(93),unsorted[4]);
    }

    @Test
    public void shouldQuickSort(){
        System.out.println("Quick Sort");
        Integer[] unsorted = new Integer[]{9,93,4,6,6};
        QuickSort<Integer> qs = new QuickSort<Integer>();
        qs.sort(unsorted);
        for(int i : unsorted){
            System.out.println(i);
        }
        assertEquals(Integer.valueOf(93),unsorted[4]);
    }







}
